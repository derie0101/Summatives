/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.dao;

import VendingMachine.dto.Items;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public interface VendingMachineDao {
    
    
    public Items getItem(String name) throws VendingMachineExceptions;

    
    public List<Items> getAllItem() throws VendingMachineExceptions;
    
    
    public Items removeInventory(String name) throws VendingMachineExceptions;
    
}
