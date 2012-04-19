package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.*;
import java.util.Collection;

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
    
    @Property("connection")
    public void setConnection(String connection);
    @Property("connection")
    public String getConnection();
    
    @Domain()
    public Planet getFromPlanet();
    @Range()
    public Planet getToPlanet();
}
