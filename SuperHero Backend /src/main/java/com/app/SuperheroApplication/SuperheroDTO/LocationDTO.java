/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 
 */
public class LocationDTO {
    
    int id;
    String locationName;
    String locationDescription;
    String locationAddress;
    BigDecimal locationLatitude;
    BigDecimal locationLongitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public BigDecimal getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(BigDecimal locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public BigDecimal getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(BigDecimal locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.locationName);
        hash = 89 * hash + Objects.hashCode(this.locationDescription);
        hash = 89 * hash + Objects.hashCode(this.locationAddress);
        hash = 89 * hash + Objects.hashCode(this.locationLatitude);
        hash = 89 * hash + Objects.hashCode(this.locationLongitude);
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
        final LocationDTO other = (LocationDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.locationName, other.locationName)) {
            return false;
        }
        if (!Objects.equals(this.locationDescription, other.locationDescription)) {
            return false;
        }
        if (!Objects.equals(this.locationAddress, other.locationAddress)) {
            return false;
        }
        if (!Objects.equals(this.locationLatitude, other.locationLatitude)) {
            return false;
        }
        if (!Objects.equals(this.locationLongitude, other.locationLongitude)) {
            return false;
        }
        return true;
    }
    
}
