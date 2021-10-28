/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.FlooringDaoException;
import Dao.Tax;
import Dto.Order;
import Dto.Product;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public interface FlooringService  {
    Order getOrder(LocalDate date, int orderNumber) throws FlooringDaoException;

    Order addOrder(Order newOrder) throws FlooringDaoException;

    List<Order> getAllOrders(LocalDate date) throws FlooringDaoException;

    void removeOrder(LocalDate date, int orderNumber) throws FlooringDaoException;

    Order editOrder(Order order) throws FlooringDaoException;
    
    public List<Product> getAllProducts() throws FlooringDaoException;
    
    public List<Tax> getAllTaxes() throws FlooringDaoException;
    
    //need a calculate method here!!!
    
}
    

