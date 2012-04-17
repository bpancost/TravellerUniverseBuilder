package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetAtmosphere {
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
