/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pancost.traveller.universe.builder;

import java.util.ArrayList;
import com.pancost.dice.Dice;
import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.TransactionalGraph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.neo4j.Neo4jGraph;

/**
 *
 * @author Brandon
 */
public class TravellerUniverseBuilder extends TravellerUniverse{

    private static final int NUM_PLANETS = 50;
    private ArrayList<Vertex> planetList = new ArrayList<>();
    private TransactionalGraph graph;

    public TravellerUniverseBuilder(){
        graph = new Neo4jGraph("C:/traveller/graphdb");

        System.out.println("Cleaning up before creating a new universe.");
        graph.clear();
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
        
        graph.setMaxBufferSize(0);

        System.out.println("Generating Size Descriptors");
        generateSizeDescriptorNodes(graph);
        System.out.println("Generating Atmosphere Descriptors");
        generateAtmosphereDescriptorNodes(graph);
        System.out.println("Generating Temperature Descriptors");
        generateTemperatureDescriptorNodes(graph);
        System.out.println("Generating Hydrographic Descriptors");
        generateHydrographicDescriptorNodes(graph);
        System.out.println("Generating Population Descriptors");
        generatePopulationDescriptorNodes(graph);
        System.out.println("Generating Government Descriptors");
        generateGovernmentDescriptorNodes(graph);
        System.out.println("Generating Law Descriptors");
        generateLawDescriptorNodes(graph);
        System.out.println("Generating Starport Descriptors");
        generateStarportDescriptorNodes(graph);
        System.out.println("Generating Tech Level Descriptors");
        generateTechLevelDescriptorNodes(graph);

        System.out.println("Creating new planets");
        
        graph.startTransaction();
        Vertex root = graph.addVertex(UtilityTypes.Root.getProperty());
        
        Vertex planets = graph.addVertex(UtilityTypes.Planet.getProperty());
        
        graph.addEdge("RootToPlanets", root, planets, UtilityTypes.Root.getProperty());
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
        
        for(int i = 0; i < NUM_PLANETS; ++i){
            Vertex planet = generatePlanet(graph);
            graph.startTransaction();
            graph.addEdge(null, planets, planet, UtilityTypes.Planet.getProperty());
            graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
            planetList.add(planet);
        }

        System.out.println("Creating trade routes");
        
        graph.startTransaction();
        for(Vertex planet: planetList){
            int modifier = 0;
            Edge toStarportNode = planet.getOutEdges(PlanetRelationshipTypes.Starport.getProperty()).iterator().next();
            Vertex starportNode = toStarportNode.getInVertex();
            if(starportNode.getProperty(PlanetProperties.STARPORT_QUALITY.getProperty()).equals("Excellent")){
                ++modifier;
            }
            Edge toTechNode = planet.getOutEdges(PlanetRelationshipTypes.TechLevel.getProperty()).iterator().next();
            Vertex techNode = toTechNode.getInVertex();
            String techDesignation = (String)techNode.getProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty());
            if(techDesignation.equals("Average Stellar") || techDesignation.equals("High Stellar")){
                ++modifier;
            }
            if(techDesignation.equals("Unknown")){
                modifier += 2;
            }
            Edge toSizeNode = planet.getOutEdges(PlanetRelationshipTypes.Size.getProperty()).iterator().next();
            Vertex sizeNode = toSizeNode.getInVertex();
            if(Double.parseDouble((String)sizeNode.getProperty(PlanetProperties.SURFACE_GRAVITY.getProperty())) >= 1.4d){
                ++modifier;
            }
            int num_shifts = Dice.quickRoll(1, 3, modifier);

            for(int i = 0; i < num_shifts; i++){
                Vertex destinationPlanet;
                do{
                    int index = (new Double(Math.floor(Math.random()*NUM_PLANETS))).intValue();
                    destinationPlanet = planetList.get(index);
                }while(planet.equals(destinationPlanet));//This guarantees that they don't go back to the same place. Maybe I would want that though?
                
                Edge shift = graph.addEdge(null, planet, destinationPlanet, ShiftTypes.Shift.getProperty());
            }
        }
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
        graph.shutdown();
    }

    

    private Vertex generatePlanet(TransactionalGraph graph) {
        Vertex planet;
        
        graph.startTransaction();
        planet = graph.addVertex(null);
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
        char starportClass;
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
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
        
        return planet;
    }

    private int generatePlanetTechLevel(int tldm, int atmosphereRoll, Vertex planet) {
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
        Edge relationship = graph.addEdge(null, planet, techLevel[techLevelRoll], PlanetRelationshipTypes.TechLevel.getProperty());
        return techLevelRoll;
    }

    private int generatePlanetStarport(Vertex planet) {
        int starportRoll = Dice.quickRoll(2, 6);
        Edge relationship = graph.addEdge(null, planet, starport[starportRoll], PlanetRelationshipTypes.Starport.getProperty());
        return starportRoll;
    }

    private int generatePlanetLaw(int governmentRoll, Vertex planet) {
        int lawRoll = Dice.quickRoll(2, 6, -7) + governmentRoll;
        if(lawRoll > 9){
            lawRoll = 9;
        }else if(lawRoll < 0){
            lawRoll = 0;
        }
        
        Edge relationship = graph.addEdge(null, planet, law[lawRoll], PlanetRelationshipTypes.Law.getProperty());
        return lawRoll;
    }

    private int generatePlanetGovernment(int populationRoll, Vertex planet) {
        int governmentRoll =  Dice.quickRoll(2, 6, -7) + populationRoll;
        if(governmentRoll < 0){
            governmentRoll = 0;
        }
        if(governmentRoll > 13){
            governmentRoll = 13;
        }
        Edge relationship = graph.addEdge(null, planet, government[governmentRoll], PlanetRelationshipTypes.Government.getProperty());
        return governmentRoll;
    }

    private int generatePlanetPopulation(Vertex planet) {
        int populationRoll =  Dice.quickRoll(2, 6, -2);
        Edge relationship = graph.addEdge(null, planet, population[populationRoll], PlanetRelationshipTypes.Population.getProperty());
        return populationRoll;
    }

    private int generatePlanetHydrographics(int planetSizeRoll, int atmosphereRoll, int temperatureRoll, Vertex planet) {
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
        Edge relationship = graph.addEdge(null, planet, hydrographics[hydroGraphicsRoll], PlanetRelationshipTypes.Hydrographics.getProperty());
        return hydroGraphicsRoll;
    }

    private int generatePlanetTemperature(int atmosphereRoll, Vertex planet) {
        int temperatureRoll;
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
        Edge relationship = graph.addEdge(null, planet, temperature[temperatureRoll], PlanetRelationshipTypes.Temperature.getProperty());
        return temperatureRoll;
    }

    private int generatePlanetAtmosphere(int planetSizeRoll, Vertex planet) {
        int atmosphereRoll = Dice.quickRoll(2, 6, -7) + planetSizeRoll;
        if (atmosphereRoll < 0) {
            atmosphereRoll = 0;
        }
        Edge relationship = graph.addEdge(null, planet, atmosphere[atmosphereRoll], PlanetRelationshipTypes.Atmosphere.getProperty());
        return atmosphereRoll;
    }

    private int generatePlanetSize(Vertex planet) {
        int planetSize = Dice.quickRoll(2, 6, -2);
        Edge relationship = graph.addEdge(null, planet, size[planetSize], PlanetRelationshipTypes.Size.getProperty());
        return planetSize;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TravellerUniverseBuilder tub = new TravellerUniverseBuilder();
    }

}
