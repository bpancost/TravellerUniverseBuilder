package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.Relation;
import java.util.Collection;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetList {
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
