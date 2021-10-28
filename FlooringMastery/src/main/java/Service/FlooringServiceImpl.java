/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.FlooringDaoException;
import Dao.OrderDao;
import Dao.ProductsDao;
import Dao.Tax;
import Dto.Order;
import Dto.Product;
import FlooringMastery.Dao.ProductDao;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public class FlooringServiceImpl  implements FlooringService{
OrderDao orderDao;
ProductDao productDao;
Tax taxDao;

    public FlooringServiceImpl(OrderDao DaoOrder, ProductsDao DaoProduct, Tax DaoTax) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Order getOrder(LocalDate date, int orderNumber) throws FlooringDaoException {
        return orderDao.getOrder(date, orderNumber);
    }

    @Override
    public Order addOrder(Order newOrder) throws FlooringDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getAllOrders(LocalDate date) throws FlooringDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeOrder(LocalDate date, int orderNumber) throws FlooringDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order editOrder(Order order) throws FlooringDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAllProducts() throws FlooringDaoException {
        return null;
    }
    

    @Override
    public List<Tax> getAllTaxes() throws FlooringDaoException {
        return taxDao.getAllTaxes();
    }
    
}
