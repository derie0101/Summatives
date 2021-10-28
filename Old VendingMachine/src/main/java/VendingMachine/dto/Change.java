/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author QUEEN
 */
public class Change {

     private int dollars;
    private int quaters;
    private int dimes;
    private int nickels;
    private int pennies;
   
    
   
    public Change(BigDecimal money) {
        int Return = money.multiply(new BigDecimal(100)).intValue();
        this.dollars=Return/100;
        Return-=this.dollars*100;
        
        this.quaters=Return/25;
        Return-=this.quaters*25;
        
        this.dimes=Return/10;
        Return-=this.dimes*10;
        
        this.nickels=Return/5;
        Return-=this.nickels*5;
        
        this.pennies=Return/1;
        
        
       
        
        
        
        
        
}

    /**
     * @return the dollars
     */
    public int getDollars() {
        return dollars;
    }

    /**
     * @param dollars the dollars to set
     */
    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    /**
     * @return the quaters
     */
    public int getQuaters() {
        return quaters;
    }

    /**
     * @param quaters the quaters to set
     */
    public void setQuaters(int quaters) {
        this.quaters = quaters;
    }

    /**
     * @return the dimes
     */
    public int getDimes() {
        return dimes;
    }

    /**
     * @param dimes the dimes to set
     */
    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    /**
     * @return the nickels
     */
    public int getNickels() {
        return nickels;
    }

    /**
     * @param nickels the nickels to set
     */
    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    /**
     * @return the pennies
     */
    public int getPennies() {
        return pennies;
    }

    /**
     * @param pennies the pennies to set
     */
    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

 
}
