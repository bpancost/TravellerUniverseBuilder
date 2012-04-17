package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetTechLevel {
    @Property("designation")
    public void setDesignation(String designation);
    @Property("designation")
    public String getDesignation();
    
    @Property("description")
    public void setDescription(String description);
    @Property("description")
    public String getDescription();
}
