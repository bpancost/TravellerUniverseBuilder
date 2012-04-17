package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.Relation;
import java.util.Collection;

/**
 *
 * @author Brandon Pancost
 */
public interface Shift {
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
    
    @Relation(label="shiftPlanets")
    public Collection<Planet> getShiftPlanets();
    @Relation(label="shiftPlanets")
    public void addShiftPlanet(Planet planet);
    @Relation(label="shiftPlanets")
    public void removeShiftPlanet(Planet planet);
}
