/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Service;

import VendingMachine.dao.VendingMachineDao;
import VendingMachine.dao.VendingMachineExceptions;
import VendingMachine.dto.Change;
import VendingMachine.dto.Items;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public class VendingMachineServiceLayer implements VendingService {

    VendingMachineDao dao;
    BigDecimal totalMoney = BigDecimal.ZERO;

    public VendingMachineServiceLayer(VendingMachineDao dao) {
        this.dao = dao;
    }

//    public Items getItem(String itemName) throws VendingMachineExceptions {
//        return dao.getItem(itemName);
//    }

     @Override
    public List<Items> getAllItems() throws VendingMachineExceptions {
        return dao.getAllItem();

    }

     @Override
    public Items vend(String itemName) throws VendingMachineExceptions, InsufficientFundsException, NoInventoryException, InvalidItemException {

        Items vendItems = dao.getItem(itemName);
        if (vendItems == null) {
            throw new InvalidItemException("Can't Find Item " + itemName);

        }

        checkCost(vendItems, totalMoney);

        checkInventory(vendItems);

        totalMoney = totalMoney.subtract(vendItems.getAmount());

        return dao.removeInventory(itemName);
    }

    
    private void checkInventory(Items itemName) throws NoInventoryException {
        if (itemName.getQuantity() <= 0) {
            throw new NoInventoryException("item is out of stock");
        }
    }


    private void checkCost(Items amount, BigDecimal money) throws InsufficientFundsException {
        if (amount.getAmount().compareTo(money) > 0) {
            throw new InsufficientFundsException("Not Enough Money");
        }
    }

     @Override
    public Change getChange() {
        //build change with totalMoney
        Change toReturn = new Change(totalMoney);
        totalMoney = BigDecimal.ZERO;
        return toReturn;
    }

     @Override
    public BigDecimal deposit(BigDecimal input) throws InsufficientFundsException {
//        input.compareTo(BigDecimal.ZERO);
        
        if (input.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientFundsException("Not Enough Money. Please Insert more Than 0 Dollars.");
        }
        totalMoney = totalMoney.add(input);
        return input;

        //make sure the money they enter is greater than zero if they do make sure to throw exception
        // add the amount money to totalmoney assign that to total money= total money.+input
    }
}
