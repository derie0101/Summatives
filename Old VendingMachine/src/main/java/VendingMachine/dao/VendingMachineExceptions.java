/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.dao;

import java.util.List;

/**
 *
 * @author QUEEN
 */
public class VendingMachineExceptions extends Exception{

    public VendingMachineExceptions(String message) {
        super(message);
    }

    public VendingMachineExceptions (String message, Throwable cause) {
        super(message, cause);
    }

}
