package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetPopulation {    
    @Property("populationRange")
    public void setPopulationRange(String populationRange);
    @Property("populationRange")
    public String getPopulationRange();
    
    @Property("description")
    public void setDescription(String description);
    @Property("description")
    public String getDescription();
}
