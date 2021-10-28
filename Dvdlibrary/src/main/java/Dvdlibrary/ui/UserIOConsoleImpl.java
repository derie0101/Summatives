/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvdlibrary.ui;

import java.util.Scanner;

/**
 *
 * @author QUEEN
 */
public class UserIOConsoleImpl implements UserIO {
     Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        print(prompt);
        double c = Double.parseDouble(sc.nextLine());
        return c;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        while (true) {
            print(prompt);
            double c = Double.parseDouble(sc.nextLine());
            if (c >= min && c <= max) {
                return c;
            } else {
                print("Number must be between" + min + "and" + max);
            }
        }
    }

    @Override
    public float readFloat(String prompt) {
        print(prompt);
        float b = Float.parseFloat(sc.nextLine());
        return b;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        print(prompt);
        do {
            print(prompt);
            float b = Float.parseFloat(sc.nextLine());
            if (b >= min && b <= max) {
                return b;
            } else {
                print("Number must be between" + min + "and" + max);
            }
        } while (true);
    }

    @Override
    public int readInt(String prompt) {
         int toReturn = Integer.MIN_VALUE;
         boolean isValid = false;
         while (!isValid) {
             String userInput = readString(prompt);
             try {
                 toReturn = Integer.parseInt(userInput);
                 isValid = true;
             }catch(NumberFormatException ex) {
                 
             }
             
         }
         
        return toReturn;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        do {
            int a = readInt(prompt);
            if (a >= min && a <= max) {
                return a;
            } else {
                print("Number must be between" + min + "and" + max);
            }
        } while (true);
    }

    @Override
    public long readLong(String prompt) {
        print(prompt);
        Long l = Long.parseLong(sc.nextLine());
        return l;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        while (true) {
            print(prompt);
            Long l = Long.parseLong(sc.nextLine());
            if (l >= min && l <= max) {
                return l;
            } else {
                print("Number must be between" + min + "and" + max);
            }
        }
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        String s = sc.nextLine();
        return s;
    }

}
