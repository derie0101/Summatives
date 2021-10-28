

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDAO;

import com.app.SuperheroApplication.SuperheroDAO.HeroDao;
import com.app.SuperheroApplication.SuperheroDAO.OrganizationDaoImpl.OrganizationMapper;
import com.app.SuperheroApplication.SuperheroDAO.SightingsDaoImpl.SightingMapper;
import com.app.SuperheroApplication.SuperheroDTO.HeroDTO;
import com.app.SuperheroApplication.SuperheroDTO.LocationDTO;
import com.app.SuperheroApplication.SuperheroDTO.OrganizationDTO;
import com.app.SuperheroApplication.SuperheroDTO.SightingsDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HeroDaoImpl implements HeroDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public HeroDTO addHero(HeroDTO hero) {
final String INSERT_HERO = "INSERT INTO hero(heroName, heroDescription, heroSuperPower) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_HERO,
                hero.getHeroName(),
                hero.getHeroDescription(),
                hero.getHeroSuperPower());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        hero.setId(newId);
        insertSuperHeroSighting(hero);
        insertSuperHeroOrganization(hero);
        return hero;
    }
    private void insertSuperHeroSighting(HeroDTO superHero) {
        final String INSERT_SUPERHERO_SIGHTING = "INSERT INTO "
                + "HeroSighting(heroId, sightingId) VALUES(?,?)";
        for(SightingsDTO sighting : superHero.getSightingsList()) {
            jdbc.update(INSERT_SUPERHERO_SIGHTING,
                    superHero.getId(),
                    sighting.getId());
    }
    }
        
    private void insertSuperHeroOrganization(HeroDTO superHero) {
         final String INSERT_SUPERHERO_ORGANIZATION = "INSERT INTO "
                 + "HeroOrganization(heroId, organizationId) VALUES(?,?)";
         for(OrganizationDTO organization : superHero.getOrganizationList()) {
             jdbc.update(INSERT_SUPERHERO_ORGANIZATION,
                     superHero.getId(),
                     organization.getId());
         }    
    }

    @Override
    public HeroDTO getHeroByID(int id) {
         try {
            final String GET_HERO_BY_ID = "SELECT * FROM hero WHERE id = ?";
            HeroDTO hero = jdbc.queryForObject(GET_HERO_BY_ID, new SuperHeroMapper(), id);
            hero.setSightingsList(getSightingBySuperHero(id));
            hero.setOrganizationList(getOrganizationBySuperHero(id));
            return hero;
        } catch (DataAccessException ex) {
            return null;
        }
    }
    
    private List<SightingsDTO> getSightingBySuperHero(int id) {
        final String GET_SIGHTING_BY_SUPERHERO = "SELECT s.* FROM sighting s "
                + "JOIN heroSighting hs on s.id = hs.sightingId WHERE hs.heroId = ?";
        List<SightingsDTO> sightings = jdbc.query(GET_SIGHTING_BY_SUPERHERO, new SightingMapper(), id);
        helperForGetSighting(sightings);
        return sightings;
              
    }
    private List<OrganizationDTO> getOrganizationBySuperHero(int id) {
        final String GET_ORGANIZATION_BY_SUPERHERO = "SELECT o.* FROM organization o "
                + "JOIN heroOrganization ho on o.Id = ho.organizationId WHERE ho.heroId = ?";
        return jdbc.query(GET_ORGANIZATION_BY_SUPERHERO, new OrganizationMapper(), id);
    
    }
     private LocationDTO getLocationForSighting(int id) {
        final String GET_LOCATION_FOR_SIGHTING = "SELECT l.* FROM location l "
                + "JOIN sighting s ON s.locationId = l.id WHERE s.id = ?";
        return jdbc.queryForObject(GET_LOCATION_FOR_SIGHTING, new LocationDaoImpl.LocationMapper(), id);
    }
     
     private void helperForGetSighting(List<SightingsDTO> sightings) {
        for (SightingsDTO sighting : sightings) {
            sighting.setLocation(getLocationForSighting(sighting.getId()));
            
        }
    }

    @Override
    public void updateHero(HeroDTO hero) {
        final String UPDATE_SUPERHERO = "UPDATE hero SET heroName = ?, heroDescription = ?, heroSuperPower = ? "
                + "WHERE id = ?";
        jdbc.update(UPDATE_SUPERHERO,
                hero.getHeroName(),
                hero.getHeroDescription(),
                hero.getHeroSuperPower(),
                hero.getId());
        
        final String DELETE_HERO_ORGANIZATION ="DELETE FROM heroOrganization WHERE heroId = ? ";
        jdbc.update(DELETE_HERO_ORGANIZATION, hero.getId());
        insertSuperHeroOrganization(hero);
        
        final String DELETE_HERO_SIGHTING ="DELETE FROM heroSighting WHERE heroId = ? ";
        jdbc.update(DELETE_HERO_SIGHTING, hero.getId());
        insertSuperHeroSighting(hero);
    }

    @Override
    @Transactional
    public void deleteHeroByID(int id) {
        final String DELETE_HERO_ORGANIZATION = "DELETE FROM heroOrganization WHERE heroId = ?";
        jdbc.update(DELETE_HERO_ORGANIZATION, id);
        
        final String DELETE_HERO_SIGHTING = "DELETE FROM heroSighting WHERE heroId = ?";
        jdbc.update(DELETE_HERO_SIGHTING, id);

        final String DELETE_HERO = "DELETE FROM hero WHERE id = ?";
        jdbc.update(DELETE_HERO, id);
    }

    @Override
    public List<HeroDTO> getAllHeroes() {
        final String GET_ALL_HEROES = "SELECT * FROM hero";
        List<HeroDTO> hero = jdbc.query(GET_ALL_HEROES, new SuperHeroMapper());
        getAllOrgNSightings(hero);
        return hero;
    }
    
    private void getAllOrgNSightings(List<HeroDTO> heroes) {
        for (HeroDTO hero : heroes) {
            hero.setSightingsList(getSightingBySuperHero(hero.getId()));
            hero.setOrganizationList(getOrganizationBySuperHero(hero.getId()));
              
        }
    }

    @Override
    public List<HeroDTO> heroesSightedAtALocation(LocationDTO location) {
         final String GET_ALL_SUPERHERO_BY_LOCATION = "SELECT h. * FROM hero h"
                + "JOIN heroSighting hs on h.id = hs.heroId"
                +"JOIN sighting s on hs.sightingId = s.sightingId WHERE s.locationId = ? ";
        
        List<HeroDTO> heroes = jdbc.query(GET_ALL_SUPERHERO_BY_LOCATION,
                new SuperHeroMapper(), location.getId());
        getAllOrgNSightings(heroes);
        return heroes;
    }
    
    
    public static final class SuperHeroMapper implements RowMapper<HeroDTO> {

        @Override
        public HeroDTO mapRow(ResultSet rs, int index) throws SQLException {
            HeroDTO hero = new HeroDTO();
            hero.setId(rs.getInt("id"));
            hero.setHeroName(rs.getString("heroName"));
            hero.setHeroDescription(rs.getString("heroDescription"));
            hero.setHeroSuperPower(rs.getString("heroSuperPower"));
            
            return hero;
        }

    }
    
}