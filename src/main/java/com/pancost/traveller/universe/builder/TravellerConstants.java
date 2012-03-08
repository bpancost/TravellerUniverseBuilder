package com.pancost.traveller.universe.builder;

import org.neo4j.graphdb.RelationshipType;

/**
 *
 * @author Brandon Pancost
 */
public interface TravellerConstants {

    public enum UtilityTypes implements RelationshipType
    {
        ROOT, PLANET
    }

    public enum PlanetRelationshipTypes implements RelationshipType
    {
        SIZE, ATMOSPHERE, TEMPERATURE, HYDROGRAPHICS, POPULATION, GOVERNMENT, LAW, STARPORT, TECH_LEVEL
    }

    public enum ShiftTypes implements RelationshipType
    {
        Shift
    }

    //PLANET CONSTANTS
    public final String DESIGNATION = "DESIGNATION";
    public final String WORLD_SIZE = "WORLD_SIZE";
    public final String SURFACE_GRAVITY = "SURFACE_GRAVITY";
    public final String ATMOSPHERE = "ATMOSPHERE";
    public final String PRESSURE = "PRESSURE";
    public final String SURVIVAL_GEAR_REQUIRED = "SURVIVAL_GEAR_REQUIRED";
    public final String AVERAGE_TEMPERATURE = "AVERAGE_TEMPERATURE";
    public final String TEMPERATURE_TYPE = "TEMPERATURE_TYPE";
    public final String TEMPERATURE_DESCRIPTION = "TEMPERATURE_DESCRIPTION";
    public final String HYDROGRAPHIC_PERCENTAGE = "HYDROGRAPHIC_PERCENTAGE";
    public final String HYDROGRAPHIC_DESCRIPTION = "HYDROGRAPHIC_DESCRIPTION";
    public final String POPULATION_RANGE = "POPULATION_RANGE";
    public final String POPULATION_DESCRIPTION = "POPULATION_DESCRIPTION";
    public final String GOVERNMENT_TYPE = "GOVERNMENT_TYPE";
    public final String GOVERNMENT_DESCRIPTION = "GOVERNMENT_DESCRIPTION";
    public final String GOVERNMENT_EXAMPLES = "GOVERNMENT_EXAMPLES";
    public final String GOVERNMENT_COMMON_CONTRABAND = "GOVERNMENT_COMMON_CONTRABAND";
    public final String LAW_WEAPONS = "LAW_WEAPONS";
    public final String LAW_DRUGS = "LAW_DRUGS";
    public final String LAW_INFORMATION = "LAW_INFORMATION";
    public final String LAW_TECHNOLOGY = "LAW_TECHNOLOGY";
    public final String LAW_TRAVELLERS = "LAW_TRAVELLERS";
    public final String LAW_PSIONICS = "LAW_PSIONICS";
    public final String STARPORT_QUALITY = "STARPORT_QUALITY";
    public final String STARPORT_BERTHING_COST = "STARPORT_BERTHING_COST";
    public final String STARPORT_FUEL = "STARPORT_FUEL";
    public final String STARPORT_FACILITIES = "STARPORT_FACILITIES";
    public final String STARPORT_BASES = "STARPORT_BASES";
    public final String TECH_LEVEL_DESIGNATION = "TECH_LEVEL_DESIGNATION";
    public final String TECH_LEVEL_DESCRIPTION = "TECH_LEVEL_DESCRIPTION";

    //SHIFT CONSTANTS
    public final String SHIFT_STABILITY = "SHIFT_STABILITY";
    public final String SHIFT_DANGER = "SHIFT_DANGER";
}
