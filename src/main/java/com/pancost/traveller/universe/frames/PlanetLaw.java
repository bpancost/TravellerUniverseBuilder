package com.pancost.traveller.universe.frames;

import com.tinkerpop.frames.Property;

/**
 *
 * @author Brandon Pancost
 */
public interface PlanetLaw {
    @Property("weaponRestrictions")
    public void setWeaponRestrictions(String weaponRestrictions);
    @Property("weaponRestrictions")
    public String getWeaponRestrictions();
    
    @Property("drugRestrictions")
    public void setDrugRestrictions(String drugRestrictions);
    @Property("drugRestrictions")
    public String getDrugRestrictions();
    
    @Property("informationRestrictions")
    public void setInformationRestrictions(String informationRestrictions);
    @Property("informationRestrictions")
    public String getInformationRestrictions();
    
    @Property("technologyRestrictions")
    public void setTechnologyRestrictions(String technologyRestrictions);
    @Property("technologyRestrictions")
    public String getTechnologyRestrictions();
    
    @Property("travellerRestrictions")
    public void setTravellerRestrictions(String travellerRestrictions);
    @Property("travellerRestrictions")
    public String getTravellerRestrictions();
    
    @Property("psionicRestrictions")
    public void setPsionicRestrictions(String psionicRestrictions);
    @Property("psionicRestrictions")
    public String getPsionicRestrictions();
}
