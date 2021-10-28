/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvdlibrary.Dao;

import DvdLibraryDto.DvdDto;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public interface DvdLibraryDao {

    DvdDto addDvd(String title, DvdDto dvd) throws DvdlibraryDaoException;

    List<DvdDto> getAllDvds() throws DvdlibraryDaoException;

    DvdDto getDvd(String title) throws DvdlibraryDaoException;

    DvdDto removeDvd(String title) throws DvdlibraryDaoException;

    DvdDto editTitle(String title, DvdDto editTitle) throws DvdlibraryDaoException;

}
