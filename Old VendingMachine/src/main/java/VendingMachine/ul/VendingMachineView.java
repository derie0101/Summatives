/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.ul;

import VendingMachine.dto.Change;
import VendingMachine.dto.Items;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public class VendingMachineView {
    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu\n");
        io.print(" 1. Enter Money\n");
        io.print(" 2. Select an Item\n");
        io.print(" 3. Return Money\n");
        io.print(" 4. Exit\n");

        return io.readInt("Please select from the above choices.", 1, 4);

    }

    public BigDecimal insertCash() {

        String input = io.readString("insert your cash");

        BigDecimal money = new BigDecimal(input);

        return money;
    }

    public void displayChange(int dollars, int quarters, int dimes, int nickels, int pennies) {
        io.print("change is:: " + dollars + "::dollars::"
                + quarters + "::quartes::" + dimes
                + "::dimes::" + nickels + "::nickels::"
                + pennies + "::pennies::");
//displays the change
    } 

    public void displayErrorMessage() {
        io.print("=== ERROR ===\n");

    }

    public void displayExitBanner() {
        io.print("Good Bye!!!\n");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!\n");
    }

    public void displayitemsList(List<Items> itemList) {
        for (Items currentItem : itemList) {
            io.print(currentItem.getName() +  ":" + currentItem.getAmount()
                    + ": "
                    + currentItem.getQuantity() + "\n");

        }

    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Items ===\n");
    }

    public void displaysufficentFunds() {
        io.print("You have the sufficent amount of funds===\n");
    }

    public void displayNotInStockBanner() {
        io.print("Item Is Not Avaiable===\n");
    }

    public void displayInsufficentFunds() {
        io.print("Insufficent Funds===\n ");
    }

    public void displayInStock() {
        io.print("Item is Avaiable===\n");
    }

    public void displayErrorMessage(String errorMsg) {
         io.print(errorMsg);
    }

    public void invalidSelection(String Choice) {
         io.print("Please Select a Valid Item! You Selected" + Choice + "");
    }

    public String getItemChoice() {
        String ItemChoice = io.readString("Please pick a Item do you want from the vending Machine");
        return ItemChoice;
    }

//    public String vendItems() {
//        String vendItems = io.readString("Please pick an item");
//        return vendItems;
//        
//    }

    public void displayTotalmoney(BigDecimal total) {
        io.print("Total Money Inserted " + total);
    }

    public void displayChange(Change toprint) {
        displayChange(
                toprint.getDollars(),
                toprint.getQuaters(),
                toprint.getDimes(),
                toprint.getNickels(),
                toprint.getPennies()
                
        );
    }

}
 

