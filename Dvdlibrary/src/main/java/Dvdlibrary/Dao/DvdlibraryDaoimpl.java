/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvdlibrary.Dao;

import DvdLibraryDto.DvdDto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.loadLibrary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author QUEEN
 */
public class DvdlibraryDaoimpl implements DvdLibraryDao {

    public static final String Dvd_FILE = "library.txt";
    public static final String DELIMITER = "::";

    private Map<String, DvdDto> dvds = new HashMap<>();

    /**
     *
     * @return @throws DvdLibraryDaoException
     */
    public List<DvdDto> getAllDvds() throws DvdlibraryDaoException {

        loadlibrary();
        return new ArrayList(dvds.values());
    }

    public DvdDto addDvd(String title, DvdDto dvd) throws DvdlibraryDaoException {

        loadlibrary();
        DvdDto newDvd = dvds.put(title, dvd);
        writeLibrary();
        return newDvd;
    }

    public DvdDto getDvd(String title) throws DvdlibraryDaoException {

        loadlibrary();
        return dvds.get(title);
    }

    public DvdDto removeDvd(String title) throws DvdlibraryDaoException {

        loadlibrary();

        DvdDto removedDvd = dvds.remove(title);

        writeLibrary();

        return removedDvd;
    }

    private DvdDto unmarshallDvd(String dvdAsText) {

        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];

        DvdDto dvdFromFile = new DvdDto(title);

        dvdFromFile.setReleaseDate(Integer.parseInt(dvdTokens[1]));

        dvdFromFile.setRating(dvdTokens[2]);

        dvdFromFile.setDirectorsName(dvdTokens[3]);

        dvdFromFile.setStudio(dvdTokens[4]);

        dvdFromFile.setNote(dvdTokens[5]);

        return dvdFromFile;
    }

    /**
     *
     * @throws DvdLibraryDaoException
     */
    private void loadlibrary() throws DvdlibraryDaoException {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(Dvd_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdlibraryDaoException(
                    "-_- Could not load DVD data into memory.", e);
        }

        String currentLine;

        DvdDto currentDvd;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentDvd = unmarshallDvd(currentLine);

            dvds.put(currentDvd.getTitle(), currentDvd);
        }

        scanner.close();
    }

    /**
     *
     * @param aDvd
     * @return
     */
    private String marshallDvd(DvdDto aDvd) {

        String dvdAsText = aDvd.getTitle() + DELIMITER;

        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        dvdAsText += aDvd.getRating() + DELIMITER;

        dvdAsText += aDvd.getDirectorsName() + DELIMITER;

        dvdAsText += aDvd.getStudio() + DELIMITER;

        dvdAsText += aDvd.getNote();

        return dvdAsText;
    }

    /**
     *
     * @throws DvdLibraryDaoException
     */
    private void writeLibrary() throws DvdlibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(Dvd_FILE));
        } catch (IOException e) {
            throw new DvdlibraryDaoException(
                    "Could not save DVD data.", e);
        }

        String dvdAsText;
        List<DvdDto> dvdList = this.getAllDvds();
        for (DvdDto currentDvd : dvdList) {

            dvdAsText = marshallDvd(currentDvd);

            out.println(dvdAsText);

            out.flush();
        }

        out.close();
    }

    @Override
    public DvdDto editTitle(String title, DvdDto editTitle) throws DvdlibraryDaoException {
        this.loadlibrary();
        //Remove old data from the map using the title 
        //Add new date with the old title as the key
        DvdDto edit = dvds.put(title, editTitle);
        this.writeLibrary();
        
        return edit;
        
       
    }
}
