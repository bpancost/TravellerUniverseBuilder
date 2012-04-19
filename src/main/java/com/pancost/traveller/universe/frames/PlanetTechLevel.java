package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetTechLevel extends VertexFrame {
    @Property("designation")
    public void setDesignation(String designation);
    @Property("designation")
    public String getDesignation();
    
    @Property("description")
    public void setDescription(String description);
    @Property("description")
    public String getDescription();
}
