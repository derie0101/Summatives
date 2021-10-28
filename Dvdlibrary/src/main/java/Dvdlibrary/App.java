/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvdlibrary;

import Dvdlibrary.Dao.DvdLibraryDao;
import Dvdlibrary.Dao.DvdlibraryDaoException;
import Dvdlibrary.ui.UserIO;
import Dvdlibrary.ui.UserIOConsoleImpl;
import DvdlibraryController.DvdlibraryController;
import Dvdlibrary.ui.DvdLibraryView;
import Dvdlibrary.Dao.DvdLibraryDao;
import Dvdlibrary.Dao.DvdlibraryDaoimpl;

/**
 *
 * @author QUEEN
 */
public class App {

    public static void main(String[] args) throws DvdlibraryDaoException {
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdlibraryDaoimpl();
        DvdlibraryController myController = new DvdlibraryController( myDao, myView);
        myController.run();
       

    }
}
