/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author QUEEN
 */
     public class UserIOConsole implements UserIO {

    Scanner reader = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        double toReturn = Double.NaN;
        System.out.println(prompt);

        boolean validInput = false;
        while (!validInput) {
            try {
                //retrieve a line from the user
                String toCheck = reader.nextLine();
                toReturn = Double.parseDouble(toCheck);

                validInput = true;
            } catch (NumberFormatException e) {

                System.out.println(" enter a valid number. ");
            }

        }

        return toReturn;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {

        double toReturn = Double.NaN;

        boolean isValid = false;
        while (!isValid) {
            toReturn = readDouble(prompt);

            if (toReturn < min || toReturn > max) {
                System.out.println(" enter a number between " + min + " and " + max + "." );
            } else {
                isValid = true;
            }
        }

        return toReturn;

    }

    @Override
    public float readFloat(String prompt) {

        float toReturn = Float.NaN;
        System.out.println(prompt);

        boolean validInput = false;
        while (!validInput) {
            try {

                String toCheck = reader.nextLine();
                toReturn = Float.parseFloat(toCheck);

                validInput = true;
            } catch (NumberFormatException e) {

                System.out.println(" enter a valid number. ");
            }

        }

        return toReturn;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {

        float toReturn = Float.NaN;

        boolean isValid = false;
        while (!isValid) {
            toReturn = readFloat(prompt);

            if (toReturn < min || toReturn > max) {
                System.out.println(" enter a number between " + min + " and " + max + " . " );
            } else {
                isValid = true;
            }
        }

        return toReturn;
    }

    @Override
    public int readInt(String prompt) {
        int toReturn = Integer.MIN_VALUE;
        System.out.println(prompt);

        boolean validInput = false;
        while (!validInput) {
            try {

                String toCheck = reader.nextLine();
                toReturn = Integer.parseInt(toCheck);

                validInput = true;
            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }

        }

        return toReturn;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int toReturn = Integer.MIN_VALUE;

        boolean isValid = false;
        while (!isValid) {
            toReturn = readInt(prompt);

            if (toReturn < min || toReturn > max) {
                System.out.println(" enter a number between " + min + " and " + max + "." );
            } else {
                isValid = true;
            }
        }

        return toReturn;

    }

    @Override
    public long readLong(String prompt) {
        long toReturn = Long.MIN_VALUE;
        System.out.println(prompt);

        boolean validInput = false;
        while (!validInput) {
            try {

                String toCheck = reader.nextLine();
                toReturn = Long.parseLong(toCheck);

                validInput = true;
            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }

        }

        return toReturn;

    }

    @Override
    public long readLong(String prompt, long min, long max) {

        long toReturn = Long.MIN_VALUE;

        boolean isValid = false;
        while (!isValid) {
            toReturn = readLong(prompt);

            if (toReturn < min || toReturn > max) {
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } else {
                isValid = true;
            }
        }

        return toReturn;
    }

    @Override
    public String readString(String prompt) {

        System.out.println(prompt);
        String toCheck = reader.nextLine();

        return toCheck;

    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        BigDecimal toReturn = null;
        System.out.println(prompt);

        boolean validInput = false;
        while (!validInput) {
            try {

                String toCheck = reader.nextLine();
                toReturn = new BigDecimal(toCheck);

                validInput = true;
            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }

        return toReturn;
    }

    @Override
    public LocalDate readDate(String prompt) {

        LocalDate toReturn = null;
        System.out.println(prompt);

        boolean validInput = false;
        while (!validInput) {
            try {

                String toCheck = reader.nextLine();
                toReturn = LocalDate.parse(toCheck, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                validInput = true;
            } catch (DateTimeParseException e) {

                System.out.println("Please enter a valid Date.");
            }

        }

        return toReturn;
    }

}


