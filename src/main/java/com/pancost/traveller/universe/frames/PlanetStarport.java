package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetStarport extends VertexFrame {
    @Property("quality")
    public void setQuality(String quality);
    @Property("quality")
    public String getQuality();
    
    @Property("berthingCost")
    public void setBerthingCost(String berthingCost);
    @Property("berthingCost")
    public String getBerthingCost();
    
    @Property("fuel")
    public void setFuel(String fuel);
    @Property("fuel")
    public String getFuel();
    
    @Property("facilities")
    public void setFacilities(String facilities);
    @Property("facilities")
    public String getFacilities();
    
    @Property("bases")
    public void setBases(String bases);
    @Property("bases")
    public String getBases();
}
