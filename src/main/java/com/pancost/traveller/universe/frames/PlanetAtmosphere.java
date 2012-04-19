package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetAtmosphere extends VertexFrame {
    @Property("atmosphere")
    public void setAtmosphere(String atmosphere);
    @Property("atmosphere")
    public String getAtmosphere();
    
    @Property("pressure")
    public void setPressure(String pressure);
    @Property("pressure")
    public String getPressure();
    
    @Property("survivalGearRequired")
    public void setSurvivalGearRequired(String survivalGearRequired);
    @Property("survivalGearRequired")
    public String getSurvivalGearRequired();
}
