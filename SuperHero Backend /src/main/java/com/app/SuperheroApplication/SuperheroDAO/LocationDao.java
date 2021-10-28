/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDAO;

import com.app.SuperheroApplication.SuperheroDTO.HeroDTO;
import com.app.SuperheroApplication.SuperheroDTO.LocationDTO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 
 */
public interface LocationDao {
    
    LocationDTO addLocation(LocationDTO location);
    LocationDTO getLocationByID(int id);
    LocationDTO updateLocation(LocationDTO location);
   public void deleteLocationByID(int id);
    List<LocationDTO> getAllLocations();
    List<LocationDTO> allLocationsVisitedByAHero(HeroDTO hero);
    
    
}
