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
import java.time.Month;
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
public class SightingsDaoImplTest {

    @Autowired
    LocationDao locationDao;

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    SightingsDao sightingDao;

    @Autowired
    HeroDao superHeroDao;

    public SightingsDaoImplTest() {
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
        for (LocationDTO location : locations) {
            locationDao.deleteLocationByID(location.getId());
        }

        List<OrganizationDTO> organizations = organizationDao.getAllOrganizations();
        for (OrganizationDTO organization : organizations) {
            organizationDao.deleteOrganizationByID(organization.getId());
        }

        List<SightingsDTO> sightings = sightingDao.getAllSighting();
        for (SightingsDTO sighting : sightings) {
            sightingDao.deleteSightingByID(sighting.getId());
        }

        List<HeroDTO> superHeros = superHeroDao.getAllHeroes();
        for (HeroDTO superHero : superHeros) {
            superHeroDao.getHeroByID(superHero.getId());
        }

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testAddAndGetSighting() {
        LocationDTO location = new LocationDTO();
        location.setLocationName("locationName");
        location.setLocationDescription("locationDescription");
        location.setLocationAddress("locationAddress");
        location.setLocationLongitude(new BigDecimal("32.0000"));
        location.setLocationLatitude(new BigDecimal("32.0000"));
        location = locationDao.addLocation(location);

        SightingsDTO sighting = new SightingsDTO();
        sighting.setTimeOfSighting(LocalDate.now());
        sighting.setLocation(location);
        sighting = sightingDao.addSighting(sighting);

        SightingsDTO fromDao = sightingDao.getSightingByID(sighting.getId());

        assertEquals(sighting, fromDao);
    }

    @Test
    public void testGetAllSighting() {

        LocationDTO location = new LocationDTO();
        location.setLocationName("locationName");
        location.setLocationDescription("locationDescription");
        location.setLocationAddress("locationAddress");
        location.setLocationLongitude(new BigDecimal("32.0000"));
        location.setLocationLatitude(new BigDecimal("32.0000"));
        location = locationDao.addLocation(location);

        SightingsDTO sighting = new SightingsDTO();
        sighting.setTimeOfSighting(LocalDate.now());
        sighting.setLocation(location);
        sighting = sightingDao.addSighting(sighting);

        SightingsDTO sighting2 = new SightingsDTO();
        sighting2.setTimeOfSighting(LocalDate.now());
        sighting2.setLocation(location);
        sighting2 = sightingDao.addSighting(sighting2);

        List<SightingsDTO> sightings = sightingDao.getAllSighting();

        assertEquals(2, sightings.size());
        assertTrue(sightings.contains(sighting));
        assertTrue(sightings.contains(sighting2));

    }

    @Test
    public void testUpdateSighting() {

        LocationDTO location = new LocationDTO();
        location.setLocationName("locationName");
        location.setLocationDescription("locationDescription");
        location.setLocationAddress("locationAddress");
        location.setLocationLongitude(new BigDecimal("32.0000"));
        location.setLocationLatitude(new BigDecimal("32.0000"));
        location = locationDao.addLocation(location);

        SightingsDTO sighting = new SightingsDTO();
        sighting.setTimeOfSighting(LocalDate.now());
        sighting.setLocation(location);
        sighting = sightingDao.addSighting(sighting);

        SightingsDTO fromDao = sightingDao.getSightingByID(sighting.getId());

        assertEquals(sighting, fromDao);

        sighting.setTimeOfSighting(LocalDate.of(2019, Month.MARCH, 20));
        sightingDao.updateSighting(sighting);

        assertNotEquals(sighting, fromDao);

        fromDao = sightingDao.getSightingByID(sighting.getId());

        assertEquals(sighting, fromDao);
    }

    @Test
    public void testDeleteSighting() {
                LocationDTO location = new LocationDTO();
        location.setLocationName("locationName");
        location.setLocationDescription("locationDescription");
        location.setLocationAddress("locationAddress");
        location.setLocationLongitude(new BigDecimal("32.0000"));
        location.setLocationLatitude(new BigDecimal("32.0000"));
        location = locationDao.addLocation(location);

        SightingsDTO sighting = new SightingsDTO();
        sighting.setTimeOfSighting(LocalDate.now());
        sighting.setLocation(location);
        sighting = sightingDao.addSighting(sighting);
        List<SightingsDTO> sightings = new ArrayList<>();
        sightings.add(sighting);

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

        SightingsDTO fromDao = sightingDao.getSightingByID(sighting.getId());
        assertEquals(sighting, fromDao);

        sightingDao.deleteSightingByID(sighting.getId());
        fromDao = sightingDao.getSightingByID(sighting.getId());
        assertNull(fromDao);

    }

}
