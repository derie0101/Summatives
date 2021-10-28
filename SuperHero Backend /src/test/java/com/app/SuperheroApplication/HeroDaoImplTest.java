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

/**
 *
 * @author 
 */

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class HeroDaoImplTest {

        @Autowired
        LocationDao locationDao;

        @Autowired
        OrganizationDao organizationDao;

        @Autowired
        SightingsDao sightingDao;

        @Autowired
        HeroDao superHeroDao;

        public HeroDaoImplTest() {
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
                superHeroDao.deleteHeroByID(superHero.getId());
            }

        }

        @After
        public void tearDown() {

        }

        @Test
        public void testAddAndGetSuperHero() {
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
            organization.setOrganizationName("organizationName");
            organization.setOrganizationDescription("organizationDescription");
            organization.setOrganizationAddress("organizationAddress");
            organization = organizationDao.addOrganization(organization);
            List<OrganizationDTO> organizations = new ArrayList<>();
            organizations.add(organization);

            HeroDTO hero = new HeroDTO();
            hero.setHeroName("Name");
            hero.setHeroDescription("Description");
            hero.setHeroSuperPower("Power");
            hero.setOrganizationList(new ArrayList());
            hero.setSightingsList(new ArrayList());
            hero.setSightingsList(sightings);
            hero.setOrganizationList(organizations);
            hero = superHeroDao.addHero(hero);

            HeroDTO fromDao = superHeroDao.getHeroByID(hero.getId());
            assertEquals(hero, fromDao);

        }

        @Test
        public void testGetAllSuperHero() {

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
            hero.setOrganizationList(new ArrayList());
            hero.setSightingsList(new ArrayList());
            hero.setSightingsList(sightings);
            hero.setOrganizationList(organizations);
            hero = superHeroDao.addHero(hero);

            HeroDTO hero2 = new HeroDTO();
            hero2.setHeroName("Name");
            hero2.setHeroDescription("Description");
            hero2.setHeroSuperPower("Power");
            hero2.setOrganizationList(new ArrayList());
            hero2.setSightingsList(new ArrayList());
            hero2.setSightingsList(sightings);
            hero2.setOrganizationList(organizations);
            hero2 = superHeroDao.addHero(hero);

            List<HeroDTO> heroes = superHeroDao.getAllHeroes();
            assertEquals(2, heroes.size());
            assertTrue(heroes.contains(hero));
            assertTrue(heroes.contains(hero2));

        }

        @Test
        public void testUpdateSuperHero() {

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
            hero.setOrganizationList(new ArrayList());
            hero.setSightingsList(new ArrayList());
            hero.setSightingsList(sightings);
            hero.setOrganizationList(organizations);
            hero = superHeroDao.addHero(hero);

            HeroDTO fromDao = superHeroDao.getHeroByID(hero.getId());
            assertEquals(hero, fromDao);

            hero.setHeroName("name");
            OrganizationDTO organization2 = new OrganizationDTO();
            organization2.setOrganizationName("organization name");
            organization2.setOrganizationDescription("organization description");
            organization2.setOrganizationAddress("adress");
            organization2 = organizationDao.addOrganization(organization2);
            organizations.add(organization2);
            hero.setOrganizationList(organizations);

            SightingsDTO sighting2 = new SightingsDTO();
            sighting2.setTimeOfSighting(LocalDate.now());
            sighting2.setLocation(location);
            sighting2 = sightingDao.addSighting(sighting2);
            sightings.add(sighting2);
            hero.setSightingsList(sightings);

            superHeroDao.updateHero(hero);

            assertNotEquals(hero, fromDao);

            fromDao = superHeroDao.getHeroByID(hero.getId());
            assertEquals(hero, fromDao);

        }

        @Test
        public void testDeleteSuperHero() {
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
            hero.setOrganizationList(new ArrayList());
            hero.setSightingsList(new ArrayList());
            hero.setSightingsList(sightings);
            hero.setOrganizationList(organizations);
            hero = superHeroDao.addHero(hero);

            HeroDTO fromDao = superHeroDao.getHeroByID(hero.getId());
            assertEquals(hero, fromDao);

            superHeroDao.deleteHeroByID(hero.getId());

            fromDao = superHeroDao.getHeroByID(hero.getId());
            assertNull(fromDao);

        }
    }
