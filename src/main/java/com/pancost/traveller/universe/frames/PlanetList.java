package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Relation;
import java.util.Collection;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetList {
    @Relation(label="planetList")
    public Collection<Planet> getPlanetList();
    @Relation(label="planetList")
    public void addPlanetToList(Planet planet);
    @Relation(label="planetList")
    public void removePlanetFromList(Planet planet);
}
