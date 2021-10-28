/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDAO;

import com.app.SuperheroApplication.SuperheroDTO.HeroDTO;
import com.app.SuperheroApplication.SuperheroDTO.LocationDTO;
import com.app.SuperheroApplication.SuperheroDTO.OrganizationDTO;
import java.util.List;

/**
 *
 * @author 
 */
public interface HeroDao {
    
    HeroDTO addHero(HeroDTO hero);
    HeroDTO getHeroByID(int id);
    void updateHero(HeroDTO hero);
    void deleteHeroByID(int id);
    List<HeroDTO> getAllHeroes();
    List<HeroDTO> heroesSightedAtALocation(LocationDTO location);
    
}
