/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDTO;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 
 */
public class HeroDTO {
    int id;
    String heroName;
    String heroDescription;
    String heroSuperPower;
    List<SightingsDTO> sightingsList;
    List<OrganizationDTO> organizationList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroDescription() {
        return heroDescription;
    }

    public void setHeroDescription(String heroDescription) {
        this.heroDescription = heroDescription;
    }

    public String getHeroSuperPower() {
        return heroSuperPower;
    }

    public void setHeroSuperPower(String heroSuperPower) {
        this.heroSuperPower = heroSuperPower;
    }

    public List<SightingsDTO> getSightingsList() {
        return sightingsList;
    }

    public void setSightingsList(List<SightingsDTO> sightingsList) {
        this.sightingsList = sightingsList;
    }

    public List<OrganizationDTO> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<OrganizationDTO> organizationList) {
        this.organizationList = organizationList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.heroName);
        hash = 97 * hash + Objects.hashCode(this.heroDescription);
        hash = 97 * hash + Objects.hashCode(this.heroSuperPower);
        hash = 97 * hash + Objects.hashCode(this.sightingsList);
        hash = 97 * hash + Objects.hashCode(this.organizationList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HeroDTO other = (HeroDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.heroName, other.heroName)) {
            return false;
        }
        if (!Objects.equals(this.heroDescription, other.heroDescription)) {
            return false;
        }
        if (!Objects.equals(this.heroSuperPower, other.heroSuperPower)) {
            return false;
        }
        if (!Objects.equals(this.sightingsList, other.sightingsList)) {
            return false;
        }
        if (!Objects.equals(this.organizationList, other.organizationList)) {
            return false;
        }
        return true;
    }
  

  
   
    
}
