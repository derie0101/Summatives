package Dvdlibrary.ui;

import DvdLibraryDto.DvdDto;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author QUEEN
 */
public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu\n");
        io.print(" 1. List DVD\n");
        io.print(" 2. Create A New DVD\n");
        io.print(" 3. View A Dvd\n");
        io.print(" 4. Remove A DVD\n");
        io.print(" 5. Edit DVD\n");
        io.print(" 6. Exit\n");

        return io.readInt("Please select from the above choices.", 1, 6);

    }

    public DvdDto getNewDvdInfo() {

        String title = io.readString("Please enter the title");
        int releaseDate = io.readInt("Please enter the release date");
        String rating = io.readString("Please enter the rating");
        String directorsName = io.readString("Please enter the director's name");
        String studio = io.readString("Please enter the studio");
        String note = io.readString("Please enter your notes or comments");
        DvdDto currentDvd = new DvdDto(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setRating(rating);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setStudio(studio);
        currentDvd.setNote(note);
        return currentDvd;
    }

    public void displayDvdList(List<DvdDto> dvdList) {
        for (DvdDto currentDvd : dvdList) {
            io.print(currentDvd.getTitle()
                    + ": " + currentDvd.getReleaseDate() + ": "
                    + currentDvd.getRating() + ": " + currentDvd.getDirectorsName() + ": "
                    + currentDvd.getStudio() + ": " + currentDvd.getNote());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDvd(DvdDto dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getReleaseDate()+"");
            io.print(dvd.getRating());
            io.print(dvd.getStudio());
            io.print(dvd.getNote());
            io.print("");
        } else {
            io.print("No such Dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===\n");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display Dvd ===\n");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter the Dvd title.");
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===\n");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD Successfully Created.  Please Hit Enter To Continue");
    }

    public void displayErrorMessage(String message) {
        io.print("ERROR: "+message + "\n");
    }

    public void displayRemoveDvdBanner() {
         io.print("===Remove DVD===");
    }

    public void displayRemoveSuccessBanner() {
       io.print("DVD Successfully removed. Please enter continue.");
    }

    public DvdDto editMovie(DvdDto oldMovie) {
        String title = io.readString("Please enter the title ("+oldMovie.getTitle()+"):");
        int releaseDate = io.readInt ("Please enter the release date ("+oldMovie.getReleaseDate()+"):");
        String rating = io.readString("Please enter the rating ("+oldMovie.getRating()+"):)");
        String directorsName = io.readString("Please enter the director's name("+oldMovie.getDirectorsName()+"):");
        String studio = io.readString("Please enter the studio("+oldMovie.getStudio()+"):)");
        String note = io.readString("Please enter your notes or comments("+oldMovie.getNote()+"):)");
        DvdDto currentDvd = new DvdDto(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setRating(rating);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setStudio(studio);
        currentDvd.setNote(note);
        return currentDvd;
        
    }

    public void displayUnknownCommandBanner() {
         io.print("ERROR Invalid Choice\n");
    }

    public void displayExitBanner() {
        io.print("GOOD BYE");
        
    }

    public void displayEditSuccessful() {
        io.print("Edit Successful");
    }
}
