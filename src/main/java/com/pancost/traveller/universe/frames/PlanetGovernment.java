package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetGovernment extends VertexFrame {
    @Property("type")
    public void setType(String type);
    @Property("type")
    public String getType();
    
    @Property("description")
    public void setDescription(String description);
    @Property("description")
    public String getDescription();
    
    @Property("examples")
    public void setExamples(String examples);
    @Property("examples")
    public String getExamples();
    
    @Property("commonContraband")
    public void setCommonContraband(String commonContraband);
    @Property("commonContraband")
    public String getCommonContraband();
}
