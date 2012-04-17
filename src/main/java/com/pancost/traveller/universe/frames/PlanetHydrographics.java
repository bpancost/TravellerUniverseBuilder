package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetHydrographics {
    @Property("percentage")
    public void setPercentage(String percentage);
    @Property("percentage")
    public String getPercentage();
    
    @Property("description")
    public void setDescription(String description);
    @Property("description")
    public String getDescription();
}
