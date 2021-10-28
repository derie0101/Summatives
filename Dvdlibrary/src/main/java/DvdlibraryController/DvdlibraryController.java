/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdlibraryController;

import DvdLibraryDto.DvdDto;
import Dvdlibrary.Dao.DvdLibraryDao;
import Dvdlibrary.Dao.DvdlibraryDaoException;
import Dvdlibrary.ui.DvdLibraryView;
import Dvdlibrary.ui.UserIO;
import Dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public class DvdlibraryController {

    DvdLibraryView view;
    private UserIO io = new UserIOConsoleImpl();
    DvdLibraryDao dao;

    public DvdlibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() throws DvdlibraryDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDvd();
                        break;
                    case 2:
                        createDvd();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        removeDvd();
                        break;
                    case 5:
                        EditDvd();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DvdlibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void createDvd() throws DvdlibraryDaoException {
        view.displayCreateDvdBanner();
        DvdDto newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvd() throws DvdlibraryDaoException {
        view.displayDisplayAllBanner();
        List<DvdDto> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void removeDvd() throws DvdlibraryDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        dao.removeDvd(title);
        view.displayRemoveSuccessBanner();
    }

    private void viewDvd() throws DvdlibraryDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getDvdTitleChoice();
        DvdDto dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void EditDvd() throws DvdlibraryDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getDvdTitleChoice();

        DvdDto oldMovie = dao.getDvd(title);
        if (oldMovie != null) {
        DvdDto edidtedMovie = view.editMovie(oldMovie);
        
        
        dao.editTitle(title,edidtedMovie);
        view.displayEditSuccessful();
        }else {
            view.displayErrorMessage("Title does not exist");
        }
    }

}

