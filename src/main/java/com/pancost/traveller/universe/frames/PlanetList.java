package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.Relation;
import com.tinkerpop.frames.VertexFrame;
import java.util.Collection;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetList extends VertexFrame {
    @Property("indexed")
    public void setIndexed(String indexed);
    @Property("indexed")
    public String getIndexed();
    
    @Relation(label="planetList")
    public Collection<Planet> getPlanetList();
    @Relation(label="planetList")
    public void addPlanetToList(Planet planet);
    @Relation(label="planetList")
    public void removePlanetFromList(Planet planet);
}
