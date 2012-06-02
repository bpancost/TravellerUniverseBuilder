package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetList extends VertexFrame {
    @Property("indexed")
    public void setIndexed(String indexed);
    @Property("indexed")
    public String getIndexed();
    
    @Adjacency(label="planetList")
    public Iterable<Planet> getPlanetList();
    @Adjacency(label="planetList")
    public void addPlanetToList(Planet planet);
    @Adjacency(label="planetList")
    public void removePlanetFromList(Planet planet);
}
