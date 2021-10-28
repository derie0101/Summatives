/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public interface OrderDao {
     Order getOrder(LocalDate date, int orderNumber) throws FlooringDaoException;

    Order addOrder(Order newOrder) throws FlooringDaoException;

    List<Order> getAllOrders(LocalDate date) throws FlooringDaoException;

    void removeOrder(LocalDate date, int orderNumber) throws FlooringDaoException;

    Order editOrder(Order order) throws FlooringDaoException;
    
}
