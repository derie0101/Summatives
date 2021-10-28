/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Controller;

import VendingMachine.Service.InsufficientFundsException;
import VendingMachine.Service.InvalidItemException;
import VendingMachine.Service.NoInventoryException;
import VendingMachine.Service.VendingMachineServiceLayer;
import VendingMachine.dao.VendingMachineExceptions;
import VendingMachine.dto.Change;
import VendingMachine.dto.Items;
import VendingMachine.ul.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUEEN
 */
public class VendingMachineController {

    VendingMachineServiceLayer service;
    VendingMachineView view;
//    BigDecimal total;
//    String Choice;
// BigDecimal money = new BigDecimal(0);
//    BigDecimal input;

    public VendingMachineController(VendingMachineServiceLayer myService, VendingMachineView myView) {
        this.service = myService;
        this.view = myView;
    }

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            try {
                listItems();
                menuSelection = view.printMenuAndGetSelection();

                switch (menuSelection) {
                    case 1:
                        enterMoney();
                        break;
                    case 2:
                        vendItem();
                        break;
                    case 3:
                        returnChange();
                        break;

                    case 4:
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommandBanner();
                }
            } catch (VendingMachineExceptions | InsufficientFundsException | NoInventoryException | InvalidItemException ex) {
                view.displayErrorMessage(ex.getMessage());
            }
        }
        exitMessage();
    }

    private void listItems() throws VendingMachineExceptions {
        view.displayDisplayAllBanner();
        List itemList = service.getAllItems();

    }

    private void enterMoney() throws InsufficientFundsException {

        BigDecimal input = view.insertCash();
        BigDecimal total = service.deposit(input);
        view.displayTotalmoney(total);

    }

    private void vendItem() throws VendingMachineExceptions, InsufficientFundsException, NoInventoryException, InvalidItemException {

        view.displayitemsList(service.getAllItems());
        String Choice = view.getItemChoice();

        Items toRemove = service.vend(Choice);

    }

    private void returnChange() throws VendingMachineExceptions {
        Change toprint = service.getChange();
        view.displayChange(toprint);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();

    }

    private void exitMessage() {
        view.displayExitBanner();

    }

}
