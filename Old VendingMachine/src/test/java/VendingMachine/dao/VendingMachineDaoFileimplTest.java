/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.dao;

import VendingMachine.Service.InvalidItemException;
import VendingMachine.dto.Items;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author QUEEN
 */
public class VendingMachineDaoFileimplTest {

    VendingMachineDao dao = new VendingMachineDaoFileimpl("testdata.txt");
//    public VendingMachineDaoFileimplTest() {
//    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws IOException {
        Path seedPath = Path.of("seedfile.txt");
        Path testPath = Path.of("testdata.txt");
        File seedFile = seedPath.toFile();
        File testFile = testPath.toFile();
       if (testFile.exists()) {
           testFile.delete();
       } 
       Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
        
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getItem method, of class VendingMachineDaoFileimpl.
     */
    @Test
    public void testGetItem() {
        try {
            Items item = dao.getItem("Water");

            assertEquals(new BigDecimal("1.50"), item.getAmount());

            assertEquals(4, item.getQuantity());
        } catch (VendingMachineExceptions ex) {
            fail();
        }
    }

    @Test
    public void testgetinvalidItemname() {
        //if it SHOULD throw an exception, do this
//        try {
//            Items item = dao.getItem("Cheetos");
//            fail();
//        } catch (VendingMachineExceptions ex) {
//
//        }

        //if it SHOULDNT throw an exception do this
        try {
            Items item = dao.getItem("Cheetos");
            if( item != null ){
                fail();
            }
        } catch (VendingMachineExceptions ex) {
            fail();
        }
    }

    /**
     * Test of getAllItem method, of class VendingMachineDaoFileimpl.
     */
    @Test
    public void testGetAllItem() {
        try {
            List<Items> items = dao.getAllItem();
            
            assertEquals(5 ,items.size());
            

            
//            Items item = new Items("Water", new BigDecimal("1.50"), 5);
//            Items item2 = new Items("Mountain dew", new BigDecimal("1.50"), 5);
//            Items item3 = new Items("Sprite", new BigDecimal("1.50"), 8);
//            Items item4 = new Items("Coca Cola", new BigDecimal("1.50"), 0);
//            Items item5 = new Items("Vitamin Water", new BigDecimal("1.50"), 6);

            
//            assertEquals(items.get(0), item);
//            assertEquals(items.get(1), item);
//            assertEquals(items.get(2), item);
//            assertEquals(items.get(3), item);
            

                //Vitamin Water::2.00::6
                assertEquals("Vitamin Water" ,items.get(4).getName());
                assertEquals(new BigDecimal("2.00") ,items.get(4).getAmount());
                assertEquals(6 ,items.get(4).getQuantity());
            
            //pull out the last item and write asserts for its properties
        } catch (VendingMachineExceptions ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of removeInventory method, of class VendingMachineDaoFileimpl.
     */
    @Test
    public void testRemoveInventory() throws VendingMachineExceptions {

        Items item = dao.getItem("Water");

        assertEquals(item.getQuantity(), 4);

        try {
            Items testitem = dao.removeInventory("Water");
        } catch (VendingMachineExceptions e) {

        }

        Items reducedItem = dao.getItem("Water");

        assertEquals(reducedItem.getQuantity(), 3);

        //the test below should use a fixed number for the expected quantity (the left value) 
        //assertEquals(item.getQuantity(), testItem.getQuantity());
    }

}
