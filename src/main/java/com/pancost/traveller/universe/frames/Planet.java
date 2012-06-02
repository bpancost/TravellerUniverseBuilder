package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Incidence;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.VertexFrame;

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
  
    @Adjacency(label="planetSize")
    public PlanetSize getPlanetSize();
    @Adjacency(label="planetSize")
    public void setPlanetSize(PlanetSize planetSize);
  
    @Adjacency(label="planetAtmosphere")
    public PlanetAtmosphere getPlanetAtmosphere();
    @Adjacency(label="planetAtmosphere")
    public void setPlanetAtmosphere(PlanetAtmosphere planetAtmosphere);
  
    @Adjacency(label="planetTemperature")
    public PlanetTemperature getPlanetTemperature();
    @Adjacency(label="planetTemperature")
    public void setPlanetTemperature(PlanetTemperature planetTemperature);
  
    @Adjacency(label="planetHydrographics")
    public PlanetHydrographics getPlanetHydrographics();
    @Adjacency(label="planetHydrographics")
    public void setPlanetHydrographics(PlanetHydrographics planetHydrographics);
  
    @Adjacency(label="planetPopulation")
    public PlanetPopulation getPlanetPopulation();
    @Adjacency(label="planetPopulation")
    public void setPlanetPopulation(PlanetPopulation planetPopulation);
  
    @Adjacency(label="planetGovernment")
    public PlanetGovernment getPlanetGovernment();
    @Adjacency(label="planetGovernment")
    public void setPlanetGovernment(PlanetGovernment planetGovernment);
  
    @Adjacency(label="planetLaw")
    public PlanetLaw getPlanetLaw();
    @Adjacency(label="planetLaw")
    public void setPlanetLaw(PlanetLaw planetLaw);
  
    @Adjacency(label="planetStarport")
    public PlanetStarport getPlanetStarport();
    @Adjacency(label="planetStarport")
    public void setPlanetStarport(PlanetStarport planetStarport);
  
    @Adjacency(label="planetTechLevel")
    public PlanetTechLevel getPlanetTechLevel();
    @Adjacency(label="planetTechLevel")
    public void setPlanetTechLevel(PlanetTechLevel planetTechLevel);
    
    @Adjacency(label="shiftPlanets")
    public Iterable<Planet> getShiftPlanets();
    @Adjacency(label="shiftPlanets")
    public void addShiftPlanet(Planet planet);
    @Adjacency(label="shiftPlanets")
    public void removeShiftPlanet(Planet planet);
  
    @Incidence(label="shiftPlanets")
    public Iterable<Shift> getShifts();
}
