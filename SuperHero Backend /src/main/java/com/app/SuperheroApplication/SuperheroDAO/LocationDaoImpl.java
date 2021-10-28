/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDAO;

import com.app.SuperheroApplication.SuperheroDTO.HeroDTO;
import com.app.SuperheroApplication.SuperheroDTO.LocationDTO;
import java.math.BigDecimal;
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
public class LocationDaoImpl implements LocationDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public LocationDTO addLocation(LocationDTO location) {
        final String INSERT_LOCATION = "INSERT INTO location(locationName, locationDescription, locationAddress, locationLatitude, locationLongitude) "
                + "VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationAddress(),
                location.getLocationLatitude(),
                location.getLocationLongitude());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        location.setId(newId);
        return location;
    }

    @Override
    public LocationDTO getLocationByID(int locationID) {
        try {
            final String GET_LOCATION_BY_ID = "SELECT * FROM location WHERE id = ?";
            return jdbc.queryForObject(GET_LOCATION_BY_ID, new LocationMapper(), locationID);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
   public LocationDTO updateLocation(LocationDTO location) {
        final String UPDATE_LOCATION = "UPDATE location SET locationName = ?, locationDescription = ?, locationAddress = ?, locationLatitude = ?,"
                + "locationLongitude = ? WHERE id = ?";
        jdbc.update(UPDATE_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationAddress(),
                location.getLocationLatitude(),
                location.getLocationLongitude(),
                location.getId());

        return location;
    }

    @Override
    @Transactional
    public void deleteLocationByID(int locationID) {
        final String DELETE_HERO_SIGHTING = "DELETE hs.* FROM heroSighting hs "
                + "JOIN sighting s ON hs.sightingId = s.Id WHERE s.locationId = ?";
        jdbc.update(DELETE_HERO_SIGHTING, locationID);

        final String DELETE_SIGHTING = "DELETE FROM sighting WHERE locationId = ?";
        jdbc.update(DELETE_SIGHTING, locationID);

        final String DELETE_LOCATION = "DELETE FROM location WHERE id = ?";
        jdbc.update(DELETE_LOCATION, locationID);
    }
    

    @Override
    public List<LocationDTO> getAllLocations() {
        final String GET_ALL_LOCATIONS = "SELECT * FROM location";
        return jdbc.query(GET_ALL_LOCATIONS, new LocationMapper());
    }

    @Override
    public List<LocationDTO> allLocationsVisitedByAHero(HeroDTO hero) {
        final String SELECT_ALL_LOCATION_SUPERHERO = "SELECT l. * FROM location l "
                + "JOIN sighting s on l.id = s.locationId" + "JOIN heroSighting hs on s.sightingId = hs.sightingId WHERE hs.heroId = ?";
        return jdbc.query(SELECT_ALL_LOCATION_SUPERHERO, new LocationMapper());
    }

    public static final class LocationMapper implements RowMapper<LocationDTO> {

        @Override
        public LocationDTO mapRow(ResultSet rs, int index) throws SQLException {
            LocationDTO location = new LocationDTO();
            location.setId(rs.getInt("id"));
            location.setLocationName(rs.getString("locationName"));
            location.setLocationDescription(rs.getString("locationDescription"));
            location.setLocationAddress(rs.getString("locationAddress"));
            location.setLocationLatitude(rs.getBigDecimal("locationLatitude"));
            location.setLocationLongitude(rs.getBigDecimal("locationLongitude"));

            return location;

        }
    }
}
