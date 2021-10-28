/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDAO;

import com.app.SuperheroApplication.SuperheroDAO.LocationDaoImpl.LocationMapper;
import com.app.SuperheroApplication.SuperheroDTO.LocationDTO;
import com.app.SuperheroApplication.SuperheroDTO.SightingsDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SightingsDaoImpl implements SightingsDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public SightingsDTO addSighting(SightingsDTO sighting) {
        final String INSERT_SIGHTING = "INSERT INTO sighting(timeOfSighting, locationId) "
                + "VALUES(?,?)";
        jdbc.update(INSERT_SIGHTING,
                sighting.getTimeOfSighting(),
                sighting.getLocation().getId());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sighting.setId(newId);
        return sighting;
    }

    @Override
    public SightingsDTO getSightingByID(int id) {
        try {
            final String GET_SIGHTING_BY_ID = "SELECT * FROM sighting WHERE id = ?";
            SightingsDTO sighting = jdbc.queryForObject(GET_SIGHTING_BY_ID, new SightingMapper(), id);
            sighting.setLocation(getLocationForSighting(id));
            return sighting;

        } catch (DataAccessException ex) {
            return null;
        }
    }

    private LocationDTO getLocationForSighting(int id) {
        final String SELECT_LOCATION_FOR_SIGHTING = "SELECT l.* FROM location l "
                + "JOIN sighting s ON s.locationId = l.id WHERE s.id = ?";
        return jdbc.queryForObject(SELECT_LOCATION_FOR_SIGHTING, new LocationMapper(), id);
    }

    @Override
    public void updateSighting(SightingsDTO sighting) {
        final String UPDATE_SIGHTING = "UPDATE sighting SET timeOfSighting = ?, locationId = ? "
                + "WHERE id = ?";
        jdbc.update(UPDATE_SIGHTING,
                sighting.getTimeOfSighting(),
                sighting.getLocation().getId(),
                sighting.getId());
    }

    @Override
    public void deleteSightingByID(int id) {
        final String DELETE_HERO_SIGHTING = "DELETE FROM heroSighting WHERE sightingId = ?";
        jdbc.update(DELETE_HERO_SIGHTING, id);

        final String DELETE_SIGHTING = "DELETE FROM sighting WHERE id = ?";
        jdbc.update(DELETE_SIGHTING, id);
    }

    @Override
    public List<SightingsDTO> getAllSighting() {
        final String GET_ALL_SIGHTINGS = "SELECT * FROM sighting";
        List<SightingsDTO> sightings = jdbc.query(GET_ALL_SIGHTINGS, new SightingMapper());
        helperForGetAllSighting(sightings);
        return sightings;
    }

    private void helperForGetAllSighting(List<SightingsDTO> sightings) {
        for (SightingsDTO sighting : sightings) {
            sighting.setLocation(getLocationForSighting(sighting.getId()));

        }
    }

    @Override
    public List<SightingsDTO> gettAllSightingsByLocation(LocationDTO location) {
        final String GET_ALL_SIGHTING_BY_LOCATION = "SELECT * FROM sighting WHERE locationId = ?";

        List<SightingsDTO> sightings = jdbc.query(GET_ALL_SIGHTING_BY_LOCATION,
                new SightingMapper(), location.getId());
        helperForGetAllSighting(sightings);
        return sightings;

    }

    public static final class SightingMapper implements RowMapper<SightingsDTO> {

        @Override
        public SightingsDTO mapRow(ResultSet rs, int index) throws SQLException {
            SightingsDTO sighting = new SightingsDTO();
            sighting.setId(rs.getInt("id"));
            sighting.setTimeOfSighting(rs.getDate("timeOfSighting").toLocalDate());

            return sighting;
        }

    }
}
