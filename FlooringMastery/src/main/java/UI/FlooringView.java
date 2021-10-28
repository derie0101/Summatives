/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Dao.Tax;
import Dto.Order;
import Dto.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author QUEEN
 */
public class FlooringView {
     private UserIO io;

    public FlooringView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print(" Main Menu ");
        io.print(" 1. Add Order ");
        io.print(" 2. Remove Order ");
        io.print(" 3. Edit Existing Order ");
        io.print(" 4. List Orders ");
        io.print(" 5. Display Specific Order ");
        io.print(" 6. Exit ");

        return io.readInt(" select from the above choices. ", 1, 6);
    }

    public Order getNewOrder(List<Product> allProducts, List<Tax> allTaxes) {
        LocalDate date = io.readDate(" Enter Date ");
        String customerName = io.readString(" Enter Customer Name ");

        BigDecimal area = io.readBigDecimal(" enter Area ");

        Tax selectedState = getState(allTaxes);

        Product selectedProduct = selectedProduct (allProducts);

        Order newOrder = new Order(date);
        newOrder.setOrderDate(date);
        newOrder.setCustomerName(customerName);
        newOrder.setProductName(selectedProduct.getProductName());
        newOrder.setCostPerSq(selectedProduct.getCostPerSq());
        newOrder.setLaborPerSq(selectedProduct.getLaborPerSq());
        newOrder.setArea(area);

        return newOrder;

    }

    private Tax getState(List<Tax> allTaxes) {
        Tax sChoice = null;
        boolean validState = false;
        while (!validState) {
            String state = io.readString(" Select a State ");

           
            }
         return null;

        
    }  {

    
//    public LocalDate getOrderDate() {
//        return io.readDate(" Enter Date of Order ");
    }

    public int getOrderNumber() {
        return io.readInt(" Enter Order Number ");

    }

    private Product editProduct() {
         return null;
      
        
            }

     
    


    public Order editOrder(List<Product> allProducts, List<Tax> allTaxes, Order order) {

        String customerName = io.readString(" Enter Customer Name ");
       
        BigDecimal area = io.readBigDecimal(" Enter Area ");
        
        io.print(" Enter to Keep Existing State and Product Type ");
         return null;

   
    }
   
    public void DisplayExitBanner() {
        io.print(" GOOD BYE ! ");
    }

    public void orderNotFound() {
        io.print(" Order Cannot Be Found");
    }

    public void removeSuccess() {
        io.print(" Order Removed Successfully ");
    }

    public void addSucess() {
        io.print(" Order Added Successfully ");
    }

    public void NoOrdersForThatDate() {
        io.print(" No Orders for Date Entered Found ");
    }

    public void printAllOrders(List<Order> allOrders) {
        allOrders.forEach(o -> printOrder(o));

    }

    public void printOrder(Order order) {
        
        io.print(" Order Number : " + order.getOrderNumber());
        io.print(" Customer Name : " + order.getCustomerName());
       
        io.print(" Order State : " + order.getState());
        io.print(" State Tax Rate : " + order.getTaxRate());
        
        io.print(" Product Type : " + order.getProductName());
        io.print(" Area : " + order.getArea());
       
        io.print(" Cost Per Square ft : " + order.getCostPerSq());
       
        io.print(" Labor Cost Per Square ft " + order.getLaborPerSq());
        io.print(" Total Material Cost " + order.getMaterialCost());
       
        
        io.print(" Total Labor Cost " + order.getLaborCost());
        io.print(" Total Amount " + order.getTotalAmount());

    }

    private Product selectedProduct(List<Product> allProducts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }
    

