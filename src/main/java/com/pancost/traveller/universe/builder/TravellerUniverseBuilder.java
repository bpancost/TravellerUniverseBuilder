/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pancost.traveller.universe.builder;

import java.util.ArrayList;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import com.pancost.dice.Dice;

/**
 *
 * @author Brandon
 */
public class TravellerUniverseBuilder extends TravellerUniverse{

    private static final int NUM_PLANETS = 5000;
    private ArrayList<Node> planetList = new ArrayList<Node>();

    public TravellerUniverseBuilder(){
        GraphDatabaseService graphDB = new EmbeddedGraphDatabase("C:/traveller/graphdb");

        Transaction tx = graphDB.beginTx();
        try{
            System.out.println("Cleaning up before creating a new universe.");
            for(Node n : graphDB.getAllNodes()){
                for(Relationship r : n.getRelationships()){
                    r.delete();//Seems I have to delete the relationships first.
                }
                if(n.getId() != 0){
                    n.delete();//Now it is safe to delete the node itself.
                }
            }
            tx.success();
        }finally{
            tx.finish();
        }

        System.out.println("Generating Size Descriptors");
        generateSizeDescriptorNodes(graphDB);
        System.out.println("Generating Atmosphere Descriptors");
        generateAtmosphereDescriptorNodes(graphDB);
        System.out.println("Generating Temperature Descriptors");
        generateTemperatureDescriptorNodes(graphDB);
        System.out.println("Generating Hydrographic Descriptors");
        generateHydrographicDescriptorNodes(graphDB);
        System.out.println("Generating Population Descriptors");
        generatePopulationDescriptorNodes(graphDB);
        System.out.println("Generating Government Descriptors");
        generateGovernmentDescriptorNodes(graphDB);
        System.out.println("Generating Law Descriptors");
        generateLawDescriptorNodes(graphDB);
        System.out.println("Generating Starport Descriptors");
        generateStarportDescriptorNodes(graphDB);
        System.out.println("Generating Tech Level Descriptors");
        generateTechLevelDescriptorNodes(graphDB);

        System.out.println("Creating new planets");
        Node root = graphDB.getReferenceNode();
        tx = graphDB.beginTx();
        Node planets = graphDB.createNode();
        try{    
            root.createRelationshipTo(planets, UtilityTypes.ROOT);
            for(int i = 0; i < NUM_PLANETS; i++){
                Node planet = generatePlanet(graphDB);
                planets.createRelationshipTo(planet, UtilityTypes.PLANET);
                planetList.add(planet);
            }
            tx.success();
        }finally{
            tx.finish();
        }

        System.out.println("Creating trade routes");
        tx = graphDB.beginTx();
        try{
            for(Node planet: planetList){
                int modifier = 0;
                Node starportNode = planet.getSingleRelationship(PlanetRelationshipTypes.STARPORT, Direction.BOTH).getOtherNode(planet);
                if(starportNode.getProperty(PlanetProperties.STARPORT_QUALITY.getProperty()).equals("Excellent")){
                    ++modifier;
                }
                Node techNode = planet.getSingleRelationship(PlanetRelationshipTypes.TECH_LEVEL, Direction.BOTH).getOtherNode(planet);
                String techDesignation = (String)techNode.getProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty());
                if(techDesignation.equals("Average Stellar") || techDesignation.equals("High Stellar")){
                    ++modifier;
                }
                if(techDesignation.equals("Unknown")){
                    modifier += 2;
                }
                Node sizeNode = planet.getSingleRelationship(PlanetRelationshipTypes.SIZE, Direction.BOTH).getOtherNode(planet);
                if(Double.parseDouble((String)sizeNode.getProperty(PlanetProperties.SURFACE_GRAVITY.getProperty())) >= 1.4){
                    ++modifier;
                }
                int num_shifts = Dice.quickRoll(1, 3, modifier);

                for(int i = 0; i < num_shifts; i++){
                    Node destinationPlanet;
                    do{
                        int index = (new Double(Math.floor(Math.random()*NUM_PLANETS))).intValue();
                        destinationPlanet = planetList.get(index);
                    }while(planet.equals(destinationPlanet));//This guarantees that they don't go back to the same place. Maybe I would want that though?

                    planet.createRelationshipTo(destinationPlanet, ShiftTypes.Shift);
                }
            }
            tx.success();
        }finally{
            tx.finish();
        }
        graphDB.shutdown();
    }

    

    private Node generatePlanet(GraphDatabaseService graphDB) {
        Node planet;
        Transaction tx = graphDB.beginTx();
        try{
            planet = graphDB.createNode();
            int planetSizeRoll = generatePlanetSize(planet);
            int atmosphereRoll = generatePlanetAtmosphere(planetSizeRoll, planet);
            int temperatureRoll = generatePlanetTemperature(atmosphereRoll, planet);
            int hydroGraphicsRoll = generatePlanetHydrographics(planetSizeRoll, atmosphereRoll, temperatureRoll, planet);
            int populationRoll = generatePlanetPopulation(planet);
            int governmentRoll = generatePlanetGovernment(populationRoll, planet);
            /*int factionRoll = 0;//add later as flavor text?
            switch(governmentRoll){
                case 0:
                case 7:
            }*/
            int lawRoll = generatePlanetLaw(governmentRoll, planet);
            int starportRoll = generatePlanetStarport(planet);
            char starportClass = 'X';
            switch(starportRoll){
                case 3:
                case 4:
                    starportClass = 'E';
                    break;
                case 5:
                case 6:
                    starportClass = 'D';
                    break;
                case 7:
                case 8:
                    starportClass = 'C';
                    break;
                case 9:
                case 10:
                    starportClass = 'B';
                    break;
                case 11:
                case 12:
                    starportClass = 'A';
                    break;
                default:
                    starportClass = 'X';
            }
            int tldm = 0;
            switch(starportClass){
                case 'A':
                    tldm += 6;
                    break;
                case 'B':
                    tldm += 4;
                    break;
                case 'C':
                    tldm += 2;
                    break;
                case 'X':
                    tldm -= 4;
                    break;
            }
            switch(planetSizeRoll){
                case 0:
                case 1:
                    tldm += 2;
                    break;
                case 2:
                case 3:
                case 4:
                    tldm += 1;
                    break;
            }
            switch(atmosphereRoll){
                case 0:
                case 1:
                case 2:
                case 3:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    tldm += 1;
                    break;
            }
            switch(hydroGraphicsRoll){
                case 0:
                case 9:
                    tldm += 1;
                    break;
                case 10:
                    tldm += 2;
                    break;
            }
            switch(populationRoll){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 9:
                    tldm += 1;
                    break;
                case 10:
                    tldm+= 2;
                    break;
                case 11:
                    tldm += 3;
                    break;
                case 12:
                    tldm += 4;
                    break;
            }
            switch(governmentRoll){
                case 0:
                case 5:
                    tldm += 1;
                    break;
                case 7:
                    tldm += 2;
                    break;
                case 13:
                case 14:
                    tldm -= 2;
                    break;
            }
            int techLevelRoll = generatePlanetTechLevel(tldm, atmosphereRoll, planet);
            String planetSizeIndex = "";
            switch(planetSizeRoll){
                case 10:
                    planetSizeIndex = "A";
                    break;
                default:
                    planetSizeIndex += planetSizeRoll;
                    break;
            }

            String atmosphereIndex = "";
            switch(atmosphereRoll){
                case 10:
                    atmosphereIndex = "A";
                    break;
                case 11:
                    atmosphereIndex = "B";
                    break;
                case 12:
                    atmosphereIndex = "C";
                    break;
                case 13:
                    atmosphereIndex = "D";
                    break;
                case 14:
                    atmosphereIndex = "E";
                    break;
                case 15:
                    atmosphereIndex = "F";
                    break;
                default:
                    atmosphereIndex += atmosphereRoll;
                    break;
            }

            String hydrographicsIndex = "";
            switch(hydroGraphicsRoll){
                case 10:
                    hydrographicsIndex = "A";
                    break;
                default:
                    hydrographicsIndex += hydroGraphicsRoll;
                    break;
            }

            String populationIndex = "";
            switch(populationRoll){
                case 10:
                    populationIndex = "A";
                    break;
                case 11:
                    populationIndex = "B";
                    break;
                case 12:
                    populationIndex = "C";
                    break;
                default:
                    populationIndex += populationRoll;
                    break;
            }

            if(governmentRoll < 0){
                governmentRoll = 0;
            }
            String governmentIndex = "";
            switch(governmentRoll){
                case 10:
                    governmentIndex = "A";
                    break;
                case 11:
                    governmentIndex = "B";
                    break;
                case 12:
                    governmentIndex = "C";
                    break;
                case 13:
                    governmentIndex = "D";
                    break;
                default:
                    governmentIndex += governmentRoll;
                    break;
            }

            String designation = starportClass + planetSizeIndex + atmosphereIndex + hydrographicsIndex + populationIndex + governmentIndex + lawRoll + "-" + techLevelRoll;
            planet.setProperty(PlanetProperties.DESIGNATION.getProperty(), designation);
            tx.success();
        }finally{
            tx.finish();
        }
        return planet;
    }

    private int generatePlanetTechLevel(int tldm, int atmosphereRoll, Node planet) {
        int techLevelRoll = Dice.quickRoll(1, 6, tldm);
        switch (atmosphereRoll) {
            case 0:
            case 1:
            case 10:
            case 15:
                if (techLevelRoll < 8) {
                    techLevelRoll = 8;
                }
                break;
            case 2:
            case 3:
            case 13:
            case 14:
                if (techLevelRoll < 5) {
                    techLevelRoll = 5;
                }
                break;
            case 4:
            case 7:
            case 9:
                if (techLevelRoll < 3) {
                    techLevelRoll = 3;
                }
                break;
            case 11:
                if (techLevelRoll < 9) {
                    techLevelRoll = 9;
                }
                break;
            case 12:
                if (techLevelRoll < 10) {
                    techLevelRoll = 10;
                }
                break;
        }
        if(techLevelRoll < 0){
            techLevelRoll = 0;
        }
        Relationship relationship = planet.createRelationshipTo(techLevel[techLevelRoll], PlanetRelationshipTypes.TECH_LEVEL);
        return techLevelRoll;
    }

    private int generatePlanetStarport(Node planet) {
        int starportRoll = Dice.quickRoll(2, 6);
        Relationship relationship = planet.createRelationshipTo(starport[starportRoll], PlanetRelationshipTypes.STARPORT);
        return starportRoll;
    }

    private int generatePlanetLaw(int governmentRoll, Node planet) {
        int lawRoll = Dice.quickRoll(2, 6, -7) + governmentRoll;
        if(lawRoll > 9){
            lawRoll = 9;
        }else if(lawRoll < 0){
            lawRoll = 0;
        }
        Relationship relationship = planet.createRelationshipTo(law[lawRoll], PlanetRelationshipTypes.LAW);
        return lawRoll;
    }

    private int generatePlanetGovernment(int populationRoll, Node planet) {
        int governmentRoll =  Dice.quickRoll(2, 6, -7) + populationRoll;
        if(governmentRoll < 0){
            governmentRoll = 0;
        }
        if(governmentRoll > 13){
            governmentRoll = 13;
        }
        Relationship relationship = planet.createRelationshipTo(government[governmentRoll], PlanetRelationshipTypes.GOVERNMENT);
        return governmentRoll;
    }

    private int generatePlanetPopulation(Node planet) {
        int populationRoll =  Dice.quickRoll(2, 6, -2);
        Relationship relationship = planet.createRelationshipTo(population[populationRoll], PlanetRelationshipTypes.POPULATION);
        return populationRoll;
    }

    private int generatePlanetHydrographics(int planetSizeRoll, int atmosphereRoll, int temperatureRoll, Node planet) {
        int hydroGraphicsRoll;
        if (planetSizeRoll == 0 || planetSizeRoll == 1) {
            hydroGraphicsRoll = 0;
        } else {
            int dm = 0;
            switch (atmosphereRoll) {
                case 0:
                case 1:
                case 10:
                case 11:
                case 12:
                    dm -= 4;
                    break;
            }
            if (atmosphereRoll != 13) {
                if (temperatureRoll >= 10) {
                    if (temperatureRoll >= 12) {
                        dm -= 6;
                    } else {
                        dm -= 2;
                    }
                }
            }
            dm -= 7;
            hydroGraphicsRoll = Dice.quickRoll(2, 6, dm) + planetSizeRoll;
        }
        if(hydroGraphicsRoll < 0){
            hydroGraphicsRoll = 0;
        }
        if(hydroGraphicsRoll > 10){
            hydroGraphicsRoll = 10;
        }
        Relationship relationship = planet.createRelationshipTo(hydrographics[hydroGraphicsRoll], PlanetRelationshipTypes.HYDROGRAPHICS);
        return hydroGraphicsRoll;
    }

    private int generatePlanetTemperature(int atmosphereRoll, Node planet) {
        int temperatureRoll = 0;
        switch (atmosphereRoll) {
            case 0:
            case 1:
                temperatureRoll = Dice.quickRoll(2, 6, 0);
                break;
            case 2:
            case 3:
                temperatureRoll = Dice.quickRoll(2, 6, -2);
                break;
            case 4:
            case 5:
            case 14:
                temperatureRoll = Dice.quickRoll(2, 6, -1);
                break;
            case 6:
            case 7:
                temperatureRoll = Dice.quickRoll(2, 6, 0);
                break;
            case 8:
            case 9:
                temperatureRoll = Dice.quickRoll(2, 6, 1);
                break;
            case 10:
            case 13:
            case 15:
                temperatureRoll = Dice.quickRoll(2, 6, 2);
                break;
            case 11:
            case 12:
                temperatureRoll = Dice.quickRoll(2, 6, 3);
                break; //also case of far from star is -4dm
            default:
                System.err.println("Bad value for atmosphere: " + atmosphereRoll);
                return -1;
        }
        Relationship relationship = planet.createRelationshipTo(temperature[temperatureRoll], PlanetRelationshipTypes.TEMPERATURE);
        return temperatureRoll;
    }

    private int generatePlanetAtmosphere(int planetSizeRoll, Node planet) {
        int atmosphereRoll = Dice.quickRoll(2, 6, -7) + planetSizeRoll;
        if (atmosphereRoll < 0) {
            atmosphereRoll = 0;
        }
        Relationship relationship = planet.createRelationshipTo(atmosphere[atmosphereRoll], PlanetRelationshipTypes.ATMOSPHERE);
        return atmosphereRoll;
    }

    private int generatePlanetSize(Node planet) {
        int planetSize = Dice.quickRoll(2, 6, -2);
        Relationship relationship = planet.createRelationshipTo(size[planetSize], PlanetRelationshipTypes.SIZE);
        return planetSize;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TravellerUniverseBuilder tub = new TravellerUniverseBuilder();
    }

}
