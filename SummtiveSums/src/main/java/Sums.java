/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author QUEEN
 */
public class Sums {

    public static void main(String[] args) {
        int[] a1 = {1, 90, -33, -55, 67, -16, 28, -55, 15};

        int[] a2 = {999, -60, -77, 14, 160, 301};

        int[] a3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
140, 150, 160, 170, 180, 190, 200, -99};

        System.out.println("#1 Array sum; " + arraySum(a1));

        System.out.println("#2 Array sum: " + arraySum(a2));

        System.out.println("#3 Array sum: " + arraySum(a3));
    
    }

    public static int arraySum(int[] arrayTotal) {
        int total = 0;
    for(int i : arrayTotal){
        total += i;
    }
    return total;
    }


    
                
        
            
}
