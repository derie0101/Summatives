/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.FlooringDaoException;
import Service.FlooringService;
import UI.FlooringView;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public class Controller {
    
    FlooringView view;

    public Controller(FlooringView myview) {

        this.view = view;
    }

   

     public void run() throws FlooringDaoException {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    removeOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    listOrders();
                    break;
                case 5:
                    viewOrder();
                    break;

                case 6:
                    keepGoing = false;
                    break;

                default:
                    unknownCommand();

            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addOrder()
            throws FlooringDaoException  {


    }

    private void removeOrder() throws FlooringDaoException {

     
      
    }

    private void editOrder() throws FlooringDaoException {
    
        
    }

    private void listOrders() throws FlooringDaoException {
        
        

    }

    private void viewOrder() throws FlooringDaoException {


    }

    private void exitMessage() {
       
    }

    private void unknownCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
