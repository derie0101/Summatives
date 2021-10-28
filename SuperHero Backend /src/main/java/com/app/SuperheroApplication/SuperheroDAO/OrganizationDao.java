/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.SuperheroApplication.SuperheroDAO;

import com.app.SuperheroApplication.SuperheroDTO.HeroDTO;
import com.app.SuperheroApplication.SuperheroDTO.OrganizationDTO;
import java.util.List;

/**
 *
 * @author 
 */
public interface OrganizationDao {

    OrganizationDTO addOrganization(OrganizationDTO organization);

    OrganizationDTO getOrganizationByID(int id);

    void updateOrganization(OrganizationDTO organization);

    void deleteOrganizationByID(int id);

    List<OrganizationDTO> getAllOrganizations();

}
