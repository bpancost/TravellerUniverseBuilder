package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetPopulation extends VertexFrame {    
    @Property("populationRange")
    public void setPopulationRange(String populationRange);
    @Property("populationRange")
    public String getPopulationRange();
    
    @Property("description")
    public void setDescription(String description);
    @Property("description")
    public String getDescription();
}
