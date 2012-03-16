package com.pancost.traveller.universe.builder;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.TransactionalGraph;
import com.tinkerpop.blueprints.pgm.Vertex;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Brandon Pancost
 */
public abstract class TravellerUniverse implements TravellerConstants{
    Vertex size[] = new Vertex[11];//Yes, I'm going old school and using an array.
    Vertex atmosphere[] = new Vertex[16];//I know all the table sizes, so why not?
    Vertex temperature[] = new Vertex[16];
    Vertex hydrographics[] = new Vertex[11];
    Vertex population[] = new Vertex[13];
    Vertex government[] = new Vertex[14];
    Vertex law[] = new Vertex[10];
    Vertex starport[] = new Vertex[13];
    Vertex techLevel[] = new Vertex[20];

    protected void generateSizeDescriptorNodes(TransactionalGraph graph){
        graph.startTransaction();
        size[0] = graph.addVertex(null);
        size[0].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "800km");
        size[0].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "0");

        size[1] = graph.addVertex(null);
        size[1].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "1600km");
        size[1].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "0.05");

        size[2] = graph.addVertex(null);
        size[2].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "3200km");
        size[2].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "0.15");

        size[3] = graph.addVertex(null);
        size[3].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "4800km");
        size[3].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "0.25");

        size[4] = graph.addVertex(null);
        size[4].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "6400km");
        size[4].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "0.35");

        size[5] = graph.addVertex(null);
        size[5].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "8000km");
        size[5].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "0.45");

        size[6] = graph.addVertex(null);
        size[6].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "9600km");
        size[6].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "0.7");

        size[7] = graph.addVertex(null);
        size[7].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "11200");
        size[7].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "0.9");

        size[8] = graph.addVertex(null);
        size[8].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "12800km");
        size[8].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "1.0");

        size[9] = graph.addVertex(null);
        size[9].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "14400km");
        size[9].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "1.25");

        size[10] = graph.addVertex(null);
        size[10].setProperty(PlanetProperties.WORLD_SIZE.getProperty(), "16000km");
        size[10].setProperty(PlanetProperties.SURFACE_GRAVITY.getProperty(), "1.4");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }

    protected void generateAtmosphereDescriptorNodes(TransactionalGraph graph){
        graph.startTransaction();
        atmosphere[0] = graph.addVertex(null);
        atmosphere[0].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "None");
        atmosphere[0].setProperty(PlanetProperties.PRESSURE.getProperty(), "0.00");
        atmosphere[0].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Vacc Suit");

        atmosphere[1] = graph.addVertex(null);
        atmosphere[1].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Trace");
        atmosphere[1].setProperty(PlanetProperties.PRESSURE.getProperty(), "0.01 - 0.09");
        atmosphere[1].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Vacc Suit");

        atmosphere[2] = graph.addVertex(null);
        atmosphere[2].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Very Thin, Tainted");
        atmosphere[2].setProperty(PlanetProperties.PRESSURE.getProperty(), "0.1 - 0.42");
        atmosphere[2].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Respirator, Filter");

        atmosphere[3] = graph.addVertex(null);
        atmosphere[3].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Very Thin");
        atmosphere[3].setProperty(PlanetProperties.PRESSURE.getProperty(), "0.1 - 0.42");
        atmosphere[3].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Respirator");

        atmosphere[4] = graph.addVertex(null);
        atmosphere[4].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Thin, Tainted");
        atmosphere[4].setProperty(PlanetProperties.PRESSURE.getProperty(), "0.43 - 0.7");
        atmosphere[4].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Filter");

        atmosphere[5] = graph.addVertex(null);
        atmosphere[5].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Thin");
        atmosphere[5].setProperty(PlanetProperties.PRESSURE.getProperty(), "0.43 - 0.7");
        atmosphere[5].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "None");

        atmosphere[6] = graph.addVertex(null);
        atmosphere[6].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Standard");
        atmosphere[6].setProperty(PlanetProperties.PRESSURE.getProperty(), "0.71 - 1.49");
        atmosphere[6].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "None");

        atmosphere[7] = graph.addVertex(null);
        atmosphere[7].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Standard, Tainted");
        atmosphere[7].setProperty(PlanetProperties.PRESSURE.getProperty(), "0.71 - 1.49");
        atmosphere[7].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Filter");

        atmosphere[8] = graph.addVertex(null);
        atmosphere[8].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Dense");
        atmosphere[8].setProperty(PlanetProperties.PRESSURE.getProperty(), "1.5 - 2.49");
        atmosphere[8].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "None");

        atmosphere[9] = graph.addVertex(null);
        atmosphere[9].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Dense, Tainted");
        atmosphere[9].setProperty(PlanetProperties.PRESSURE.getProperty(), "1.5 - 2.49");
        atmosphere[9].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Filter");

        atmosphere[10] = graph.addVertex(null);
        atmosphere[10].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Exotic");
        atmosphere[10].setProperty(PlanetProperties.PRESSURE.getProperty(), "Varies");
        atmosphere[10].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Air Supply");

        atmosphere[11] = graph.addVertex(null);
        atmosphere[11].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Corrosive");
        atmosphere[11].setProperty(PlanetProperties.PRESSURE.getProperty(), "Varies");
        atmosphere[11].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Vacc Suit");

        atmosphere[12] = graph.addVertex(null);
        atmosphere[12].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Insidious");
        atmosphere[12].setProperty(PlanetProperties.PRESSURE.getProperty(), "Varies");
        atmosphere[12].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Vacc Suit");

        atmosphere[13] = graph.addVertex(null);
        atmosphere[13].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Dense, High");
        atmosphere[13].setProperty(PlanetProperties.PRESSURE.getProperty(), "2.5+");
        atmosphere[13].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "None");

        atmosphere[14] = graph.addVertex(null);
        atmosphere[14].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Thin, Low");
        atmosphere[14].setProperty(PlanetProperties.PRESSURE.getProperty(), "0.00 - 0.5");
        atmosphere[14].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "None");

        atmosphere[15] = graph.addVertex(null);
        atmosphere[15].setProperty(PlanetProperties.ATMOSPHERE.getProperty(), "Unusual");
        atmosphere[15].setProperty(PlanetProperties.PRESSURE.getProperty(), "Varies");
        atmosphere[15].setProperty(PlanetProperties.SURVIVAL_GEAR_REQUIRED.getProperty(), "Varies");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }

    protected void generateTemperatureDescriptorNodes(TransactionalGraph graph){
        graph.startTransaction();
        temperature[0] = graph.addVertex(null);
        temperature[0].setProperty(PlanetProperties.TEMPERATURE_TYPE.getProperty(), "Frozen");
        temperature[0].setProperty(PlanetProperties.AVERAGE_TEMPERATURE.getProperty(), "-51C or less");
        temperature[0].setProperty(PlanetProperties.TEMPERATURE_DESCRIPTION.getProperty(), "Frozen world. No liquid water, very dry atmosphere.");
        temperature[1] = temperature[0];
        temperature[2] = temperature[0];

        temperature[3] = graph.addVertex(null);
        temperature[3].setProperty(PlanetProperties.TEMPERATURE_TYPE.getProperty(), "Cold");
        temperature[3].setProperty(PlanetProperties.AVERAGE_TEMPERATURE.getProperty(), "-51C - 0C");
        temperature[3].setProperty(PlanetProperties.TEMPERATURE_DESCRIPTION.getProperty(), "Icy world. Little liquid water, extensive ice caps, few clouds.");
        temperature[4] = temperature[3];

        temperature[5] = graph.addVertex(null);
        temperature[5].setProperty(PlanetProperties.TEMPERATURE_TYPE.getProperty(), "Temperate");
        temperature[5].setProperty(PlanetProperties.AVERAGE_TEMPERATURE.getProperty(), "0C - 30C");
        temperature[5].setProperty(PlanetProperties.TEMPERATURE_DESCRIPTION.getProperty(), "Temperate world. Earthlike. Liquid and vaporised water are common, moderate ice caps.");
        temperature[6] = temperature[5];
        temperature[7] = temperature[5];
        temperature[8] = temperature[5];
        temperature[9] = temperature[5];

        temperature[10] = graph.addVertex(null);
        temperature[10].setProperty(PlanetProperties.TEMPERATURE_TYPE.getProperty(), "Hot");
        temperature[10].setProperty(PlanetProperties.AVERAGE_TEMPERATURE.getProperty(), "31C - 80C");
        temperature[10].setProperty(PlanetProperties.TEMPERATURE_DESCRIPTION.getProperty(), "Hot world. Small or no ice caps, little liquid water. Most water in the form of clouds.");
        temperature[11] = temperature[10];

        temperature[12] = graph.addVertex(null);
        temperature[12].setProperty(PlanetProperties.TEMPERATURE_TYPE.getProperty(), "Hot");
        temperature[12].setProperty(PlanetProperties.AVERAGE_TEMPERATURE.getProperty(), "81C or greater");
        temperature[12].setProperty(PlanetProperties.TEMPERATURE_DESCRIPTION.getProperty(), "Boiling world. No ice caps, little liquid water.");
        temperature[13] = temperature[12];
        temperature[14] = temperature[12];
        temperature[15] = temperature[12];
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }

    protected void generateHydrographicDescriptorNodes(TransactionalGraph graph){
        graph.startTransaction();
        hydrographics[0] = graph.addVertex(null);
        hydrographics[0].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "0%-5%");
        hydrographics[0].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "Desert world");

        hydrographics[1] = graph.addVertex(null);
        hydrographics[1].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "6%-15%");
        hydrographics[1].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "Dry world");

        hydrographics[2] = graph.addVertex(null);
        hydrographics[2].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "16%-25%");
        hydrographics[2].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "A few small seas");

        hydrographics[3] = graph.addVertex(null);
        hydrographics[3].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "26%-35%");
        hydrographics[3].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "Small seas and oceans");

        hydrographics[4] = graph.addVertex(null);
        hydrographics[4].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "36%-45%");
        hydrographics[4].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "Wet world");

        hydrographics[5] = graph.addVertex(null);
        hydrographics[5].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "46%-55%");
        hydrographics[5].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "Large oceans");

        hydrographics[6] = graph.addVertex(null);
        hydrographics[6].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "56%-65%");
        hydrographics[6].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "Large oceans");

        hydrographics[7] = graph.addVertex(null);
        hydrographics[7].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "66%-75%");
        hydrographics[7].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "Earth-like world");

        hydrographics[8] = graph.addVertex(null);
        hydrographics[8].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "76%-85%");
        hydrographics[8].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "Water world");

        hydrographics[9] = graph.addVertex(null);
        hydrographics[9].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "86%-95%");
        hydrographics[9].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "Only a few small islands and archipelagos");

        hydrographics[10] = graph.addVertex(null);
        hydrographics[10].setProperty(PlanetProperties.HYDROGRAPHIC_PERCENTAGE.getProperty(), "96%-100%");
        hydrographics[10].setProperty(PlanetProperties.HYDROGRAPHIC_DESCRIPTION.getProperty(), "Almost entirely water");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }

    protected void generatePopulationDescriptorNodes(TransactionalGraph graph){
        graph.startTransaction();
        population[0] = graph.addVertex(null);
        population[0].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "0");
        population[0].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "Uninhabited");

        population[1] = graph.addVertex(null);
        population[1].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "1-99");
        population[1].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "A tiny farmstead or a single family.");

        population[2] = graph.addVertex(null);
        population[2].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "100-999");
        population[2].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "A village");

        population[3] = graph.addVertex(null);
        population[3].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "1,000-9,999");
        population[3].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "A few villages");

        population[4] = graph.addVertex(null);
        population[4].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "10,000-99,999");
        population[4].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "Small town");

        population[5] = graph.addVertex(null);
        population[5].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "100,000-999,999");
        population[5].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "Average city");

        population[6] = graph.addVertex(null);
        population[6].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "1,000,000-9,999,999");
        population[6].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "A few average cities");

        population[7] = graph.addVertex(null);
        population[7].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "10,000,000-99,999,999");
        population[7].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "Large city");

        population[8] = graph.addVertex(null);
        population[8].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "100,000,000-999,999,999");
        population[8].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "A few large cities");

        population[9] = graph.addVertex(null);
        population[9].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "1,000,000,000-9,999,999,999");
        population[9].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "Present day Earth");

        population[10] = graph.addVertex(null);
        population[10].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "10,000,000,000-99,999,999,999");
        population[10].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "Crowded world");

        population[11] = graph.addVertex(null);
        population[11].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "100,000,000,000-999,999,999,999");
        population[11].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "Incredibly crowded world");

        population[11] = graph.addVertex(null);
        population[11].setProperty(PlanetProperties.POPULATION_RANGE.getProperty(), "1,000,000,000,000 and greater");
        population[11].setProperty(PlanetProperties.POPULATION_DESCRIPTION.getProperty(), "World-city");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }

    protected void generateGovernmentDescriptorNodes(TransactionalGraph graph){
        graph.startTransaction();
        government[0] = graph.addVertex(null);
        government[0].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "None");
        government[0].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "No government struction. In many cases, family bonds predominate.");
        government[0].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Family, Clan, Anarchy");
        government[0].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "None");

        government[1] = graph.addVertex(null);
        government[1].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Company/Corporation");
        government[1].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are assumed by a company managerial elite, and most citizenry are company employees or dependants.");
        government[1].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Corporate outpost, asteroid mine, feudal domain");
        government[1].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Weapons, Drugs, Travellers");

        government[2] = graph.addVertex(null);
        government[2].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Participating democracy");
        government[2].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are reached by the advice and consent of the citizenry directly.");
        government[2].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Collective, tribal council, comm-linked consensus");
        government[2].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Drugs");

        government[3] = graph.addVertex(null);
        government[3].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Self-perpetuating oligarchy");
        government[3].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are performed by a restricted minority, with little or no input from the mass of citizenry.");
        government[3].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Plutocracy, hereditary ruling caste");
        government[3].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Technology, Weapons, Travellers");

        government[4] = graph.addVertex(null);
        government[4].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Representative democracy");
        government[4].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are performed by elected representatives.");
        government[4].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Republic, democracy");
        government[4].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Drugs, Weapons, Psionics");

        government[5] = graph.addVertex(null);
        government[5].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Feudal technocracy");
        government[5].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are performed by specific individuals for persons who agree to be ruled by them. Relationships are based on the performance of technical activities which are mutually beneficial.");
        government[5].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "");
        government[5].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Technology, Weapons, Computers");

        government[6] = graph.addVertex(null);
        government[6].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Captive government");
        government[6].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are performed by an imposed leadership answerable to an outside group.");
        government[6].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "A colony or conquered area");
        government[6].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Weapons, Technology, Travellers");

        government[7] = graph.addVertex(null);
        government[7].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Balkanisation");
        government[7].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "No central authority exists; rival governments compete for control. Law level refers to the government nearest the starport.");
        government[7].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Multiple governments, civil war");
        government[7].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Varies");

        government[8] = graph.addVertex(null);
        government[8].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Civil service bureaucracy");
        government[8].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are performed by government agencies employing individuals selected for their expertise.");
        government[8].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Technocracy, Communism");
        government[8].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Drugs, Weapons");

        government[9] = graph.addVertex(null);
        government[9].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Impersonal Bureaucracy");
        government[9].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are performed by agencies which have become insulated from the governed citizens.");
        government[9].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Entrenched castes of bureaucrats, decaying empire");
        government[9].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Technology, Weapons, Drugs, Travellers, Psionics");

        government[10] = graph.addVertex(null);
        government[10].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Charismatic dictator");
        government[10].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are performed by agencies directed by a single leader who enjoys the overwhelming confidence of the citizens.");
        government[10].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Revolutionary leader, messiah, emperor");
        government[10].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "None");

        government[11] = graph.addVertex(null);
        government[11].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Non-charismatic leader");
        government[11].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "A previous charismatic dictator has been replaced by a leader through normal channels.");
        government[11].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Military dictatorship, hereditary kingship");
        government[11].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Weapons, Technology, Computers");

        government[12] = graph.addVertex(null);
        government[12].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Charismatic oligarchy");
        government[12].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are performed by a select group of members of an organisation or class which enjoys the overwhelming confidence of the citizenry.");
        government[12].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Junta, revolutionary council");
        government[12].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Weapons");

        government[13] = graph.addVertex(null);
        government[13].setProperty(PlanetProperties.GOVERNMENT_TYPE.getProperty(), "Religious dictatorship");
        government[13].setProperty(PlanetProperties.GOVERNMENT_DESCRIPTION.getProperty(), "Ruling functions are performed by a religious organisation without regard to the specific individual needs of the citizenry.");
        government[13].setProperty(PlanetProperties.GOVERNMENT_EXAMPLES.getProperty(), "Cult, transcendent philosophy, psionic group mind");
        government[13].setProperty(PlanetProperties.GOVERNMENT_COMMON_CONTRABAND.getProperty(), "Varies");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }
    
    protected void generateLawDescriptorNodes(TransactionalGraph graph){
        graph.startTransaction();
        law[0] = graph.addVertex(null);
        law[0].setProperty(PlanetProperties.LAW_WEAPONS.getProperty(), "No Restrictions");
        law[0].setProperty(PlanetProperties.LAW_DRUGS.getProperty(), "No Restrictions");
        law[0].setProperty(PlanetProperties.LAW_INFORMATION.getProperty(), "No Restrictions");
        law[0].setProperty(PlanetProperties.LAW_TECHNOLOGY.getProperty(), "No Restrictions");
        law[0].setProperty(PlanetProperties.LAW_TRAVELLERS.getProperty(), "No Restrictions");
        law[0].setProperty(PlanetProperties.LAW_PSIONICS.getProperty(), "No Restrictions");

        law[1] = graph.addVertex(null);
        law[1].setProperty(PlanetProperties.LAW_WEAPONS.getProperty(), "Poison gas, explosives, undetectable weapons, WMD");
        law[1].setProperty(PlanetProperties.LAW_DRUGS.getProperty(), "Highly addictive and dangerous narcotics");
        law[1].setProperty(PlanetProperties.LAW_INFORMATION.getProperty(), "Intellect programs");
        law[1].setProperty(PlanetProperties.LAW_TECHNOLOGY.getProperty(), "Dangerous technologies such as nanotechnology");
        law[1].setProperty(PlanetProperties.LAW_TRAVELLERS.getProperty(), "Visitors must contact planetary authorities by radio, landing is permitted anywhere");
        law[1].setProperty(PlanetProperties.LAW_PSIONICS.getProperty(), "Dangerous talents must be registered");

        law[2] = graph.addVertex(null);
        law[2].setProperty(PlanetProperties.LAW_WEAPONS.getProperty(), "Portable energy weapons (except ship-mounted weapons)");
        law[2].setProperty(PlanetProperties.LAW_DRUGS.getProperty(), "Highly addictive narcotics");
        law[2].setProperty(PlanetProperties.LAW_INFORMATION.getProperty(), "Agent programs");
        law[2].setProperty(PlanetProperties.LAW_TECHNOLOGY.getProperty(), "Alien technology");
        law[2].setProperty(PlanetProperties.LAW_TRAVELLERS.getProperty(), "Visitors must report passenger manifest, landing is permitted anywhere");
        law[2].setProperty(PlanetProperties.LAW_PSIONICS.getProperty(), "All psionic powers must be registered; use of dangerous powers forbidden");

        law[3] = graph.addVertex(null);
        law[3].setProperty(PlanetProperties.LAW_WEAPONS.getProperty(), "Heavy weapons");
        law[3].setProperty(PlanetProperties.LAW_DRUGS.getProperty(), "Combat drugs");
        law[3].setProperty(PlanetProperties.LAW_INFORMATION.getProperty(), "Intrusion programs");
        law[3].setProperty(PlanetProperties.LAW_TECHNOLOGY.getProperty(), "TL 15 items");
        law[3].setProperty(PlanetProperties.LAW_TRAVELLERS.getProperty(), "Landing only at starport or other authorised sites");
        law[3].setProperty(PlanetProperties.LAW_PSIONICS.getProperty(), "Use of telepathy restricted to government-approved telepaths");

        law[4] = graph.addVertex(null);
        law[4].setProperty(PlanetProperties.LAW_WEAPONS.getProperty(), "Light assault weapons and submachine guns");
        law[4].setProperty(PlanetProperties.LAW_DRUGS.getProperty(), "Addictive narcotics");
        law[4].setProperty(PlanetProperties.LAW_INFORMATION.getProperty(), "Security programs");
        law[4].setProperty(PlanetProperties.LAW_TECHNOLOGY.getProperty(), "TL 13 items");
        law[4].setProperty(PlanetProperties.LAW_TRAVELLERS.getProperty(), "Landing only at starport");
        law[4].setProperty(PlanetProperties.LAW_PSIONICS.getProperty(), "Use of teleportation and clairvoyance restricted");

        law[5] = graph.addVertex(null);
        law[5].setProperty(PlanetProperties.LAW_WEAPONS.getProperty(), "Personal concealable weapons");
        law[5].setProperty(PlanetProperties.LAW_DRUGS.getProperty(), "Anagathics");
        law[5].setProperty(PlanetProperties.LAW_INFORMATION.getProperty(), "Expert programs");
        law[5].setProperty(PlanetProperties.LAW_TECHNOLOGY.getProperty(), "TL 11 items");
        law[5].setProperty(PlanetProperties.LAW_TRAVELLERS.getProperty(), "Citizens must register offworld travel, visitors must register all business");
        law[5].setProperty(PlanetProperties.LAW_PSIONICS.getProperty(), "Use of all psionic powers restricted to government psionicists");

        law[6] = graph.addVertex(null);
        law[6].setProperty(PlanetProperties.LAW_WEAPONS.getProperty(), "All firearms except shotguns and stunners; carrying weapons discouraged");
        law[6].setProperty(PlanetProperties.LAW_DRUGS.getProperty(), "Fast and Slow drugs");
        law[6].setProperty(PlanetProperties.LAW_INFORMATION.getProperty(), "Recent news from offworld");
        law[6].setProperty(PlanetProperties.LAW_TECHNOLOGY.getProperty(), "TL 9 items");
        law[6].setProperty(PlanetProperties.LAW_TRAVELLERS.getProperty(), "Visits discouraged; excessive contact with citizens forbidden");
        law[6].setProperty(PlanetProperties.LAW_PSIONICS.getProperty(), "Possession of psionic drugs banned");

        law[7] = graph.addVertex(null);
        law[7].setProperty(PlanetProperties.LAW_WEAPONS.getProperty(), "Shotguns");
        law[7].setProperty(PlanetProperties.LAW_DRUGS.getProperty(), "All narcotics");
        law[7].setProperty(PlanetProperties.LAW_INFORMATION.getProperty(), "Library programs, unfiltered data about other worlds. Free speech curtailed");
        law[7].setProperty(PlanetProperties.LAW_TECHNOLOGY.getProperty(), "TL 7 items");
        law[7].setProperty(PlanetProperties.LAW_TRAVELLERS.getProperty(), "Citizens may not leave planet; visitors may not leave starport");
        law[7].setProperty(PlanetProperties.LAW_PSIONICS.getProperty(), "Use of psionics forbidden");

        law[8] = graph.addVertex(null);
        law[8].setProperty(PlanetProperties.LAW_WEAPONS.getProperty(), "All bladed weapons, stunners");
        law[8].setProperty(PlanetProperties.LAW_DRUGS.getProperty(), "Medicinal drugs");
        law[8].setProperty(PlanetProperties.LAW_INFORMATION.getProperty(), "Information technology, any non-critical data from offworld, personal media");
        law[8].setProperty(PlanetProperties.LAW_TECHNOLOGY.getProperty(), "TL 5 items");
        law[8].setProperty(PlanetProperties.LAW_TRAVELLERS.getProperty(), "Landing permitted only to designated VIPs");
        law[8].setProperty(PlanetProperties.LAW_PSIONICS.getProperty(), "Psionic-related technology banned");

        law[9] = graph.addVertex(null);
        law[9].setProperty(PlanetProperties.LAW_WEAPONS.getProperty(), "Any weapons");
        law[9].setProperty(PlanetProperties.LAW_DRUGS.getProperty(), "All drugs");
        law[9].setProperty(PlanetProperties.LAW_INFORMATION.getProperty(), "Any data from offworld. No free press");
        law[9].setProperty(PlanetProperties.LAW_TECHNOLOGY.getProperty(), "TL 3 items");
        law[9].setProperty(PlanetProperties.LAW_TRAVELLERS.getProperty(), "No offworlders permitted");
        law[9].setProperty(PlanetProperties.LAW_PSIONICS.getProperty(), "All psionics");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }
    
    protected void generateStarportDescriptorNodes(TransactionalGraph graph){
        graph.startTransaction();
        starport[0] = graph.addVertex(null);
        starport[0].setProperty(PlanetProperties.STARPORT_QUALITY.getProperty(), "No Starport");
        starport[0].setProperty(PlanetProperties.STARPORT_BERTHING_COST.getProperty(), "0");
        starport[0].setProperty(PlanetProperties.STARPORT_FUEL.getProperty(), "None");
        starport[0].setProperty(PlanetProperties.STARPORT_FACILITIES.getProperty(), "None");
        starport[0].setProperty(PlanetProperties.STARPORT_BASES.getProperty(), "None");
        starport[1] = starport[0];
        starport[2] = starport[0];

        starport[3] = graph.addVertex(null);
        starport[3].setProperty(PlanetProperties.STARPORT_QUALITY.getProperty(), "Frontier");
        starport[3].setProperty(PlanetProperties.STARPORT_BERTHING_COST.getProperty(), "0");
        starport[3].setProperty(PlanetProperties.STARPORT_FUEL.getProperty(), "None");
        starport[3].setProperty(PlanetProperties.STARPORT_FACILITIES.getProperty(), "None");
        starport[3].setProperty(PlanetProperties.STARPORT_BASES.getProperty(), "Pirate 12+");
        starport[4] = starport[3];

        starport[5] = graph.addVertex(null);
        starport[5].setProperty(PlanetProperties.STARPORT_QUALITY.getProperty(), "Poor");
        starport[5].setProperty(PlanetProperties.STARPORT_BERTHING_COST.getProperty(), "1d6 x 10");
        starport[5].setProperty(PlanetProperties.STARPORT_FUEL.getProperty(), "Unrefined");
        starport[5].setProperty(PlanetProperties.STARPORT_FACILITIES.getProperty(), "Limited Repair");
        starport[5].setProperty(PlanetProperties.STARPORT_BASES.getProperty(), "Scout 7+, Pirate 12+");
        starport[6] = starport[5];

        starport[7] = graph.addVertex(null);
        starport[7].setProperty(PlanetProperties.STARPORT_QUALITY.getProperty(), "Routine");
        starport[7].setProperty(PlanetProperties.STARPORT_BERTHING_COST.getProperty(), "1d6 x 100");
        starport[7].setProperty(PlanetProperties.STARPORT_FUEL.getProperty(), "Unrefined");
        starport[7].setProperty(PlanetProperties.STARPORT_FACILITIES.getProperty(), "Shipyard (small craft), Repair");
        starport[7].setProperty(PlanetProperties.STARPORT_BASES.getProperty(), "Scout 8+, Research 10+, TAS 10+, Consulate 10+, Pirate 10+");
        starport[8] = starport[7];

        starport[9] = graph.addVertex(null);
        starport[9].setProperty(PlanetProperties.STARPORT_QUALITY.getProperty(), "Good");
        starport[9].setProperty(PlanetProperties.STARPORT_BERTHING_COST.getProperty(), "1d6 x 500");
        starport[9].setProperty(PlanetProperties.STARPORT_FUEL.getProperty(), "Refined");
        starport[9].setProperty(PlanetProperties.STARPORT_FACILITIES.getProperty(), "Shipyard (spacecraft), repair");
        starport[9].setProperty(PlanetProperties.STARPORT_BASES.getProperty(), "Naval 8+, Scout 8+, Research 10+, TAS 6+, Consulate 8+, Pirate 12+");
        starport[10] = starport[9];

        starport[11] = graph.addVertex(null);
        starport[11].setProperty(PlanetProperties.STARPORT_QUALITY.getProperty(), "Excellent");
        starport[11].setProperty(PlanetProperties.STARPORT_BERTHING_COST.getProperty(), "1d6 x 1000");
        starport[11].setProperty(PlanetProperties.STARPORT_FUEL.getProperty(), "Refined");
        starport[11].setProperty(PlanetProperties.STARPORT_FACILITIES.getProperty(), "Shipyard (all), repair");
        starport[11].setProperty(PlanetProperties.STARPORT_BASES.getProperty(), "Naval 8+, Scout 10+, Research 8+, TAS 4+, Imperial Consulate 6+");
        starport[12] = starport[11];
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }
    
    protected void generateTechLevelDescriptorNodes(TransactionalGraph graph){
        graph.startTransaction();
        techLevel[0] = graph.addVertex(null);
        techLevel[0].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Primitive");
        techLevel[0].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "No technology. TL 0 species have only disovered the simplest tools and principles, and are on par with Earth's Stone Age.");

        techLevel[1] = graph.addVertex(null);
        techLevel[1].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Primitive");
        techLevel[1].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "Roughly on a par with Bronze or Iron age technology. TL 1 science is mostly superstition, but they can manufacture weapons and work metals.");

        techLevel[2] = graph.addVertex(null);
        techLevel[2].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Primitive");
        techLevel[2].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "Renaissance technology. TL 2 brings with it a greater understanding of chemistry, physics, biology, and astronomy as well as the scientific method.");

        techLevel[3] = graph.addVertex(null);
        techLevel[3].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Primitive");
        techLevel[3].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "The advances of TL 2 are now applied, bringing the germ of industrial revolution and steam power. Primitive firearms now dominate the battlefield. This is roughly comparable to the early 19th century.");

        techLevel[4] = graph.addVertex(null);
        techLevel[4].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Industrial");
        techLevel[4].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "The transition to industrial revolution is complete, bringing plastics, radio and other such inventions. Roughly comparable to the late 19th/early 20th century.");

        techLevel[5] = graph.addVertex(null);
        techLevel[5].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Industrial");
        techLevel[5].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "TL 5 brings widespread electrification, telecommunications and internal combustion. At the high end of the TL, atomics and primitive computing appear. Roughly on a par with the mid-20th century.");

        techLevel[6] = graph.addVertex(null);
        techLevel[6].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Industrial");
        techLevel[6].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "TL 6 brings the development of fission power and more advanced computing. Advances in materials technology and rocketry bring about the dawn of the space age.");

        techLevel[7] = graph.addVertex(null);
        techLevel[7].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Pre-Stellar");
        techLevel[7].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "A pre-stellar society can reach orbit reliably and has telecommunications satellites. Computers become common. At the time of writing, humanity is currently somewhere between TL 7 and TL 8.");

        techLevel[8] = graph.addVertex(null);
        techLevel[8].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Pre-Stellar");
        techLevel[8].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "At TL 8, it is possible to reach other worlds in the same system, although terraforming or full colonisation are not within the culture's capacity. Permanent space habitats become possible. Fusion power becomes commercially viable.");

        techLevel[9] = graph.addVertex(null);
        techLevel[9].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Pre-Stellar");
        techLevel[9].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "The defining element of TL 9 is the development of gravity manipulation, which makes space travel vastly safer and faster. This research leads to development of the Jump drive, which occurs near the end of this Tech Level. TL 9 cultures can colonise other worlds, although going to a colony is generally a one-way trip.");

        techLevel[10] = graph.addVertex(null);
        techLevel[10].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Early Stellar");
        techLevel[10].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "With the advent of the Jump, nearby systems are opened up. Orbital habitats and factories become common. Interstellar travel and trade lead to an economic boon. Colonies become much more viable.");

        techLevel[11] = graph.addVertex(null);
        techLevel[11].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Early Stellar");
        techLevel[11].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "The first true artificial intelligences become possible, as computers are able to model synaptic networks, Grav-supported structures reach to the heavens. Jump-2 travel becomes possible, allowing easier travel beyond the one-Jump stellar mains.");

        techLevel[12] = graph.addVertex(null);
        techLevel[12].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Average Stellar");
        techLevel[12].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "Weather control revolutionises terraforming and agriculture. Man-portable plasma weapons and carrier-mounted fusion guns make the battlefield untenable for unarmoured combatants. Jump-3 travel is developed.");

        techLevel[13] = graph.addVertex(null);
        techLevel[13].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Average Stellar");
        techLevel[13].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "The battle dress appears on the battlefield in response to the new weapons. Cloning of body parts becomes easy. Advances in hull design and thruster plates means that spacecraft can easily enter atmosphere and even go underwater. Jump-4 travel is developed.");

        techLevel[14] = graph.addVertex(null);
        techLevel[14].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Average Stellar");
        techLevel[14].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "Fusion weapons become man-portable. Flying cities appear. Jump-5 travel is developed.");

        techLevel[15] = graph.addVertex(null);
        techLevel[15].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "High Stellar");
        techLevel[15].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "Black globe generators suggest a new direction for defensive technologies, while the development of synthetic anagathics means that the human lifespan is now vastly increased. Jump-6 travel is developed.");

        techLevel[16] = graph.addVertex(null);
        techLevel[16].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Unknown");
        techLevel[16].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "Unknown");

        techLevel[17] = graph.addVertex(null);
        techLevel[17].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Unknown");
        techLevel[17].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "Unknown");

        techLevel[18] = graph.addVertex(null);
        techLevel[18].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Unknown");
        techLevel[18].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "Unknown");

        techLevel[19] = graph.addVertex(null);
        techLevel[19].setProperty(PlanetProperties.TECH_LEVEL_DESIGNATION.getProperty(), "Unknown");
        techLevel[19].setProperty(PlanetProperties.TECH_LEVEL_DESCRIPTION.getProperty(), "Unknown");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }
}
