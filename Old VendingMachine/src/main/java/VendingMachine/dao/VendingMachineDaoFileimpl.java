1/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.dao;

import VendingMachine.dto.Items;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author QUEEN
 */
public class VendingMachineDaoFileimpl implements VendingMachineDao {
    
     public String vending_FILE;
    public static final String DELIMITER = "::";
    //Create a constructor that path

    public VendingMachineDaoFileimpl(String file) {
        this.vending_FILE = file;
    }
   
    
    private Map<String, Items> items = new HashMap<>();
    
    @Override
    public Items getItem(String name) throws VendingMachineExceptions {
        loadCollection();
        return items.get(name);
    }

    @Override
    public List<Items> getAllItem() throws VendingMachineExceptions {
        loadCollection();
        return new ArrayList(items.values());
    }

    @Override
    public Items removeInventory(String name) throws VendingMachineExceptions {
        loadCollection();
        Items toReduce = items.get(name);
  
        //Items removedItem = items.remove(name);
        toReduce.setQuantity(toReduce.getQuantity()- 1);
        items.put(name, toReduce);
        writeCollection();

        return toReduce;
    }

    private Items unmarshallItem(String ItemAsText) {

        String[] itemTokens = ItemAsText.split(DELIMITER);

        String name = itemTokens[0];

        Items itemFromFile = new Items(name);

        itemFromFile.setQuantity(Integer.parseInt(itemTokens[2]));

        itemFromFile.setAmount(new BigDecimal(itemTokens[1]));
        
        itemFromFile.setName(name);

        return itemFromFile;
    }

    private void loadCollection() throws VendingMachineExceptions {
        Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(vending_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineExceptions(
                    "-_- Could not load Item data into memory.", e);
        }

        String currentLine;

        Items currentItem;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentItem = unmarshallItem(currentLine);

            items.put(currentItem.getName(), currentItem);
        }

        scanner.close();
    }

    private String marshallItem(Items aItem) {

        String ItemAsText = aItem.getName() + DELIMITER;

        //ItemAsText += aItem.getAmount() + DELIMITER;
        ItemAsText = ItemAsText + aItem.getAmount() +DELIMITER;
        
        //ItemAsText += aItem.getQuantity() + DELIMITER;
        ItemAsText = ItemAsText + aItem.getQuantity();

 
                
                
                
        return ItemAsText;
    }

    private void writeCollection() throws VendingMachineExceptions {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(vending_FILE));
        } catch (IOException e) {
            throw new VendingMachineExceptions(
                    "Could not save Item data.", e);
        }

        String ItemAsText;
        List<Items> ItemList = this.getAllItem();
        for (Items currentItem : ItemList) {

            ItemAsText = marshallItem(currentItem);

            out.println(ItemAsText);

            out.flush();
        }

        out.close();

    }
}
