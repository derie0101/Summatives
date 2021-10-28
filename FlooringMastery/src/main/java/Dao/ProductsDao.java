/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Product;
import java.util.List;

/**
 *
 * @author QUEEN
 */
public interface ProductsDao {
     public List<Product> getAllProducts() throws FlooringDaoException;
    
}
