/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessingGame.GuessingGameServiceLayer;

/**
 *
 * @author QUEEN
 */
public class InvalidGuessException extends Exception {
        
    public InvalidGuessException(String message) {
        super(message);
    }

    public InvalidGuessException(String message, Throwable cause) {
        super(message, cause);
    }
 
    
    
}
