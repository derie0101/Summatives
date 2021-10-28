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

/**
 *
 * @author 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationDaoImplTest {
    
    @Autowired
    LocationDao locationDao;
    
    @Autowired
    OrganizationDao organizationDao;
    
    @Autowired
    SightingsDao sightingDao;
    
    @Autowired
    HeroDao superHeroDao;
    
    
    public OrganizationDaoImplTest() {
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
    public void testAddAndGetOrganization() {
        OrganizationDTO organization = new OrganizationDTO();
        organization.setOrganizationName("name");
        organization.setOrganizationDescription("description");
        organization.setOrganizationAddress("address");
        organization = organizationDao.addOrganization(organization);
        
        
        
        OrganizationDTO fromDao = organizationDao.getOrganizationByID(organization.getId());
        
        assertEquals(organization, fromDao);
    }
    
    @Test
    public void testGetAllOrganization() {
        OrganizationDTO organization = new OrganizationDTO();
        organization.setOrganizationName("name");
        organization.setOrganizationDescription("description");
        organization.setOrganizationAddress("address");
        organization = organizationDao.addOrganization(organization);
        
        
        OrganizationDTO organization2 = new OrganizationDTO();
        organization2.setOrganizationName("name");
        organization2.setOrganizationDescription("description");
        organization2.setOrganizationAddress("address");
        organization2 = organizationDao.addOrganization(organization);
        
        List<OrganizationDTO> organizations = organizationDao.getAllOrganizations();
        
        assertEquals(2, organizations.size());
        assertTrue(organizations.contains(organization));
        assertTrue(organizations.contains(organization2));
           
    }
    @Test
    
    public void testUpdateOrganization() {
        OrganizationDTO organization = new OrganizationDTO();
        organization.setOrganizationName("name");
        organization.setOrganizationDescription("description");
        organization.setOrganizationAddress("address");
        organization = organizationDao.addOrganization(organization);
        
        OrganizationDTO fromDao = organizationDao.getOrganizationByID(organization.getId());
        
        assertEquals(organization, fromDao);
        
        organization.setOrganizationName("New Name");
        organizationDao.updateOrganization(organization);
        
        assertNotEquals(organization, fromDao);
        
        fromDao = organizationDao.getOrganizationByID(organization.getId());
        
        assertEquals(organization, fromDao);
        
    }
    @Test
    
    public void testDeleteOrganizationById() {
       OrganizationDTO organization = new OrganizationDTO();
        organization.setOrganizationName("name");
        organization.setOrganizationDescription("description");
        organization.setOrganizationAddress("address");
        organization = organizationDao.addOrganization(organization);
        List<OrganizationDTO> organizations = new ArrayList<>();
        organizations.add(organization);
        
       HeroDTO hero = new HeroDTO();
       hero.setHeroName("Name");
       hero.setHeroDescription("Description");
       hero.setHeroSuperPower("Power");
       hero.setOrganizationList(organizations);
       hero.setSightingsList(new ArrayList<>());
       hero = superHeroDao.addHero(hero);
       
       OrganizationDTO fromDao = organizationDao.getOrganizationByID(organization.getId());
       assertEquals(organization, fromDao);
       
       organizationDao.deleteOrganizationByID(organization.getId());
       fromDao = organizationDao.getOrganizationByID(organization.getId());
       assertNull(fromDao);
       
       
    
}
}