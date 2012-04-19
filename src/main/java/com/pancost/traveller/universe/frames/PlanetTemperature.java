package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetTemperature extends VertexFrame {
    @Property("temperatureType")
    public void setTemperatureType(String temperatureType);
    @Property("temperatureType")
    public String getTemperatureType();
    
    @Property("averageTemperature")
    public void setAverageTemperature(String averageTemperature);
    @Property("averageTemperature")
    public String getAverageTemperature();
    
    @Property("description")
    public void setDescription(String temperatureDescription);
    @Property("description")
    public String getDescription();
}
