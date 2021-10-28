/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 *
 * @author QUEEN
 */
public class Order {
    private int orderNumber;
    private String customerName;
    private String state;
    private BigDecimal taxRate;
    private String productName;
    private BigDecimal area;
    private BigDecimal costPerSq;
    private BigDecimal laborPerSq;
    private LocalDate orderDate;



    public Order(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    
    
    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getCostPerSq() {
        return costPerSq;
    }

    public void setCostPerSq(BigDecimal costPerSq) {
        this.costPerSq = costPerSq;
    }

    public BigDecimal getLaborPerSq() {
        return laborPerSq;
    }

    public void setLaborPerSq(BigDecimal laborPerSq) {
        this.laborPerSq = laborPerSq;
    }

    public BigDecimal getMaterialCost() {
        return area.multiply(costPerSq) ;
    }

    public BigDecimal getLaborCost() {
        return area.multiply(laborPerSq);
    }

    public BigDecimal getTotalTax() {
       
        return (getMaterialCost().add(getLaborCost() ).multiply(taxRate.movePointLeft(2).setScale(2, RoundingMode.HALF_UP)));
         
    }

    public BigDecimal getTotalAmount() {
        return getMaterialCost().add(getLaborCost()).add(getTotalTax().setScale(2, RoundingMode.HALF_UP));
    }

}


