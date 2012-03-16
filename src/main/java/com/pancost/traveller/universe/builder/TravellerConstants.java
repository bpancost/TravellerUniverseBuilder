package com.pancost.traveller.universe.builder;

/**
 *
 * @author Brandon Pancost
 */
public interface TravellerConstants {

    public enum UtilityTypes
    {
        Root("Root"), Planet("Planet");
                    
        private String property;
        
        private UtilityTypes(String property){
            this.property = property;
        }
        
        public String getProperty(){
            return this.property;
        }
    }

    public enum PlanetRelationshipTypes
    {
        Size("Size"), Atmosphere("Atmosphere"), Temperature("Temperature"),
        Hydrographics("Hydrographics"), Population("Population"),
        Government("Government"), Law("Law"), Starport("Starport"),
        TechLevel("Tech Level");
                    
        private String property;
        
        private PlanetRelationshipTypes(String property){
            this.property = property;
        }
        
        public String getProperty(){
            return this.property;
        }
    }

    public enum ShiftTypes
    {
        Shift("Shift");
            
        private String property;
        
        private ShiftTypes(String property){
            this.property = property;
        }
        
        public String getProperty(){
            return this.property;
        }
    }

    /**
     * Planet Constants
     */
    public enum PlanetProperties{
        DESIGNATION("DESIGNATION"),
        WORLD_SIZE("WORLD_SIZE"),
        SURFACE_GRAVITY("SURFACE_GRAVITY"),
        ATMOSPHERE("ATMOSPHERE"),
        PRESSURE("PRESSURE"),
        SURVIVAL_GEAR_REQUIRED("SURVIVAL_GEAR_REQUIRED"),
        AVERAGE_TEMPERATURE("AVERAGE_TEMPERATURE"),
        TEMPERATURE_TYPE("TEMPERATURE_TYPE"),
        TEMPERATURE_DESCRIPTION("TEMPERATURE_DESCRIPTION"),
        HYDROGRAPHIC_PERCENTAGE("HYDROGRAPHIC_PERCENTAGE"),
        HYDROGRAPHIC_DESCRIPTION("HYDROGRAPHIC_DESCRIPTION"),
        POPULATION_RANGE("POPULATION_RANGE"),
        POPULATION_DESCRIPTION("POPULATION_DESCRIPTION"),
        GOVERNMENT_TYPE("GOVERNMENT_TYPE"),
        GOVERNMENT_DESCRIPTION("GOVERNMENT_DESCRIPTION"),
        GOVERNMENT_EXAMPLES("GOVERNMENT_EXAMPLES"),
        GOVERNMENT_COMMON_CONTRABAND("GOVERNMENT_COMMON_CONTRABAND"),
        LAW_WEAPONS("LAW_WEAPONS"),
        LAW_DRUGS("LAW_DRUGS"),
        LAW_INFORMATION("LAW_INFORMATION"),
        LAW_TECHNOLOGY("LAW_TECHNOLOGY"),
        LAW_TRAVELLERS("LAW_TRAVELLERS"),
        LAW_PSIONICS("LAW_PSIONICS"),
        STARPORT_QUALITY("STARPORT_QUALITY"),
        STARPORT_BERTHING_COST("STARPORT_BERTHING_COST"),
        STARPORT_FUEL("STARPORT_FUEL"),
        STARPORT_FACILITIES("STARPORT_FACILITIES"),
        STARPORT_BASES("STARPORT_BASES"),
        TECH_LEVEL_DESIGNATION("TECH_LEVEL_DESIGNATION"),
        TECH_LEVEL_DESCRIPTION("TECH_LEVEL_DESCRIPTION");
    
        private String property;
        
        private PlanetProperties(String property){
            this.property = property;
        }
        
        public String getProperty(){
            return this.property;
        }
    }

    /**
     * Shift Constants
     */
    public enum ShiftProperties{
        SHIFT_STABILITY("SHIFT_STABILITY"),
        SHIFT_DANGER("SHIFT_DANGER");
        
        private String property;
        
        private ShiftProperties(String property){
            this.property = property;
        }
        
        public String getProperty(){
            return this.property;
        }
    }
}
