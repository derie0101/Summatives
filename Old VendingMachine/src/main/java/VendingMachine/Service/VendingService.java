/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Service;

import VendingMachine.dao.VendingMachineExceptions;
import VendingMachine.dto.Change;
import VendingMachine.dto.Items;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public interface VendingService {
    
    //public Items getItem(String itemName) throws VendingMachineExceptions;

    public List<Items> getAllItems() throws VendingMachineExceptions;

    public Items vend(String itemName) throws VendingMachineExceptions, InsufficientFundsException, NoInventoryException, InvalidItemException;

    //public void checkInventory(Items itemName) throws NoInventoryException;

    //public void checkCost(Items amount, BigDecimal money) throws InsufficientFundsException;

    public Change getChange();

    public BigDecimal deposit(BigDecimal input) throws InsufficientFundsException;
}
