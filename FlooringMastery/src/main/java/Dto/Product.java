/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.math.BigDecimal;

/**
 *
 * @author QUEEN
 */
public class Product {
      private String productName;
    private BigDecimal costPerSquareFeet;
    private BigDecimal laborPerSquareFeet;

    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getCostPerSq() {
        return costPerSquareFeet;
    }

    public void setCostPerSq(BigDecimal costPerSq) {
        this.costPerSquareFeet = costPerSq;
    }

    public BigDecimal getLaborPerSq() {
        return laborPerSquareFeet;
    }

    public void setLaborPerSq(BigDecimal laborPerSq) {
        this.laborPerSquareFeet = laborPerSquareFeet;
    }
}
