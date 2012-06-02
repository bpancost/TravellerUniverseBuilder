package com.pancost.traveller.universe.builder;

import com.pancost.traveller.universe.frames.*;
import com.tinkerpop.blueprints.TransactionalGraph;
import com.tinkerpop.frames.FramedGraph;

/**
 *
 * @author Brandon Pancost
 */
public abstract class TravellerUniverse implements TravellerConstants{
    PlanetSize size[] = new PlanetSize[11];//Yes, I'm going old school and using an array.
    PlanetAtmosphere atmosphere[] = new PlanetAtmosphere[16];//I know all the table sizes, so why not?
    PlanetTemperature temperature[] = new PlanetTemperature[16];
    PlanetHydrographics hydrographics[] = new PlanetHydrographics[11];
    PlanetPopulation population[] = new PlanetPopulation[13];
    PlanetGovernment government[] = new PlanetGovernment[14];
    PlanetLaw law[] = new PlanetLaw[10];
    PlanetStarport starport[] = new PlanetStarport[13];
    PlanetTechLevel techLevel[] = new PlanetTechLevel[20];

    protected void generateSizeDescriptorNodes(TransactionalGraph graph){
        System.out.println("Generating Size Descriptors");
        FramedGraph<TransactionalGraph> framedGraph = new FramedGraph<>(graph);
        graph.startTransaction();
        size[0] = framedGraph.addVertex("800km", PlanetSize.class);
        size[0].setWorldSize("800km");
        size[0].setSurfaceGravity("0");

        size[1] = framedGraph.addVertex("1600km", PlanetSize.class);
        size[1].setWorldSize("1600km");
        size[1].setSurfaceGravity("0.05");

        size[2] = framedGraph.addVertex("3200km", PlanetSize.class);
        size[2].setWorldSize( "3200km");
        size[2].setSurfaceGravity("0.15");

        size[3] = framedGraph.addVertex("4800km", PlanetSize.class);
        size[3].setWorldSize("4800km");
        size[3].setSurfaceGravity("0.25");

        size[4] = framedGraph.addVertex("6400km", PlanetSize.class);
        size[4].setWorldSize("6400km");
        size[4].setSurfaceGravity("0.35");

        size[5] = framedGraph.addVertex("8000km", PlanetSize.class);
        size[5].setWorldSize("8000km");
        size[5].setSurfaceGravity("0.45");

        size[6] = framedGraph.addVertex("9600km", PlanetSize.class);
        size[6].setWorldSize("9600km");
        size[6].setSurfaceGravity("0.7");

        size[7] = framedGraph.addVertex("11200km", PlanetSize.class);
        size[7].setWorldSize("11200km");
        size[7].setSurfaceGravity("0.9");

        size[8] = framedGraph.addVertex("12800km", PlanetSize.class);
        size[8].setWorldSize("12800km");
        size[8].setSurfaceGravity("1.0");

        size[9] = framedGraph.addVertex("14400km", PlanetSize.class);
        size[9].setWorldSize("14400km");
        size[9].setSurfaceGravity("1.25");

        size[10] = framedGraph.addVertex("1600km", PlanetSize.class);
        size[10].setWorldSize("16000km");
        size[10].setSurfaceGravity("1.4");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }

    protected void generateAtmosphereDescriptorNodes(TransactionalGraph graph){
        System.out.println("Generating Atmosphere Descriptors");
        FramedGraph<TransactionalGraph> framedGraph = new FramedGraph<>(graph);
        graph.startTransaction();
        atmosphere[0] = framedGraph.addVertex("None", PlanetAtmosphere.class);
        atmosphere[0].setAtmosphere("None");
        atmosphere[0].setPressure("0.00");
        atmosphere[0].setSurvivalGearRequired("Vacc Suit");

        atmosphere[1] = framedGraph.addVertex("Trace", PlanetAtmosphere.class);
        atmosphere[1].setAtmosphere("Trace");
        atmosphere[1].setPressure("0.01 - 0.09");
        atmosphere[1].setSurvivalGearRequired("Vacc Suit");

        atmosphere[2] = framedGraph.addVertex("Very Thin, Tainted", PlanetAtmosphere.class);
        atmosphere[2].setAtmosphere("Very Thin, Tainted");
        atmosphere[2].setPressure("0.1 - 0.42");
        atmosphere[2].setSurvivalGearRequired("Respirator, Filter");

        atmosphere[3] = framedGraph.addVertex("Very Thin", PlanetAtmosphere.class);
        atmosphere[3].setAtmosphere("Very Thin");
        atmosphere[3].setPressure("0.1 - 0.42");
        atmosphere[3].setSurvivalGearRequired("Respirator");

        atmosphere[4] = framedGraph.addVertex("Thin, Tainted", PlanetAtmosphere.class);
        atmosphere[4].setAtmosphere("Thin, Tainted");
        atmosphere[4].setPressure("0.43 - 0.7");
        atmosphere[4].setSurvivalGearRequired("Filter");

        atmosphere[5] = framedGraph.addVertex("Thin", PlanetAtmosphere.class);
        atmosphere[5].setAtmosphere("Thin");
        atmosphere[5].setPressure("0.43 - 0.7");
        atmosphere[5].setSurvivalGearRequired("None");

        atmosphere[6] = framedGraph.addVertex("Standard", PlanetAtmosphere.class);
        atmosphere[6].setAtmosphere("Standard");
        atmosphere[6].setPressure("0.71 - 1.49");
        atmosphere[6].setSurvivalGearRequired("None");

        atmosphere[7] = framedGraph.addVertex("Standard, Tainted", PlanetAtmosphere.class);
        atmosphere[7].setAtmosphere("Standard, Tainted");
        atmosphere[7].setPressure("0.71 - 1.49");
        atmosphere[7].setSurvivalGearRequired("Filter");

        atmosphere[8] = framedGraph.addVertex("Dense", PlanetAtmosphere.class);
        atmosphere[8].setAtmosphere("Dense");
        atmosphere[8].setPressure("1.5 - 2.49");
        atmosphere[8].setSurvivalGearRequired("None");

        atmosphere[9] = framedGraph.addVertex("Dense, Tainted", PlanetAtmosphere.class);
        atmosphere[9].setAtmosphere("Dense, Tainted");
        atmosphere[9].setPressure("1.5 - 2.49");
        atmosphere[9].setSurvivalGearRequired("Filter");

        atmosphere[10] = framedGraph.addVertex("Exotic", PlanetAtmosphere.class);
        atmosphere[10].setAtmosphere("Exotic");
        atmosphere[10].setPressure("Varies");
        atmosphere[10].setSurvivalGearRequired("Air Supply");

        atmosphere[11] = framedGraph.addVertex("Corrosive", PlanetAtmosphere.class);
        atmosphere[11].setAtmosphere("Corrosive");
        atmosphere[11].setPressure("Varies");
        atmosphere[11].setSurvivalGearRequired("Vacc Suit");

        atmosphere[12] = framedGraph.addVertex("Insidious", PlanetAtmosphere.class);
        atmosphere[12].setAtmosphere("Insidious");
        atmosphere[12].setPressure("Varies");
        atmosphere[12].setSurvivalGearRequired("Vacc Suit");

        atmosphere[13] = framedGraph.addVertex("Dense, High", PlanetAtmosphere.class);
        atmosphere[13].setAtmosphere("Dense, High");
        atmosphere[13].setPressure("2.5+");
        atmosphere[13].setSurvivalGearRequired("None");

        atmosphere[14] = framedGraph.addVertex("Thin, Low", PlanetAtmosphere.class);
        atmosphere[14].setAtmosphere("Thin, Low");
        atmosphere[14].setPressure("0.00 - 0.5");
        atmosphere[14].setSurvivalGearRequired("None");

        atmosphere[15] = framedGraph.addVertex("Unusual", PlanetAtmosphere.class);
        atmosphere[15].setAtmosphere("Unusual");
        atmosphere[15].setPressure("Varies");
        atmosphere[15].setSurvivalGearRequired("Varies");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }

    protected void generateTemperatureDescriptorNodes(TransactionalGraph graph){
        System.out.println("Generating Temperature Descriptors");
        FramedGraph<TransactionalGraph> framedGraph = new FramedGraph<>(graph);
        graph.startTransaction();
        temperature[0] = framedGraph.addVertex("Frozen", PlanetTemperature.class);
        temperature[0].setTemperatureType("Frozen");
        temperature[0].setAverageTemperature("-51C or less");
        temperature[0].setDescription("Frozen world. No liquid water, very dry atmosphere.");
        temperature[1] = temperature[0];
        temperature[2] = temperature[0];

        temperature[3] = framedGraph.addVertex("Cold", PlanetTemperature.class);
        temperature[3].setTemperatureType("Cold");
        temperature[3].setAverageTemperature("-51C - 0C");
        temperature[3].setDescription("Icy world. Little liquid water, extensive ice caps, few clouds.");
        temperature[4] = temperature[3];

        temperature[5] = framedGraph.addVertex("Temperate", PlanetTemperature.class);
        temperature[5].setTemperatureType("Temperate");
        temperature[5].setAverageTemperature("0C - 30C");
        temperature[5].setDescription("Temperate world. Earthlike. Liquid and vaporised water are common, moderate ice caps.");
        temperature[6] = temperature[5];
        temperature[7] = temperature[5];
        temperature[8] = temperature[5];
        temperature[9] = temperature[5];

        temperature[10] = framedGraph.addVertex("Hot", PlanetTemperature.class);
        temperature[10].setTemperatureType("Hot");
        temperature[10].setAverageTemperature("31C - 80C");
        temperature[10].setDescription("Hot world. Small or no ice caps, little liquid water. Most water in the form of clouds.");
        temperature[11] = temperature[10];

        temperature[12] = framedGraph.addVertex("Very Hot", PlanetTemperature.class);
        temperature[12].setTemperatureType("Very Hot");
        temperature[12].setAverageTemperature("81C or greater");
        temperature[12].setDescription("Boiling world. No ice caps, little liquid water.");
        temperature[13] = temperature[12];
        temperature[14] = temperature[12];
        temperature[15] = temperature[12];
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }

    protected void generateHydrographicDescriptorNodes(TransactionalGraph graph){
        System.out.println("Generating Hydrographic Descriptors");
        FramedGraph<TransactionalGraph> framedGraph = new FramedGraph<>(graph);
        graph.startTransaction();
        hydrographics[0] = framedGraph.addVertex("0%-5%", PlanetHydrographics.class);
        hydrographics[0].setPercentage("0%-5%");
        hydrographics[0].setDescription("Desert world");

        hydrographics[1] = framedGraph.addVertex("6%-15%", PlanetHydrographics.class);
        hydrographics[1].setPercentage("6%-15%");
        hydrographics[1].setDescription("Dry world");

        hydrographics[2] = framedGraph.addVertex("16%-25%", PlanetHydrographics.class);
        hydrographics[2].setPercentage("16%-25%");
        hydrographics[2].setDescription("A few small seas");

        hydrographics[3] = framedGraph.addVertex("26%-35%", PlanetHydrographics.class);
        hydrographics[3].setPercentage("26%-35%");
        hydrographics[3].setDescription("Small seas and oceans");

        hydrographics[4] = framedGraph.addVertex("36%-45%", PlanetHydrographics.class);
        hydrographics[4].setPercentage("36%-45%");
        hydrographics[4].setDescription("Wet world");

        hydrographics[5] = framedGraph.addVertex("46%-55%", PlanetHydrographics.class);
        hydrographics[5].setPercentage("46%-55%");
        hydrographics[5].setDescription("Large oceans");

        hydrographics[6] = framedGraph.addVertex("56%-65%", PlanetHydrographics.class);
        hydrographics[6].setPercentage("56%-65%");
        hydrographics[6].setDescription("Large oceans");

        hydrographics[7] = framedGraph.addVertex("66%-75%", PlanetHydrographics.class);
        hydrographics[7].setPercentage("66%-75%");
        hydrographics[7].setDescription("Earth-like world");

        hydrographics[8] = framedGraph.addVertex("76%-85%", PlanetHydrographics.class);
        hydrographics[8].setPercentage("76%-85%");
        hydrographics[8].setDescription("Water world");

        hydrographics[9] = framedGraph.addVertex("86%-95%", PlanetHydrographics.class);
        hydrographics[9].setPercentage("86%-95%");
        hydrographics[9].setDescription("Only a few small islands and archipelagos");

        hydrographics[10] = framedGraph.addVertex("96%-100%", PlanetHydrographics.class);
        hydrographics[10].setPercentage("96%-100%");
        hydrographics[10].setDescription("Almost entirely water");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }

    protected void generatePopulationDescriptorNodes(TransactionalGraph graph){
        System.out.println("Generating Population Descriptors");
        FramedGraph<TransactionalGraph> framedGraph = new FramedGraph<>(graph);
        graph.startTransaction();
        population[0] = framedGraph.addVertex("0", PlanetPopulation.class);
        population[0].setPopulationRange("0");
        population[0].setDescription("Uninhabited");

        population[1] = framedGraph.addVertex("1-99", PlanetPopulation.class);
        population[1].setPopulationRange("1-99");
        population[1].setDescription("A tiny farmstead or a single family.");

        population[2] = framedGraph.addVertex("100-999", PlanetPopulation.class);
        population[2].setPopulationRange("100-999");
        population[2].setDescription("A village");

        population[3] = framedGraph.addVertex("1,000-9,999", PlanetPopulation.class);
        population[3].setPopulationRange("1,000-9,999");
        population[3].setDescription("A few villages");

        population[4] = framedGraph.addVertex("10,000-99,999", PlanetPopulation.class);
        population[4].setPopulationRange("10,000-99,999");
        population[4].setDescription("Small town");

        population[5] = framedGraph.addVertex("100,000-999,999", PlanetPopulation.class);
        population[5].setPopulationRange("100,000-999,999");
        population[5].setDescription("Average city");

        population[6] = framedGraph.addVertex("1,000,000-9,999,999", PlanetPopulation.class);
        population[6].setPopulationRange("1,000,000-9,999,999");
        population[6].setDescription("A few average cities");

        population[7] = framedGraph.addVertex("10,000,000-99,999,999", PlanetPopulation.class);
        population[7].setPopulationRange("10,000,000-99,999,999");
        population[7].setDescription("Large city");

        population[8] = framedGraph.addVertex("100,000,000-999,999,999", PlanetPopulation.class);
        population[8].setPopulationRange("100,000,000-999,999,999");
        population[8].setDescription("A few large cities");

        population[9] = framedGraph.addVertex("1,000,000,000-9,999,999,999", PlanetPopulation.class);
        population[9].setPopulationRange("1,000,000,000-9,999,999,999");
        population[9].setDescription("Present day Earth");

        population[10] = framedGraph.addVertex("10,000,000,000-99,999,999,999", PlanetPopulation.class);
        population[10].setPopulationRange("10,000,000,000-99,999,999,999");
        population[10].setDescription("Crowded world");

        population[11] = framedGraph.addVertex("100,000,000,000-999,999,999,999", PlanetPopulation.class);
        population[11].setPopulationRange("100,000,000,000-999,999,999,999");
        population[11].setDescription("Incredibly crowded world");

        population[11] = framedGraph.addVertex("1,000,000,000,000 and greater", PlanetPopulation.class);
        population[11].setPopulationRange("1,000,000,000,000 and greater");
        population[11].setDescription("World-city");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }

    protected void generateGovernmentDescriptorNodes(TransactionalGraph graph){
        System.out.println("Generating Government Descriptors");
        FramedGraph<TransactionalGraph> framedGraph = new FramedGraph<>(graph);
        graph.startTransaction();
        government[0] = framedGraph.addVertex("None", PlanetGovernment.class);
        government[0].setType("None");
        government[0].setDescription("No government struction. In many cases, family bonds predominate.");
        government[0].setExamples("Family, Clan, Anarchy");
        government[0].setCommonContraband("None");

        government[1] = framedGraph.addVertex("Company/Corporation", PlanetGovernment.class);
        government[1].setType("Company/Corporation");
        government[1].setDescription("Ruling functions are assumed by a company managerial elite, and most citizenry are company employees or dependants.");
        government[1].setExamples("Corporate outpost, asteroid mine, feudal domain");
        government[1].setCommonContraband("Weapons, Drugs, Travellers");

        government[2] = framedGraph.addVertex("Participating democracy", PlanetGovernment.class);
        government[2].setType("Participating democracy");
        government[2].setDescription("Ruling functions are reached by the advice and consent of the citizenry directly.");
        government[2].setExamples("Collective, tribal council, comm-linked consensus");
        government[2].setCommonContraband("Drugs");

        government[3] = framedGraph.addVertex("Self-perpetuating oligarchy", PlanetGovernment.class);
        government[3].setType("Self-perpetuating oligarchy");
        government[3].setDescription("Ruling functions are performed by a restricted minority, with little or no input from the mass of citizenry.");
        government[3].setExamples("Plutocracy, hereditary ruling caste");
        government[3].setCommonContraband("Technology, Weapons, Travellers");

        government[4] = framedGraph.addVertex("Representative democracy", PlanetGovernment.class);
        government[4].setType("Representative democracy");
        government[4].setDescription("Ruling functions are performed by elected representatives.");
        government[4].setExamples("Republic, democracy");
        government[4].setCommonContraband("Drugs, Weapons, Psionics");

        government[5] = framedGraph.addVertex("Feudal technocracy", PlanetGovernment.class);
        government[5].setType("Feudal technocracy");
        government[5].setDescription("Ruling functions are performed by specific individuals for persons who agree to be ruled by them. Relationships are based on the performance of technical activities which are mutually beneficial.");
        government[5].setExamples("");
        government[5].setCommonContraband("Technology, Weapons, Computers");

        government[6] = framedGraph.addVertex("Captive government", PlanetGovernment.class);
        government[6].setType("Captive government");
        government[6].setDescription("Ruling functions are performed by an imposed leadership answerable to an outside group.");
        government[6].setExamples("A colony or conquered area");
        government[6].setCommonContraband("Weapons, Technology, Travellers");

        government[7] = framedGraph.addVertex("Balkanisation", PlanetGovernment.class);
        government[7].setType("Balkanisation");
        government[7].setDescription("No central authority exists; rival governments compete for control. Law level refers to the government nearest the starport.");
        government[7].setExamples("Multiple governments, civil war");
        government[7].setCommonContraband("Varies");

        government[8] = framedGraph.addVertex("Civil service bureaucracy", PlanetGovernment.class);
        government[8].setType("Civil service bureaucracy");
        government[8].setDescription("Ruling functions are performed by government agencies employing individuals selected for their expertise.");
        government[8].setExamples("Technocracy, Communism");
        government[8].setCommonContraband("Drugs, Weapons");

        government[9] = framedGraph.addVertex("Impersonal Bureaucracy", PlanetGovernment.class);
        government[9].setType("Impersonal Bureaucracy");
        government[9].setDescription("Ruling functions are performed by agencies which have become insulated from the governed citizens.");
        government[9].setExamples("Entrenched castes of bureaucrats, decaying empire");
        government[9].setCommonContraband("Technology, Weapons, Drugs, Travellers, Psionics");

        government[10] = framedGraph.addVertex("Charismatic dictator", PlanetGovernment.class);
        government[10].setType("Charismatic dictator");
        government[10].setDescription("Ruling functions are performed by agencies directed by a single leader who enjoys the overwhelming confidence of the citizens.");
        government[10].setExamples("Revolutionary leader, messiah, emperor");
        government[10].setCommonContraband("None");

        government[11] = framedGraph.addVertex("Non-charismatic leader", PlanetGovernment.class);
        government[11].setType("Non-charismatic leader");
        government[11].setDescription("A previous charismatic dictator has been replaced by a leader through normal channels.");
        government[11].setExamples("Military dictatorship, hereditary kingship");
        government[11].setCommonContraband("Weapons, Technology, Computers");

        government[12] = framedGraph.addVertex("Charismatic oligarchy", PlanetGovernment.class);
        government[12].setType("Charismatic oligarchy");
        government[12].setDescription("Ruling functions are performed by a select group of members of an organisation or class which enjoys the overwhelming confidence of the citizenry.");
        government[12].setExamples("Junta, revolutionary council");
        government[12].setCommonContraband("Weapons");

        government[13] = framedGraph.addVertex("Religious dicatorship", PlanetGovernment.class);
        government[13].setType("Religious dictatorship");
        government[13].setDescription("Ruling functions are performed by a religious organisation without regard to the specific individual needs of the citizenry.");
        government[13].setExamples("Cult, transcendent philosophy, psionic group mind");
        government[13].setCommonContraband("Varies");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }
    
    protected void generateLawDescriptorNodes(TransactionalGraph graph){
        System.out.println("Generating Law Descriptors");
        FramedGraph<TransactionalGraph> framedGraph = new FramedGraph<>(graph);
        graph.startTransaction();
        law[0] = framedGraph.addVertex(null, PlanetLaw.class);
        law[0].setWeaponRestrictions("No Restrictions");
        law[0].setDrugRestrictions("No Restrictions");
        law[0].setInformationRestrictions("No Restrictions");
        law[0].setTechnologyRestrictions("No Restrictions");
        law[0].setTravellerRestrictions("No Restrictions");
        law[0].setPsionicRestrictions("No Restrictions");

        law[1] = framedGraph.addVertex(null, PlanetLaw.class);
        law[1].setWeaponRestrictions("Poison gas, explosives, undetectable weapons, WMD");
        law[1].setDrugRestrictions("Highly addictive and dangerous narcotics");
        law[1].setInformationRestrictions("Intellect programs");
        law[1].setTechnologyRestrictions("Dangerous technologies such as nanotechnology");
        law[1].setTravellerRestrictions("Visitors must contact planetary authorities by radio, landing is permitted anywhere");
        law[1].setPsionicRestrictions("Dangerous talents must be registered");

        law[2] = framedGraph.addVertex(null, PlanetLaw.class);
        law[2].setWeaponRestrictions("Portable energy weapons (except ship-mounted weapons)");
        law[2].setDrugRestrictions("Highly addictive narcotics");
        law[2].setInformationRestrictions("Agent programs");
        law[2].setTechnologyRestrictions("Alien technology");
        law[2].setTravellerRestrictions("Visitors must report passenger manifest, landing is permitted anywhere");
        law[2].setPsionicRestrictions("All psionic powers must be registered; use of dangerous powers forbidden");

        law[3] = framedGraph.addVertex(null, PlanetLaw.class);
        law[3].setWeaponRestrictions("Heavy weapons");
        law[3].setDrugRestrictions("Combat drugs");
        law[3].setInformationRestrictions("Intrusion programs");
        law[3].setTechnologyRestrictions("TL 15 items");
        law[3].setTravellerRestrictions("Landing only at starport or other authorised sites");
        law[3].setPsionicRestrictions("Use of telepathy restricted to government-approved telepaths");

        law[4] = framedGraph.addVertex(null, PlanetLaw.class);
        law[4].setWeaponRestrictions("Light assault weapons and submachine guns");
        law[4].setDrugRestrictions("Addictive narcotics");
        law[4].setInformationRestrictions("Security programs");
        law[4].setTechnologyRestrictions("TL 13 items");
        law[4].setTravellerRestrictions("Landing only at starport");
        law[4].setPsionicRestrictions("Use of teleportation and clairvoyance restricted");

        law[5] = framedGraph.addVertex(null, PlanetLaw.class);
        law[5].setWeaponRestrictions("Personal concealable weapons");
        law[5].setDrugRestrictions("Anagathics");
        law[5].setInformationRestrictions("Expert programs");
        law[5].setTechnologyRestrictions("TL 11 items");
        law[5].setTravellerRestrictions("Citizens must register offworld travel, visitors must register all business");
        law[5].setPsionicRestrictions("Use of all psionic powers restricted to government psionicists");

        law[6] = framedGraph.addVertex(null, PlanetLaw.class);
        law[6].setWeaponRestrictions("All firearms except shotguns and stunners; carrying weapons discouraged");
        law[6].setDrugRestrictions("Fast and Slow drugs");
        law[6].setInformationRestrictions("Recent news from offworld");
        law[6].setTechnologyRestrictions("TL 9 items");
        law[6].setTravellerRestrictions("Visits discouraged; excessive contact with citizens forbidden");
        law[6].setPsionicRestrictions("Possession of psionic drugs banned");

        law[7] = framedGraph.addVertex(null, PlanetLaw.class);
        law[7].setWeaponRestrictions("Shotguns");
        law[7].setDrugRestrictions( "All narcotics");
        law[7].setInformationRestrictions("Library programs, unfiltered data about other worlds. Free speech curtailed");
        law[7].setTechnologyRestrictions("TL 7 items");
        law[7].setTravellerRestrictions("Citizens may not leave planet; visitors may not leave starport");
        law[7].setPsionicRestrictions("Use of psionics forbidden");

        law[8] = framedGraph.addVertex(null, PlanetLaw.class);
        law[8].setWeaponRestrictions("All bladed weapons, stunners");
        law[8].setDrugRestrictions("Medicinal drugs");
        law[8].setInformationRestrictions("Information technology, any non-critical data from offworld, personal media");
        law[8].setTechnologyRestrictions("TL 5 items");
        law[8].setTravellerRestrictions("Landing permitted only to designated VIPs");
        law[8].setPsionicRestrictions("Psionic-related technology banned");

        law[9] = framedGraph.addVertex(null, PlanetLaw.class);
        law[9].setWeaponRestrictions("Any weapons");
        law[9].setDrugRestrictions("All drugs");
        law[9].setInformationRestrictions("Any data from offworld. No free press");
        law[9].setTechnologyRestrictions("TL 3 items");
        law[9].setTravellerRestrictions("No offworlders permitted");
        law[9].setPsionicRestrictions("All psionics");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }
    
    protected void generateStarportDescriptorNodes(TransactionalGraph graph){
        System.out.println("Generating Starport Descriptors");
        FramedGraph<TransactionalGraph> framedGraph = new FramedGraph<>(graph);
        graph.startTransaction();
        starport[0] = framedGraph.addVertex("No Starport", PlanetStarport.class);
        starport[0].setQuality("No Starport");
        starport[0].setBerthingCost("0");
        starport[0].setFuel("None");
        starport[0].setFacilities("None");
        starport[0].setBases("None");
        starport[1] = starport[0];
        starport[2] = starport[0];

        starport[3] = framedGraph.addVertex("Frontier", PlanetStarport.class);
        starport[3].setQuality("Frontier");
        starport[3].setBerthingCost("0");
        starport[3].setFuel("None");
        starport[3].setFacilities("None");
        starport[3].setBases("Pirate 12+");
        starport[4] = starport[3];

        starport[5] = framedGraph.addVertex("Poor", PlanetStarport.class);
        starport[5].setQuality("Poor");
        starport[5].setBerthingCost("1d6 x 10");
        starport[5].setFuel("Unrefined");
        starport[5].setFacilities("Limited Repair");
        starport[5].setBases("Scout 7+, Pirate 12+");
        starport[6] = starport[5];

        starport[7] = framedGraph.addVertex("Routine", PlanetStarport.class);
        starport[7].setQuality("Routine");
        starport[7].setBerthingCost("1d6 x 100");
        starport[7].setFuel("Unrefined");
        starport[7].setFacilities("Shipyard (small craft), Repair");
        starport[7].setBases("Scout 8+, Research 10+, TAS 10+, Consulate 10+, Pirate 10+");
        starport[8] = starport[7];

        starport[9] = framedGraph.addVertex("Good", PlanetStarport.class);
        starport[9].setQuality("Good");
        starport[9].setBerthingCost("1d6 x 500");
        starport[9].setFuel("Refined");
        starport[9].setFacilities("Shipyard (spacecraft), repair");
        starport[9].setBases("Naval 8+, Scout 8+, Research 10+, TAS 6+, Consulate 8+, Pirate 12+");
        starport[10] = starport[9];

        starport[11] = framedGraph.addVertex("Excellent", PlanetStarport.class);
        starport[11].setQuality("Excellent");
        starport[11].setBerthingCost("1d6 x 1000");
        starport[11].setFuel("Refined");
        starport[11].setFacilities("Shipyard (all), repair");
        starport[11].setBases("Naval 8+, Scout 10+, Research 8+, TAS 4+, Imperial Consulate 6+");
        starport[12] = starport[11];
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }
    
    protected void generateTechLevelDescriptorNodes(TransactionalGraph graph){
        System.out.println("Generating Tech Level Descriptors");
        FramedGraph<TransactionalGraph> framedGraph = new FramedGraph<>(graph);
        graph.startTransaction();
        techLevel[0] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[0].setDesignation("Primitive");
        techLevel[0].setDescription("No technology. TL 0 species have only disovered the simplest tools and principles, and are on par with Earth's Stone Age.");

        techLevel[1] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[1].setDesignation("Primitive");
        techLevel[1].setDescription("Roughly on a par with Bronze or Iron age technology. TL 1 science is mostly superstition, but they can manufacture weapons and work metals.");

        techLevel[2] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[2].setDesignation("Primitive");
        techLevel[2].setDescription("Renaissance technology. TL 2 brings with it a greater understanding of chemistry, physics, biology, and astronomy as well as the scientific method.");

        techLevel[3] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[3].setDesignation("Primitive");
        techLevel[3].setDescription("The advances of TL 2 are now applied, bringing the germ of industrial revolution and steam power. Primitive firearms now dominate the battlefield. This is roughly comparable to the early 19th century.");

        techLevel[4] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[4].setDesignation("Industrial");
        techLevel[4].setDescription("The transition to industrial revolution is complete, bringing plastics, radio and other such inventions. Roughly comparable to the late 19th/early 20th century.");

        techLevel[5] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[5].setDesignation("Industrial");
        techLevel[5].setDescription("TL 5 brings widespread electrification, telecommunications and internal combustion. At the high end of the TL, atomics and primitive computing appear. Roughly on a par with the mid-20th century.");

        techLevel[6] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[6].setDesignation("Industrial");
        techLevel[6].setDescription("TL 6 brings the development of fission power and more advanced computing. Advances in materials technology and rocketry bring about the dawn of the space age.");

        techLevel[7] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[7].setDesignation("Pre-Stellar");
        techLevel[7].setDescription("A pre-stellar society can reach orbit reliably and has telecommunications satellites. Computers become common. At the time of writing, humanity is currently somewhere between TL 7 and TL 8.");

        techLevel[8] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[8].setDesignation("Pre-Stellar");
        techLevel[8].setDescription("At TL 8, it is possible to reach other worlds in the same system, although terraforming or full colonisation are not within the culture's capacity. Permanent space habitats become possible. Fusion power becomes commercially viable.");

        techLevel[9] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[9].setDesignation("Pre-Stellar");
        techLevel[9].setDescription("The defining element of TL 9 is the development of gravity manipulation, which makes space travel vastly safer and faster. This research leads to development of the Jump drive, which occurs near the end of this Tech Level. TL 9 cultures can colonise other worlds, although going to a colony is generally a one-way trip.");

        techLevel[10] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[10].setDesignation("Early Stellar");
        techLevel[10].setDescription("With the advent of the Jump, nearby systems are opened up. Orbital habitats and factories become common. Interstellar travel and trade lead to an economic boon. Colonies become much more viable.");

        techLevel[11] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[11].setDesignation("Early Stellar");
        techLevel[11].setDescription("The first true artificial intelligences become possible, as computers are able to model synaptic networks, Grav-supported structures reach to the heavens. Jump-2 travel becomes possible, allowing easier travel beyond the one-Jump stellar mains.");

        techLevel[12] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[12].setDesignation("Average Stellar");
        techLevel[12].setDescription("Weather control revolutionises terraforming and agriculture. Man-portable plasma weapons and carrier-mounted fusion guns make the battlefield untenable for unarmoured combatants. Jump-3 travel is developed.");

        techLevel[13] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[13].setDesignation("Average Stellar");
        techLevel[13].setDescription("The battle dress appears on the battlefield in response to the new weapons. Cloning of body parts becomes easy. Advances in hull design and thruster plates means that spacecraft can easily enter atmosphere and even go underwater. Jump-4 travel is developed.");

        techLevel[14] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[14].setDesignation("Average Stellar");
        techLevel[14].setDescription("Fusion weapons become man-portable. Flying cities appear. Jump-5 travel is developed.");

        techLevel[15] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[15].setDesignation("High Stellar");
        techLevel[15].setDescription("Black globe generators suggest a new direction for defensive technologies, while the development of synthetic anagathics means that the human lifespan is now vastly increased. Jump-6 travel is developed.");

        techLevel[16] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[16].setDesignation("Unknown");
        techLevel[16].setDescription("Unknown");

        techLevel[17] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[17].setDesignation("Unknown");
        techLevel[17].setDescription("Unknown");

        techLevel[18] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[18].setDesignation("Unknown");
        techLevel[18].setDescription("Unknown");

        techLevel[19] = framedGraph.addVertex(null, PlanetTechLevel.class);
        techLevel[19].setDesignation("Unknown");
        techLevel[19].setDescription("Unknown");
        graph.stopTransaction(TransactionalGraph.Conclusion.SUCCESS);
    }
}
