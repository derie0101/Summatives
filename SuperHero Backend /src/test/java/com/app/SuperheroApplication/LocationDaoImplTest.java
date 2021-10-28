/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication;

import com.app.SuperheroApplication.SuperheroDAO.HeroDao;
import com.app.SuperheroApplication.SuperheroDAO.LocationDao;
import com.app.SuperheroApplication.SuperheroDAO.OrganizationDao;
import com.app.SuperheroApplication.SuperheroDAO.SightingsDao;
import com.app.SuperheroApplication.SuperheroDTO.HeroDTO;
import com.app.SuperheroApplication.SuperheroDTO.LocationDTO;
import com.app.SuperheroApplication.SuperheroDTO.OrganizationDTO;
import com.app.SuperheroApplication.SuperheroDTO.SightingsDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationDaoImplTest {
    
    @Autowired
    LocationDao locationDao;
    
    @Autowired
    OrganizationDao organizationDao;
    
    @Autowired
    SightingsDao sightingDao;
    
    @Autowired
    HeroDao superHeroDao;
    
    
    public LocationDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<LocationDTO> locations = locationDao.getAllLocations();
        for(LocationDTO location : locations) {
            locationDao.deleteLocationByID(location.getId());
        }
        
        List<OrganizationDTO> organizations = organizationDao.getAllOrganizations();
        for(OrganizationDTO organization : organizations) {
            organizationDao.deleteOrganizationByID(organization.getId());
        }
        
        List<SightingsDTO> sightings = sightingDao.getAllSighting();
        for(SightingsDTO sighting : sightings) {
            sightingDao.deleteSightingByID(sighting.getId());
        }
        
        List<HeroDTO> superHeros = superHeroDao.getAllHeroes();
        for(HeroDTO superHero : superHeros) {
            superHeroDao.deleteHeroByID(superHero.getId());
        }
        
    }
    
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void testAddAndGetLocation() {
        LocationDTO location = new LocationDTO();
        location.setLocationName("name");
        location.setLocationDescription("description");
        location.setLocationAddress("address");
        location.setLocationLongitude(new BigDecimal("32.0000"));
        location.setLocationLatitude(new BigDecimal("32.0000"));
        location = locationDao.addLocation(location);
        
        
        LocationDTO fromDao = locationDao.getLocationByID(location.getId());
        
        assertEquals(location, fromDao);
    }
    
    @Test
    public void testGetAllLocation() {
        LocationDTO location = new LocationDTO();
        location.setLocationName("name");
        location.setLocationDescription("description");
        location.setLocationAddress("address");
        location.setLocationLongitude(new BigDecimal("32.0000"));
        location.setLocationLatitude(new BigDecimal("32.0000"));
        location = locationDao.addLocation(location);
        
        LocationDTO location2 = new LocationDTO();
        location2.setLocationName("name");
        location2.setLocationDescription("description");
        location2.setLocationAddress("address");
        location2.setLocationLongitude(new BigDecimal("32.0000"));
        location2.setLocationLatitude(new BigDecimal("32.0000"));
        location2 = locationDao.addLocation(location);
        
        List<LocationDTO> locations = locationDao.getAllLocations();
        
        assertEquals(2, locations.size());
        assertTrue(locations.contains(location));
        assertTrue(locations.contains(location2));
           
    }
    @Test
    
    public void testUpdateLocation() {
        LocationDTO location = new LocationDTO();
        location.setLocationName("name");
        location.setLocationDescription("description");
        location.setLocationAddress("address");
        location.setLocationLongitude(new BigDecimal("32.0000"));
        location.setLocationLatitude(new BigDecimal("32.0000"));
        location = locationDao.addLocation(location);
        
        LocationDTO fromDao = locationDao.getLocationByID(location.getId());
        
        assertEquals(location, fromDao);
        
        location.setLocationName("New Name");
        locationDao.updateLocation(location);
        
        assertNotEquals(location, fromDao);
        
        fromDao = locationDao.getLocationByID(location.getId());
        
        assertEquals(location, fromDao);
        
    }
    @Test
    
    public void testDeleteLocationById() {
       
       
       LocationDTO location = new LocationDTO();
        location.setLocationName("name");
        location.setLocationDescription("description");
        location.setLocationAddress("address");
        location.setLocationLongitude(new BigDecimal("32.0000"));
        location.setLocationLatitude(new BigDecimal("32.0000"));
        location = locationDao.addLocation(location);
        
        SightingsDTO sighting = new SightingsDTO();
            sighting.setTimeOfSighting(LocalDate.now());
            sighting.setLocation(location);
            sighting = sightingDao.addSighting(sighting);
            List<SightingsDTO> sightings = new ArrayList<>();
            sightings.add(sighting);

        
       HeroDTO hero = new HeroDTO();
            hero.setHeroName("Name");
            hero.setHeroDescription("Description");
            hero.setHeroSuperPower("Power");
            hero.setOrganizationList(new ArrayList());
            hero.setSightingsList(new ArrayList());
            hero.setSightingsList(sightings);
            hero = superHeroDao.addHero(hero);
        
        LocationDTO fromDao = locationDao.getLocationByID(location.getId());
        assertEquals(location, fromDao);
        
        locationDao.deleteLocationByID(location.getId());
        fromDao = locationDao.getLocationByID(location.getId());
        assertNull(fromDao);
        
        
       
       
      
       
        
        
    }
}