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
public class OrganizationDTO {
    
    int id;
    String organizationName;
    String organizationDescription;
    String organizationAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
  

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAdress) {
        this.organizationAddress = organizationAdress;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.organizationName);
        hash = 53 * hash + Objects.hashCode(this.organizationDescription);
        hash = 53 * hash + Objects.hashCode(this.organizationAddress);
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
        final OrganizationDTO other = (OrganizationDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.organizationName, other.organizationName)) {
            return false;
        }
        if (!Objects.equals(this.organizationDescription, other.organizationDescription)) {
            return false;
        }
        if (!Objects.equals(this.organizationAddress, other.organizationAddress)) {
            return false;
        }
        return true;
    }

   

    


    
    
}
