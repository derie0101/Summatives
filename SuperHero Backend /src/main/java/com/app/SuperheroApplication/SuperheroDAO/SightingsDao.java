/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDAO;

import com.app.SuperheroApplication.SuperheroDTO.HeroDTO;
import com.app.SuperheroApplication.SuperheroDTO.LocationDTO;
import com.app.SuperheroApplication.SuperheroDTO.SightingsDTO;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 
 */
public interface SightingsDao {
    
    SightingsDTO addSighting(SightingsDTO sighting);
    SightingsDTO getSightingByID(int id);
    public void updateSighting(SightingsDTO sighting);
    public void deleteSightingByID(int id);
    List<SightingsDTO>getAllSighting();
    List<SightingsDTO> gettAllSightingsByLocation(LocationDTO location);
    

}
