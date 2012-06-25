package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Domain;
import com.tinkerpop.frames.EdgeFrame;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.Range;

/**
 *
 * @author Brandon Pancost
 */
public interface Shift extends EdgeFrame {
    @Property("name")
    public void setName(String name);
    @Property("name")
    public String getName();
    
    @Property("traffic")
    public void setTraffic(String traffic);
    @Property("traffic")
    public String getTraffic();
    
    @Property("trafficRaw")
    public void setTrafficRaw(Integer traffic);
    @Property("trafficRaw")
    public Integer getTrafficRaw();
    
    @Property("connection")
    public void setConnection(String connection);
    @Property("connection")
    public String getConnection();
    
    @Domain()
    public Planet getFromPlanet();
    @Range()
    public Planet getToPlanet();
}
