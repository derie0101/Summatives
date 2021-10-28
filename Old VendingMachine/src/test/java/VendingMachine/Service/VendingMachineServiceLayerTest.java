/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.Service;

import VendingMachine.dao.Inmemorytest;
import VendingMachine.dao.VendingMachineDao;
import VendingMachine.dao.VendingMachineExceptions;
import VendingMachine.dto.Change;
import VendingMachine.dto.Items;
import java.math.BigDecimal;
import java.util.List;
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
public class VendingMachineServiceLayerTest {

    VendingMachineDao dao = new Inmemorytest();
    VendingMachineServiceLayer service = new VendingMachineServiceLayer(dao);

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetAllItems() throws Exception {
        VendingMachineDao dao = new Inmemorytest();
        VendingMachineServiceLayer service = new VendingMachineServiceLayer(dao);

        List<Items> allItems = service.getAllItems();
        assertEquals(2, allItems.size());

        //here pull out the last item in the list and write asserts for its properties
        Items singleToCheck = allItems.get(1);
        assertEquals("Coco-cola", singleToCheck.getName());
        assertEquals(new BigDecimal ("1.00") ,singleToCheck.getAmount());
        assertEquals(0, singleToCheck.getQuantity());
    }

    /**
     * Test of vend method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testVend() {

        try {
            BigDecimal totalMoney = service.deposit(new BigDecimal("2.00"));
            service.vend("Water");
            
            //get the Water item from the dao
            Items toCheck = dao.getItem("Water");
            assertEquals(4, toCheck.getQuantity());
            //assert that its quantity is 1 less than what's in the seed file

            //finish implmenting this golden path test and also do invalid inputs
            //  (not real item names, not enough money inserted, and out of stock)
        } catch (VendingMachineExceptions | InsufficientFundsException | NoInventoryException | InvalidItemException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testVendFakeItem() {
        try {
          BigDecimal totalMoney = service.deposit(new BigDecimal("2.00"));
            service.vend("fakeItem");
            fail();
        } catch (InvalidItemException e) {

        } catch (VendingMachineExceptions | InsufficientFundsException | NoInventoryException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testVendInsufficientFunds() {
        try {
             BigDecimal totalMoney = service.deposit(new BigDecimal("0.50"));
            service.vend("Water");
            fail();
        } catch (InsufficientFundsException e) {

        } catch (VendingMachineExceptions | InvalidItemException | NoInventoryException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testNoInventoryException() {
        try {
             BigDecimal totalMoney = service.deposit(new BigDecimal("10.00"));
            service.vend("Coco-cola");
          
            fail();
        } catch (NoInventoryException e) {

        } catch (VendingMachineExceptions | InvalidItemException | InsufficientFundsException ex) {
            fail(ex.getMessage());
        }
    }

    /* Test of getChange method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetChange() throws InsufficientFundsException {
        VendingMachineDao dao = new Inmemorytest();
        VendingService service = new VendingMachineServiceLayer(dao);

        BigDecimal input = service.deposit(new BigDecimal("3.50"));
        Change returned = service.getChange();

        assertEquals(3, returned.getDollars());
        assertEquals(2, returned.getQuaters());
        assertEquals(0, returned.getDimes());
        assertEquals(0, returned.getNickels());
        assertEquals(0, returned.getPennies());
        //VendingMachineDao Dao = new Inmemory

        //finish implementing golden path test
    }

    /**
     * Test of deposit method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testDeposit() throws Exception {
        VendingMachineDao dao = new Inmemorytest();
        VendingService service = new VendingMachineServiceLayer(dao);

        BigDecimal input = service.deposit(new BigDecimal("5.00"));
       

        Change returned = service.getChange();

        assertEquals(5, returned.getDollars());
        assertEquals(0, returned.getQuaters());
        assertEquals(0, returned.getDimes());
        assertEquals(0, returned.getNickels());
        assertEquals(0, returned.getPennies());

//        Items toCheck = dao.getItem("Water");
//        assertEquals(3, toCheck.getQuantity());

    }

    @Test
    public void testInvalidDeposit() {
        try {
            VendingMachineDao dao = new Inmemorytest();
            VendingService service = new VendingMachineServiceLayer(dao);

            BigDecimal input = service.deposit(new BigDecimal("-1"));
            
            } catch (InsufficientFundsException e) {
            Change returned = service.getChange();

            assertEquals(0, returned.getDollars());
            assertEquals(0, returned.getQuaters());
            assertEquals(0, returned.getDimes());
            assertEquals(0, returned.getNickels());
            assertEquals(0, returned.getPennies());
            

        }
    }
}
