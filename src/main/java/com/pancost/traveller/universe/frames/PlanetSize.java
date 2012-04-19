package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetSize extends VertexFrame {
    @Property("worldSize")
    public void setWorldSize(String worldSize);
    @Property("worldSize")
    public String getWorldSize();
    
    @Property("surfaceGravity")
    public void setSurfaceGravity(String surfaceGravity);
    @Property("surfaceGravity")
    public String getSurfaceGravity();
}
