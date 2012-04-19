package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.Relation;
import com.tinkerpop.frames.VertexFrame;
import java.util.Collection;

/**
 *
 * @author Brandon Pancost
 */
public interface Planet extends VertexFrame {
    @Property("designation")
    public void setDesignation(String designation);
    @Property("designation")
    public String getDesignation();
  
    @Property("name")
    public void setName(String name);
    @Property("name")
    public String getName();
  
    @Relation(label="planetSize")
    public PlanetSize getPlanetSize();
    @Relation(label="planetSize")
    public void setPlanetSize(PlanetSize planetSize);
  
    @Relation(label="planetAtmosphere")
    public PlanetAtmosphere getPlanetAtmosphere();
    @Relation(label="planetAtmosphere")
    public void setPlanetAtmosphere(PlanetAtmosphere planetAtmosphere);
  
    @Relation(label="planetTemperature")
    public PlanetTemperature getPlanetTemperature();
    @Relation(label="planetTemperature")
    public void setPlanetTemperature(PlanetTemperature planetTemperature);
  
    @Relation(label="planetHydrographics")
    public PlanetHydrographics getPlanetHydrographics();
    @Relation(label="planetHydrographics")
    public void setPlanetHydrographics(PlanetHydrographics planetHydrographics);
  
    @Relation(label="planetPopulation")
    public PlanetPopulation getPlanetPopulation();
    @Relation(label="planetPopulation")
    public void setPlanetPopulation(PlanetPopulation planetPopulation);
  
    @Relation(label="planetGovernment")
    public PlanetGovernment getPlanetGovernment();
    @Relation(label="planetGovernment")
    public void setPlanetGovernment(PlanetGovernment planetGovernment);
  
    @Relation(label="planetLaw")
    public PlanetLaw getPlanetLaw();
    @Relation(label="planetLaw")
    public void setPlanetLaw(PlanetLaw planetLaw);
  
    @Relation(label="planetStarport")
    public PlanetStarport getPlanetStarport();
    @Relation(label="planetStarport")
    public void setPlanetStarport(PlanetStarport planetStarport);
  
    @Relation(label="planetTechLevel")
    public PlanetTechLevel getPlanetTechLevel();
    @Relation(label="planetTechLevel")
    public void setPlanetTechLevel(PlanetTechLevel planetTechLevel);
    
    @Relation(label="shiftPlanets")
    public Collection<Planet> getShiftPlanets();
    @Relation(label="shiftPlanets")
    public void addShiftPlanet(Planet planet);
    @Relation(label="shiftPlanets")
    public void removeShiftPlanet(Planet planet);
  
    @Adjacency(label="shiftPlanets")
    public Collection<Shift> getShifts();
}
