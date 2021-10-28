/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.tools.DocumentationTool.Location;

/**
 *
 * @author 
 */
public class SightingsDTO {

    int id;
    LocationDTO location;
    LocalDate timeOfSighting;
 


    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public LocalDate getTimeOfSighting() {
        return timeOfSighting;
    }

    public void setTimeOfSighting(LocalDate timeOfSighting) {
        this.timeOfSighting = timeOfSighting;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.location);
        hash = 37 * hash + Objects.hashCode(this.timeOfSighting);
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
        final SightingsDTO other = (SightingsDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.timeOfSighting, other.timeOfSighting)) {
            return false;
        }
        return true;
    }

  
   

}
