/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDAO;

import com.app.SuperheroApplication.SuperheroDTO.HeroDTO;
import com.app.SuperheroApplication.SuperheroDTO.OrganizationDTO;
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
public class OrganizationDaoImpl implements OrganizationDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public OrganizationDTO addOrganization(OrganizationDTO organization) {
        final String INSERT_ORGANIZATION = "INSERT INTO organization(organizationname, organizationDescription, organizationAddress) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationAddress());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        organization.setId(newId);
        return organization;
    }

    @Override
    public OrganizationDTO getOrganizationByID(int id) {
          try {
            final String GET_ORGANIZATION_BY_ID = "SELECT * FROM organization WHERE id = ?";
            return jdbc.queryForObject(GET_ORGANIZATION_BY_ID, new OrganizationMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }


    @Override
   public void updateOrganization(OrganizationDTO organization) {
        final String UPDATE_ORGANIZATION = "UPDATE organization SET organizationName = ?, organizationDescription = ?, organizationAddress = ? "
                + "WHERE id = ?";
        jdbc.update(UPDATE_ORGANIZATION,
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationAddress(),
                organization.getId());
    }
   
    @Override
    @Transactional
    public void deleteOrganizationByID(int id) {
        final String DELETE_HERO_ORGANIZATION = "DELETE FROM heroOrganization WHERE organizationId = ?";
        jdbc.update(DELETE_HERO_ORGANIZATION, id);

        final String DELETE_ORGANIZATION = "DELETE FROM organization WHERE id = ?";
        jdbc.update(DELETE_ORGANIZATION, id);
    }

    @Override
    public List<OrganizationDTO> getAllOrganizations() {
        final String GET_ALL_ORGANIZATIONS = "SELECT * FROM organization";
        return jdbc.query(GET_ALL_ORGANIZATIONS, new OrganizationMapper());
    }
    
     public static final class OrganizationMapper implements RowMapper<OrganizationDTO> {

        @Override
        public OrganizationDTO mapRow(ResultSet rs, int index) throws SQLException {
            OrganizationDTO org = new OrganizationDTO();
            org.setId(rs.getInt("id"));
            org.setOrganizationName(rs.getString("organizationName"));
            org.setOrganizationDescription(rs.getString("organizationDescription"));
            org.setOrganizationAddress(rs.getString("organizationAddress"));
            
            return org;

   
}
     }
}