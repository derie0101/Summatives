/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.dao;

import VendingMachine.dto.Items;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public class Inmemorytest implements VendingMachineDao {

    List<Items> allItems = new ArrayList();
//

    public Inmemorytest() {
        Items item = new Items("Water", new BigDecimal("1.50"), 5);
//        item.setName("Water");
//        item.setAmount(new BigDecimal("1.50"));
//        item.setQuantity(5);
        allItems.add(item);

        Items item2 = new Items("Coco-cola", new BigDecimal("1.00"), 0);
//        item2.setName("Coco-cola");
//        item.setAmount(new BigDecimal("1.00"));
//        item.setQuantity(0);

        allItems.add(item2);
     

    }

    @Override
    public Items getItem(String name) throws VendingMachineExceptions {
        Items toReturn = null;

        //int index = Integer.MIN_VALUE;
        for (int i = 0; i < allItems.size(); i++) {
            Items validate = allItems.get(i);

            if (validate.getName().equals(name)) {
                //index = i;
                toReturn = validate;
                break;
            }
        }

//        if (index >= 0 && index < allItems.size()) {
//            //REMOVE at the index
//            
//            //allItems.set(index, item);
//        }
        return toReturn;
    }

    @Override
    public List<Items> getAllItem() throws VendingMachineExceptions {
        return allItems;
    }

    @Override
    public Items removeInventory(String name) throws VendingMachineExceptions {
        int index = Integer.MIN_VALUE;
        for (int i = 0; i < allItems.size(); i++) {
            Items validate = allItems.get(i);

            if (validate.getName().equals(name)) {
                index = i;
                break;
            }
        }
        if( index < 0 ){
            throw new VendingMachineExceptions("Wrong Item Name");
        }
        Items toEdit  = allItems.get(index);
        toEdit.setQuantity(toEdit.getQuantity()-1);
        
        return toEdit;
    }

}
