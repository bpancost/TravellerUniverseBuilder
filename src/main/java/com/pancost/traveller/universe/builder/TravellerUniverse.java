package com.pancost.traveller.universe.builder;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author Brandon Pancost
 */
public abstract class TravellerUniverse implements TravellerConstants{
    Node size[] = new Node[11];//Yes, I'm going old school and using an array.
    Node atmosphere[] = new Node[16];//I know all the table sizes, so why not?
    Node temperature[] = new Node[16];
    Node hydrographics[] = new Node[11];
    Node population[] = new Node[13];
    Node government[] = new Node[14];
    Node law[] = new Node[10];
    Node starport[] = new Node[13];
    Node techLevel[] = new Node[20];

    protected void generateSizeDescriptorNodes(GraphDatabaseService graphDB){
        Transaction tx = graphDB.beginTx();
        try{
            size[0] = graphDB.createNode();
            size[0].setProperty(WORLD_SIZE, "800km");
            size[0].setProperty(SURFACE_GRAVITY, "0");

            size[1] = graphDB.createNode();
            size[1].setProperty(WORLD_SIZE, "1600km");
            size[1].setProperty(SURFACE_GRAVITY, "0.05");

            size[2] = graphDB.createNode();
            size[2].setProperty(WORLD_SIZE, "3200km");
            size[2].setProperty(SURFACE_GRAVITY, "0.15");

            size[3] = graphDB.createNode();
            size[3].setProperty(WORLD_SIZE, "4800km");
            size[3].setProperty(SURFACE_GRAVITY, "0.25");

            size[4] = graphDB.createNode();
            size[4].setProperty(WORLD_SIZE, "6400km");
            size[4].setProperty(SURFACE_GRAVITY, "0.35");

            size[5] = graphDB.createNode();
            size[5].setProperty(WORLD_SIZE, "8000km");
            size[5].setProperty(SURFACE_GRAVITY, "0.45");

            size[6] = graphDB.createNode();
            size[6].setProperty(WORLD_SIZE, "9600km");
            size[6].setProperty(SURFACE_GRAVITY, "0.7");

            size[7] = graphDB.createNode();
            size[7].setProperty(WORLD_SIZE, "11200");
            size[7].setProperty(SURFACE_GRAVITY, "0.9");

            size[8] = graphDB.createNode();
            size[8].setProperty(WORLD_SIZE, "12800km");
            size[8].setProperty(SURFACE_GRAVITY, "1.0");

            size[9] = graphDB.createNode();
            size[9].setProperty(WORLD_SIZE, "14400km");
            size[9].setProperty(SURFACE_GRAVITY, "1.25");

            size[10] = graphDB.createNode();
            size[10].setProperty(WORLD_SIZE, "16000km");
            size[10].setProperty(SURFACE_GRAVITY, "1.4");
            tx.success();
        }finally{
            tx.finish();
        }
    }

    protected void generateAtmosphereDescriptorNodes(GraphDatabaseService graphDB){
        Transaction tx = graphDB.beginTx();
        try{
            atmosphere[0] = graphDB.createNode();
            atmosphere[0].setProperty(ATMOSPHERE, "None");
            atmosphere[0].setProperty(PRESSURE, "0.00");
            atmosphere[0].setProperty(SURVIVAL_GEAR_REQUIRED, "Vacc Suit");

            atmosphere[1] = graphDB.createNode();
            atmosphere[1].setProperty(ATMOSPHERE, "Trace");
            atmosphere[1].setProperty(PRESSURE, "0.01 - 0.09");
            atmosphere[1].setProperty(SURVIVAL_GEAR_REQUIRED, "Vacc Suit");

            atmosphere[2] = graphDB.createNode();
            atmosphere[2].setProperty(ATMOSPHERE, "Very Thin, Tainted");
            atmosphere[2].setProperty(PRESSURE, "0.1 - 0.42");
            atmosphere[2].setProperty(SURVIVAL_GEAR_REQUIRED, "Respirator, Filter");

            atmosphere[3] = graphDB.createNode();
            atmosphere[3].setProperty(ATMOSPHERE, "Very Thin");
            atmosphere[3].setProperty(PRESSURE, "0.1 - 0.42");
            atmosphere[3].setProperty(SURVIVAL_GEAR_REQUIRED, "Respirator");

            atmosphere[4] = graphDB.createNode();
            atmosphere[4].setProperty(ATMOSPHERE, "Thin, Tainted");
            atmosphere[4].setProperty(PRESSURE, "0.43 - 0.7");
            atmosphere[4].setProperty(SURVIVAL_GEAR_REQUIRED, "Filter");

            atmosphere[5] = graphDB.createNode();
            atmosphere[5].setProperty(ATMOSPHERE, "Thin");
            atmosphere[5].setProperty(PRESSURE, "0.43 - 0.7");
            atmosphere[5].setProperty(SURVIVAL_GEAR_REQUIRED, "None");

            atmosphere[6] = graphDB.createNode();
            atmosphere[6].setProperty(ATMOSPHERE, "Standard");
            atmosphere[6].setProperty(PRESSURE, "0.71 - 1.49");
            atmosphere[6].setProperty(SURVIVAL_GEAR_REQUIRED, "None");

            atmosphere[7] = graphDB.createNode();
            atmosphere[7].setProperty(ATMOSPHERE, "Standard, Tainted");
            atmosphere[7].setProperty(PRESSURE, "0.71 - 1.49");
            atmosphere[7].setProperty(SURVIVAL_GEAR_REQUIRED, "Filter");

            atmosphere[8] = graphDB.createNode();
            atmosphere[8].setProperty(ATMOSPHERE, "Dense");
            atmosphere[8].setProperty(PRESSURE, "1.5 - 2.49");
            atmosphere[8].setProperty(SURVIVAL_GEAR_REQUIRED, "None");

            atmosphere[9] = graphDB.createNode();
            atmosphere[9].setProperty(ATMOSPHERE, "Dense, Tainted");
            atmosphere[9].setProperty(PRESSURE, "1.5 - 2.49");
            atmosphere[9].setProperty(SURVIVAL_GEAR_REQUIRED, "Filter");

            atmosphere[10] = graphDB.createNode();
            atmosphere[10].setProperty(ATMOSPHERE, "Exotic");
            atmosphere[10].setProperty(PRESSURE, "Varies");
            atmosphere[10].setProperty(SURVIVAL_GEAR_REQUIRED, "Air Supply");

            atmosphere[11] = graphDB.createNode();
            atmosphere[11].setProperty(ATMOSPHERE, "Corrosive");
            atmosphere[11].setProperty(PRESSURE, "Varies");
            atmosphere[11].setProperty(SURVIVAL_GEAR_REQUIRED, "Vacc Suit");

            atmosphere[12] = graphDB.createNode();
            atmosphere[12].setProperty(ATMOSPHERE, "Insidious");
            atmosphere[12].setProperty(PRESSURE, "Varies");
            atmosphere[12].setProperty(SURVIVAL_GEAR_REQUIRED, "Vacc Suit");

            atmosphere[13] = graphDB.createNode();
            atmosphere[13].setProperty(ATMOSPHERE, "Dense, High");
            atmosphere[13].setProperty(PRESSURE, "2.5+");
            atmosphere[13].setProperty(SURVIVAL_GEAR_REQUIRED, "None");

            atmosphere[14] = graphDB.createNode();
            atmosphere[14].setProperty(ATMOSPHERE, "Thin, Low");
            atmosphere[14].setProperty(PRESSURE, "0.00 - 0.5");
            atmosphere[14].setProperty(SURVIVAL_GEAR_REQUIRED, "None");

            atmosphere[15] = graphDB.createNode();
            atmosphere[15].setProperty(ATMOSPHERE, "Unusual");
            atmosphere[15].setProperty(PRESSURE, "Varies");
            atmosphere[15].setProperty(SURVIVAL_GEAR_REQUIRED, "Varies");

            tx.success();
        }finally{
            tx.finish();
        }
    }

    protected void generateTemperatureDescriptorNodes(GraphDatabaseService graphDB){
        Transaction tx = graphDB.beginTx();
        try{
            temperature[0] = graphDB.createNode();
            temperature[0].setProperty(TEMPERATURE_TYPE, "Frozen");
            temperature[0].setProperty(AVERAGE_TEMPERATURE, "-51C or less");
            temperature[0].setProperty(TEMPERATURE_DESCRIPTION, "Frozen world. No liquid water, very dry atmosphere.");
            temperature[1] = temperature[0];
            temperature[2] = temperature[0];
            
            temperature[3] = graphDB.createNode();
            temperature[3].setProperty(TEMPERATURE_TYPE, "Cold");
            temperature[3].setProperty(AVERAGE_TEMPERATURE, "-51C - 0C");
            temperature[3].setProperty(TEMPERATURE_DESCRIPTION, "Icy world. Little liquid water, extensive ice caps, few clouds.");
            temperature[4] = temperature[3];

            temperature[5] = graphDB.createNode();
            temperature[5].setProperty(TEMPERATURE_TYPE, "Temperate");
            temperature[5].setProperty(AVERAGE_TEMPERATURE, "0C - 30C");
            temperature[5].setProperty(TEMPERATURE_DESCRIPTION, "Temperate world. Earthlike. Liquid and vaporised water are common, moderate ice caps.");
            temperature[6] = temperature[5];
            temperature[7] = temperature[5];
            temperature[8] = temperature[5];
            temperature[9] = temperature[5];

            temperature[10] = graphDB.createNode();
            temperature[10].setProperty(TEMPERATURE_TYPE, "Hot");
            temperature[10].setProperty(AVERAGE_TEMPERATURE, "31C - 80C");
            temperature[10].setProperty(TEMPERATURE_DESCRIPTION, "Hot world. Small or no ice caps, little liquid water. Most water in the form of clouds.");
            temperature[11] = temperature[10];

            temperature[12] = graphDB.createNode();
            temperature[12].setProperty(TEMPERATURE_TYPE, "Hot");
            temperature[12].setProperty(AVERAGE_TEMPERATURE, "81C or greater");
            temperature[12].setProperty(TEMPERATURE_DESCRIPTION, "Boiling world. No ice caps, little liquid water.");
            temperature[13] = temperature[12];
            temperature[14] = temperature[12];
            temperature[15] = temperature[12];

            tx.success();
        }finally{
            tx.finish();
        }
    }

    protected void generateHydrographicDescriptorNodes(GraphDatabaseService graphDB){
        Transaction tx = graphDB.beginTx();
        try{
            hydrographics[0] = graphDB.createNode();
            hydrographics[0].setProperty(HYDROGRAPHIC_PERCENTAGE, "0%-5%");
            hydrographics[0].setProperty(HYDROGRAPHIC_DESCRIPTION, "Desert world");

            hydrographics[1] = graphDB.createNode();
            hydrographics[1].setProperty(HYDROGRAPHIC_PERCENTAGE, "6%-15%");
            hydrographics[1].setProperty(HYDROGRAPHIC_DESCRIPTION, "Dry world");

            hydrographics[2] = graphDB.createNode();
            hydrographics[2].setProperty(HYDROGRAPHIC_PERCENTAGE, "16%-25%");
            hydrographics[2].setProperty(HYDROGRAPHIC_DESCRIPTION, "A few small seas");

            hydrographics[3] = graphDB.createNode();
            hydrographics[3].setProperty(HYDROGRAPHIC_PERCENTAGE, "26%-35%");
            hydrographics[3].setProperty(HYDROGRAPHIC_DESCRIPTION, "Small seas and oceans");

            hydrographics[4] = graphDB.createNode();
            hydrographics[4].setProperty(HYDROGRAPHIC_PERCENTAGE, "36%-45%");
            hydrographics[4].setProperty(HYDROGRAPHIC_DESCRIPTION, "Wet world");

            hydrographics[5] = graphDB.createNode();
            hydrographics[5].setProperty(HYDROGRAPHIC_PERCENTAGE, "46%-55%");
            hydrographics[5].setProperty(HYDROGRAPHIC_DESCRIPTION, "Large oceans");

            hydrographics[6] = graphDB.createNode();
            hydrographics[6].setProperty(HYDROGRAPHIC_PERCENTAGE, "56%-65%");
            hydrographics[6].setProperty(HYDROGRAPHIC_DESCRIPTION, "Large oceans");

            hydrographics[7] = graphDB.createNode();
            hydrographics[7].setProperty(HYDROGRAPHIC_PERCENTAGE, "66%-75%");
            hydrographics[7].setProperty(HYDROGRAPHIC_DESCRIPTION, "Earth-like world");

            hydrographics[8] = graphDB.createNode();
            hydrographics[8].setProperty(HYDROGRAPHIC_PERCENTAGE, "76%-85%");
            hydrographics[8].setProperty(HYDROGRAPHIC_DESCRIPTION, "Water world");

            hydrographics[9] = graphDB.createNode();
            hydrographics[9].setProperty(HYDROGRAPHIC_PERCENTAGE, "86%-95%");
            hydrographics[9].setProperty(HYDROGRAPHIC_DESCRIPTION, "Only a few small islands and archipelagos");

            hydrographics[10] = graphDB.createNode();
            hydrographics[10].setProperty(HYDROGRAPHIC_PERCENTAGE, "96%-100%");
            hydrographics[10].setProperty(HYDROGRAPHIC_DESCRIPTION, "Almost entirely water");

            tx.success();
        }finally{
            tx.finish();
        }
    }

    protected void generatePopulationDescriptorNodes(GraphDatabaseService graphDB){
        Transaction tx = graphDB.beginTx();
        try{
            population[0] = graphDB.createNode();
            population[0].setProperty(POPULATION_RANGE, "0");
            population[0].setProperty(POPULATION_DESCRIPTION, "Uninhabited");

            population[1] = graphDB.createNode();
            population[1].setProperty(POPULATION_RANGE, "1-99");
            population[1].setProperty(POPULATION_DESCRIPTION, "A tiny farmstead or a single family.");

            population[2] = graphDB.createNode();
            population[2].setProperty(POPULATION_RANGE, "100-999");
            population[2].setProperty(POPULATION_DESCRIPTION, "A village");

            population[3] = graphDB.createNode();
            population[3].setProperty(POPULATION_RANGE, "1,000-9,999");
            population[3].setProperty(POPULATION_DESCRIPTION, "A few villages");

            population[4] = graphDB.createNode();
            population[4].setProperty(POPULATION_RANGE, "10,000-99,999");
            population[4].setProperty(POPULATION_DESCRIPTION, "Small town");

            population[5] = graphDB.createNode();
            population[5].setProperty(POPULATION_RANGE, "100,000-999,999");
            population[5].setProperty(POPULATION_DESCRIPTION, "Average city");

            population[6] = graphDB.createNode();
            population[6].setProperty(POPULATION_RANGE, "1,000,000-9,999,999");
            population[6].setProperty(POPULATION_DESCRIPTION, "A few average cities");

            population[7] = graphDB.createNode();
            population[7].setProperty(POPULATION_RANGE, "10,000,000-99,999,999");
            population[7].setProperty(POPULATION_DESCRIPTION, "Large city");

            population[8] = graphDB.createNode();
            population[8].setProperty(POPULATION_RANGE, "100,000,000-999,999,999");
            population[8].setProperty(POPULATION_DESCRIPTION, "A few large cities");

            population[9] = graphDB.createNode();
            population[9].setProperty(POPULATION_RANGE, "1,000,000,000-9,999,999,999");
            population[9].setProperty(POPULATION_DESCRIPTION, "Present day Earth");

            population[10] = graphDB.createNode();
            population[10].setProperty(POPULATION_RANGE, "10,000,000,000-99,999,999,999");
            population[10].setProperty(POPULATION_DESCRIPTION, "Crowded world");

            population[11] = graphDB.createNode();
            population[11].setProperty(POPULATION_RANGE, "100,000,000,000-999,999,999,999");
            population[11].setProperty(POPULATION_DESCRIPTION, "Incredibly crowded world");

            population[11] = graphDB.createNode();
            population[11].setProperty(POPULATION_RANGE, "1,000,000,000,000 and greater");
            population[11].setProperty(POPULATION_DESCRIPTION, "World-city");

            tx.success();
        }finally{
            tx.finish();
        }
    }

    protected void generateGovernmentDescriptorNodes(GraphDatabaseService graphDB){
        Transaction tx = graphDB.beginTx();
        try{
            government[0] = graphDB.createNode();
            government[0].setProperty(GOVERNMENT_TYPE, "None");
            government[0].setProperty(GOVERNMENT_DESCRIPTION, "No government struction. In many cases, family bonds predominate.");
            government[0].setProperty(GOVERNMENT_EXAMPLES, "Family, Clan, Anarchy");
            government[0].setProperty(GOVERNMENT_COMMON_CONTRABAND, "None");

            government[1] = graphDB.createNode();
            government[1].setProperty(GOVERNMENT_TYPE, "Company/Corporation");
            government[1].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are assumed by a company managerial elite, and most citizenry are company employees or dependants.");
            government[1].setProperty(GOVERNMENT_EXAMPLES, "Corporate outpost, asteroid mine, feudal domain");
            government[1].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Weapons, Drugs, Travellers");

            government[2] = graphDB.createNode();
            government[2].setProperty(GOVERNMENT_TYPE, "Participating democracy");
            government[2].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are reached by the advice and consent of the citizenry directly.");
            government[2].setProperty(GOVERNMENT_EXAMPLES, "Collective, tribal council, comm-linked consensus");
            government[2].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Drugs");

            government[3] = graphDB.createNode();
            government[3].setProperty(GOVERNMENT_TYPE, "Self-perpetuating oligarchy");
            government[3].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are performed by a restricted minority, with little or no input from the mass of citizenry.");
            government[3].setProperty(GOVERNMENT_EXAMPLES, "Plutocracy, hereditary ruling caste");
            government[3].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Technology, Weapons, Travellers");

            government[4] = graphDB.createNode();
            government[4].setProperty(GOVERNMENT_TYPE, "Representative democracy");
            government[4].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are performed by elected representatives.");
            government[4].setProperty(GOVERNMENT_EXAMPLES, "Republic, democracy");
            government[4].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Drugs, Weapons, Psionics");

            government[5] = graphDB.createNode();
            government[5].setProperty(GOVERNMENT_TYPE, "Feudal technocracy");
            government[5].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are performed by specific individuals for persons who agree to be ruled by them. Relationships are based on the performance of technical activities which are mutually beneficial.");
            government[5].setProperty(GOVERNMENT_EXAMPLES, "");
            government[5].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Technology, Weapons, Computers");

            government[6] = graphDB.createNode();
            government[6].setProperty(GOVERNMENT_TYPE, "Captive government");
            government[6].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are performed by an imposed leadership answerable to an outside group.");
            government[6].setProperty(GOVERNMENT_EXAMPLES, "A colony or conquered area");
            government[6].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Weapons, Technology, Travellers");

            government[7] = graphDB.createNode();
            government[7].setProperty(GOVERNMENT_TYPE, "Balkanisation");
            government[7].setProperty(GOVERNMENT_DESCRIPTION, "No central authority exists; rival governments compete for control. Law level refers to the government nearest the starport.");
            government[7].setProperty(GOVERNMENT_EXAMPLES, "Multiple governments, civil war");
            government[7].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Varies");

            government[8] = graphDB.createNode();
            government[8].setProperty(GOVERNMENT_TYPE, "Civil service bureaucracy");
            government[8].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are performed by government agencies employing individuals selected for their expertise.");
            government[8].setProperty(GOVERNMENT_EXAMPLES, "Technocracy, Communism");
            government[8].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Drugs, Weapons");

            government[9] = graphDB.createNode();
            government[9].setProperty(GOVERNMENT_TYPE, "Impersonal Bureaucracy");
            government[9].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are performed by agencies which have become insulated from the governed citizens.");
            government[9].setProperty(GOVERNMENT_EXAMPLES, "Entrenched castes of bureaucrats, decaying empire");
            government[9].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Technology, Weapons, Drugs, Travellers, Psionics");

            government[10] = graphDB.createNode();
            government[10].setProperty(GOVERNMENT_TYPE, "Charismatic dictator");
            government[10].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are performed by agencies directed by a single leader who enjoys the overwhelming confidence of the citizens.");
            government[10].setProperty(GOVERNMENT_EXAMPLES, "Revolutionary leader, messiah, emperor");
            government[10].setProperty(GOVERNMENT_COMMON_CONTRABAND, "None");

            government[11] = graphDB.createNode();
            government[11].setProperty(GOVERNMENT_TYPE, "Non-charismatic leader");
            government[11].setProperty(GOVERNMENT_DESCRIPTION, "A previous charismatic dictator has been replaced by a leader through normal channels.");
            government[11].setProperty(GOVERNMENT_EXAMPLES, "Military dictatorship, hereditary kingship");
            government[11].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Weapons, Technology, Computers");

            government[12] = graphDB.createNode();
            government[12].setProperty(GOVERNMENT_TYPE, "Charismatic oligarchy");
            government[12].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are performed by a select group of members of an organisation or class which enjoys the overwhelming confidence of the citizenry.");
            government[12].setProperty(GOVERNMENT_EXAMPLES, "Junta, revolutionary council");
            government[12].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Weapons");

            government[13] = graphDB.createNode();
            government[13].setProperty(GOVERNMENT_TYPE, "Religious dictatorship");
            government[13].setProperty(GOVERNMENT_DESCRIPTION, "Ruling functions are performed by a religious organisation without regard to the specific individual needs of the citizenry.");
            government[13].setProperty(GOVERNMENT_EXAMPLES, "Cult, transcendent philosophy, psionic group mind");
            government[13].setProperty(GOVERNMENT_COMMON_CONTRABAND, "Varies");
            tx.success();
        }finally{
            tx.finish();
        }
    }
    
    protected void generateLawDescriptorNodes(GraphDatabaseService graphDB){
        Transaction tx = graphDB.beginTx();
        try{
            law[0] = graphDB.createNode();
            law[0].setProperty(LAW_WEAPONS, "No Restrictions");
            law[0].setProperty(LAW_DRUGS, "No Restrictions");
            law[0].setProperty(LAW_INFORMATION, "No Restrictions");
            law[0].setProperty(LAW_TECHNOLOGY, "No Restrictions");
            law[0].setProperty(LAW_TRAVELLERS, "No Restrictions");
            law[0].setProperty(LAW_PSIONICS, "No Restrictions");

            law[1] = graphDB.createNode();
            law[1].setProperty(LAW_WEAPONS, "Poison gas, explosives, undetectable weapons, WMD");
            law[1].setProperty(LAW_DRUGS, "Highly addictive and dangerous narcotics");
            law[1].setProperty(LAW_INFORMATION, "Intellect programs");
            law[1].setProperty(LAW_TECHNOLOGY, "Dangerous technologies such as nanotechnology");
            law[1].setProperty(LAW_TRAVELLERS, "Visitors must contact planetary authorities by radio, landing is permitted anywhere");
            law[1].setProperty(LAW_PSIONICS, "Dangerous talents must be registered");

            law[2] = graphDB.createNode();
            law[2].setProperty(LAW_WEAPONS, "Portable energy weapons (except ship-mounted weapons)");
            law[2].setProperty(LAW_DRUGS, "Highly addictive narcotics");
            law[2].setProperty(LAW_INFORMATION, "Agent programs");
            law[2].setProperty(LAW_TECHNOLOGY, "Alien technology");
            law[2].setProperty(LAW_TRAVELLERS, "Visitors must report passenger manifest, landing is permitted anywhere");
            law[2].setProperty(LAW_PSIONICS, "All psionic powers must be registered; use of dangerous powers forbidden");

            law[3] = graphDB.createNode();
            law[3].setProperty(LAW_WEAPONS, "Heavy weapons");
            law[3].setProperty(LAW_DRUGS, "Combat drugs");
            law[3].setProperty(LAW_INFORMATION, "Intrusion programs");
            law[3].setProperty(LAW_TECHNOLOGY, "TL 15 items");
            law[3].setProperty(LAW_TRAVELLERS, "Landing only at starport or other authorised sites");
            law[3].setProperty(LAW_PSIONICS, "Use of telepathy restricted to government-approved telepaths");

            law[4] = graphDB.createNode();
            law[4].setProperty(LAW_WEAPONS, "Light assault weapons and submachine guns");
            law[4].setProperty(LAW_DRUGS, "Addictive narcotics");
            law[4].setProperty(LAW_INFORMATION, "Security programs");
            law[4].setProperty(LAW_TECHNOLOGY, "TL 13 items");
            law[4].setProperty(LAW_TRAVELLERS, "Landing only at starport");
            law[4].setProperty(LAW_PSIONICS, "Use of teleportation and clairvoyance restricted");

            law[5] = graphDB.createNode();
            law[5].setProperty(LAW_WEAPONS, "Personal concealable weapons");
            law[5].setProperty(LAW_DRUGS, "Anagathics");
            law[5].setProperty(LAW_INFORMATION, "Expert programs");
            law[5].setProperty(LAW_TECHNOLOGY, "TL 11 items");
            law[5].setProperty(LAW_TRAVELLERS, "Citizens must register offworld travel, visitors must register all business");
            law[5].setProperty(LAW_PSIONICS, "Use of all psionic powers restricted to government psionicists");

            law[6] = graphDB.createNode();
            law[6].setProperty(LAW_WEAPONS, "All firearms except shotguns and stunners; carrying weapons discouraged");
            law[6].setProperty(LAW_DRUGS, "Fast and Slow drugs");
            law[6].setProperty(LAW_INFORMATION, "Recent news from offworld");
            law[6].setProperty(LAW_TECHNOLOGY, "TL 9 items");
            law[6].setProperty(LAW_TRAVELLERS, "Visits discouraged; excessive contact with citizens forbidden");
            law[6].setProperty(LAW_PSIONICS, "Possession of psionic drugs banned");

            law[7] = graphDB.createNode();
            law[7].setProperty(LAW_WEAPONS, "Shotguns");
            law[7].setProperty(LAW_DRUGS, "All narcotics");
            law[7].setProperty(LAW_INFORMATION, "Library programs, unfiltered data about other worlds. Free speech curtailed");
            law[7].setProperty(LAW_TECHNOLOGY, "TL 7 items");
            law[7].setProperty(LAW_TRAVELLERS, "Citizens may not leave planet; visitors may not leave starport");
            law[7].setProperty(LAW_PSIONICS, "Use of psionics forbidden");

            law[8] = graphDB.createNode();
            law[8].setProperty(LAW_WEAPONS, "All bladed weapons, stunners");
            law[8].setProperty(LAW_DRUGS, "Medicinal drugs");
            law[8].setProperty(LAW_INFORMATION, "Information technology, any non-critical data from offworld, personal media");
            law[8].setProperty(LAW_TECHNOLOGY, "TL 5 items");
            law[8].setProperty(LAW_TRAVELLERS, "Landing permitted only to designated VIPs");
            law[8].setProperty(LAW_PSIONICS, "Psionic-related technology banned");

            law[9] = graphDB.createNode();
            law[9].setProperty(LAW_WEAPONS, "Any weapons");
            law[9].setProperty(LAW_DRUGS, "All drugs");
            law[9].setProperty(LAW_INFORMATION, "Any data from offworld. No free press");
            law[9].setProperty(LAW_TECHNOLOGY, "TL 3 items");
            law[9].setProperty(LAW_TRAVELLERS, "No offworlders permitted");
            law[9].setProperty(LAW_PSIONICS, "All psionics");
            tx.success();
        }finally{
            tx.finish();
        }
    }
    
    protected void generateStarportDescriptorNodes(GraphDatabaseService graphDB){
        Transaction tx = graphDB.beginTx();
        try{
            starport[0] = graphDB.createNode();
            starport[0].setProperty(STARPORT_QUALITY, "No Starport");
            starport[0].setProperty(STARPORT_BERTHING_COST, "0");
            starport[0].setProperty(STARPORT_FUEL, "None");
            starport[0].setProperty(STARPORT_FACILITIES, "None");
            starport[0].setProperty(STARPORT_BASES, "None");
            starport[1] = starport[0];
            starport[2] = starport[0];

            starport[3] = graphDB.createNode();
            starport[3].setProperty(STARPORT_QUALITY, "Frontier");
            starport[3].setProperty(STARPORT_BERTHING_COST, "0");
            starport[3].setProperty(STARPORT_FUEL, "None");
            starport[3].setProperty(STARPORT_FACILITIES, "None");
            starport[3].setProperty(STARPORT_BASES, "Pirate 12+");
            starport[4] = starport[3];

            starport[5] = graphDB.createNode();
            starport[5].setProperty(STARPORT_QUALITY, "Poor");
            starport[5].setProperty(STARPORT_BERTHING_COST, "1d6 x 10");
            starport[5].setProperty(STARPORT_FUEL, "Unrefined");
            starport[5].setProperty(STARPORT_FACILITIES, "Limited Repair");
            starport[5].setProperty(STARPORT_BASES, "Scout 7+, Pirate 12+");
            starport[6] = starport[5];

            starport[7] = graphDB.createNode();
            starport[7].setProperty(STARPORT_QUALITY, "Routine");
            starport[7].setProperty(STARPORT_BERTHING_COST, "1d6 x 100");
            starport[7].setProperty(STARPORT_FUEL, "Unrefined");
            starport[7].setProperty(STARPORT_FACILITIES, "Shipyard (small craft), Repair");
            starport[7].setProperty(STARPORT_BASES, "Scout 8+, Research 10+, TAS 10+, Consulate 10+, Pirate 10+");
            starport[8] = starport[7];

            starport[9] = graphDB.createNode();
            starport[9].setProperty(STARPORT_QUALITY, "Good");
            starport[9].setProperty(STARPORT_BERTHING_COST, "1d6 x 500");
            starport[9].setProperty(STARPORT_FUEL, "Refined");
            starport[9].setProperty(STARPORT_FACILITIES, "Shipyard (spacecraft), repair");
            starport[9].setProperty(STARPORT_BASES, "Naval 8+, Scout 8+, Research 10+, TAS 6+, Consulate 8+, Pirate 12+");
            starport[10] = starport[9];

            starport[11] = graphDB.createNode();
            starport[11].setProperty(STARPORT_QUALITY, "Excellent");
            starport[11].setProperty(STARPORT_BERTHING_COST, "1d6 x 1000");
            starport[11].setProperty(STARPORT_FUEL, "Refined");
            starport[11].setProperty(STARPORT_FACILITIES, "Shipyard (all), repair");
            starport[11].setProperty(STARPORT_BASES, "Naval 8+, Scout 10+, Research 8+, TAS 4+, Imperial Consulate 6+");
            starport[12] = starport[11];
            tx.success();
        }finally{
            tx.finish();
        }
    }
    
    protected void generateTechLevelDescriptorNodes(GraphDatabaseService graphDB){
        Transaction tx = graphDB.beginTx();
        try{
            techLevel[0] = graphDB.createNode();
            techLevel[0].setProperty(TECH_LEVEL_DESIGNATION, "Primitive");
            techLevel[0].setProperty(TECH_LEVEL_DESCRIPTION, "No technology. TL 0 species have only disovered the simplest tools and principles, and are on par with Earth's Stone Age.");

            techLevel[1] = graphDB.createNode();
            techLevel[1].setProperty(TECH_LEVEL_DESIGNATION, "Primitive");
            techLevel[1].setProperty(TECH_LEVEL_DESCRIPTION, "Roughly on a par with Bronze or Iron age technology. TL 1 science is mostly superstition, but they can manufacture weapons and work metals.");
            
            techLevel[2] = graphDB.createNode();
            techLevel[2].setProperty(TECH_LEVEL_DESIGNATION, "Primitive");
            techLevel[2].setProperty(TECH_LEVEL_DESCRIPTION, "Renaissance technology. TL 2 brings with it a greater understanding of chemistry, physics, biology, and astronomy as well as the scientific method.");

            techLevel[3] = graphDB.createNode();
            techLevel[3].setProperty(TECH_LEVEL_DESIGNATION, "Primitive");
            techLevel[3].setProperty(TECH_LEVEL_DESCRIPTION, "The advances of TL 2 are now applied, bringing the germ of industrial revolution and steam power. Primitive firearms now dominate the battlefield. This is roughly comparable to the early 19th century.");

            techLevel[4] = graphDB.createNode();
            techLevel[4].setProperty(TECH_LEVEL_DESIGNATION, "Industrial");
            techLevel[4].setProperty(TECH_LEVEL_DESCRIPTION, "The transition to industrial revolution is complete, bringing plastics, radio and other such inventions. Roughly comparable to the late 19th/early 20th century.");

            techLevel[5] = graphDB.createNode();
            techLevel[5].setProperty(TECH_LEVEL_DESIGNATION, "Industrial");
            techLevel[5].setProperty(TECH_LEVEL_DESCRIPTION, "TL 5 brings widespread electrification, telecommunications and internal combustion. At the high end of the TL, atomics and primitive computing appear. Roughly on a par with the mid-20th century.");

            techLevel[6] = graphDB.createNode();
            techLevel[6].setProperty(TECH_LEVEL_DESIGNATION, "Industrial");
            techLevel[6].setProperty(TECH_LEVEL_DESCRIPTION, "TL 6 brings the development of fission power and more advanced computing. Advances in materials technology and rocketry bring about the dawn of the space age.");

            techLevel[7] = graphDB.createNode();
            techLevel[7].setProperty(TECH_LEVEL_DESIGNATION, "Pre-Stellar");
            techLevel[7].setProperty(TECH_LEVEL_DESCRIPTION, "A pre-stellar society can reach orbit reliably and has telecommunications satellites. Computers become common. At the time of writing, humanity is currently somewhere between TL 7 and TL 8.");

            techLevel[8] = graphDB.createNode();
            techLevel[8].setProperty(TECH_LEVEL_DESIGNATION, "Pre-Stellar");
            techLevel[8].setProperty(TECH_LEVEL_DESCRIPTION, "At TL 8, it is possible to reach other worlds in the same system, although terraforming or full colonisation are not within the culture's capacity. Permanent space habitats become possible. Fusion power becomes commercially viable.");

            techLevel[9] = graphDB.createNode();
            techLevel[9].setProperty(TECH_LEVEL_DESIGNATION, "Pre-Stellar");
            techLevel[9].setProperty(TECH_LEVEL_DESCRIPTION, "The defining element of TL 9 is the development of gravity manipulation, which makes space travel vastly safer and faster. This research leads to development of the Jump drive, which occurs near the end of this Tech Level. TL 9 cultures can colonise other worlds, although going to a colony is generally a one-way trip.");

            techLevel[10] = graphDB.createNode();
            techLevel[10].setProperty(TECH_LEVEL_DESIGNATION, "Early Stellar");
            techLevel[10].setProperty(TECH_LEVEL_DESCRIPTION, "With the advent of the Jump, nearby systems are opened up. Orbital habitats and factories become common. Interstellar travel and trade lead to an economic boon. Colonies become much more viable.");

            techLevel[11] = graphDB.createNode();
            techLevel[11].setProperty(TECH_LEVEL_DESIGNATION, "Early Stellar");
            techLevel[11].setProperty(TECH_LEVEL_DESCRIPTION, "The first true artificial intelligences become possible, as computers are able to model synaptic networks, Grav-supported structures reach to the heavens. Jump-2 travel becomes possible, allowing easier travel beyond the one-Jump stellar mains.");

            techLevel[12] = graphDB.createNode();
            techLevel[12].setProperty(TECH_LEVEL_DESIGNATION, "Average Stellar");
            techLevel[12].setProperty(TECH_LEVEL_DESCRIPTION, "Weather control revolutionises terraforming and agriculture. Man-portable plasma weapons and carrier-mounted fusion guns make the battlefield untenable for unarmoured combatants. Jump-3 travel is developed.");

            techLevel[13] = graphDB.createNode();
            techLevel[13].setProperty(TECH_LEVEL_DESIGNATION, "Average Stellar");
            techLevel[13].setProperty(TECH_LEVEL_DESCRIPTION, "The battle dress appears on the battlefield in response to the new weapons. Cloning of body parts becomes easy. Advances in hull design and thruster plates means that spacecraft can easily enter atmosphere and even go underwater. Jump-4 travel is developed.");

            techLevel[14] = graphDB.createNode();
            techLevel[14].setProperty(TECH_LEVEL_DESIGNATION, "Average Stellar");
            techLevel[14].setProperty(TECH_LEVEL_DESCRIPTION, "Fusion weapons become man-portable. Flying cities appear. Jump-5 travel is developed.");

            techLevel[15] = graphDB.createNode();
            techLevel[15].setProperty(TECH_LEVEL_DESIGNATION, "High Stellar");
            techLevel[15].setProperty(TECH_LEVEL_DESCRIPTION, "Black globe generators suggest a new direction for defensive technologies, while the development of synthetic anagathics means that the human lifespan is now vastly increased. Jump-6 travel is developed.");

            techLevel[16] = graphDB.createNode();
            techLevel[16].setProperty(TECH_LEVEL_DESIGNATION, "Unknown");
            techLevel[16].setProperty(TECH_LEVEL_DESCRIPTION, "Unknown");

            techLevel[17] = graphDB.createNode();
            techLevel[17].setProperty(TECH_LEVEL_DESIGNATION, "Unknown");
            techLevel[17].setProperty(TECH_LEVEL_DESCRIPTION, "Unknown");

            techLevel[18] = graphDB.createNode();
            techLevel[18].setProperty(TECH_LEVEL_DESIGNATION, "Unknown");
            techLevel[18].setProperty(TECH_LEVEL_DESCRIPTION, "Unknown");

            techLevel[19] = graphDB.createNode();
            techLevel[19].setProperty(TECH_LEVEL_DESIGNATION, "Unknown");
            techLevel[19].setProperty(TECH_LEVEL_DESCRIPTION, "Unknown");
            tx.success();
        }finally{
            tx.finish();
        }
    }
}
