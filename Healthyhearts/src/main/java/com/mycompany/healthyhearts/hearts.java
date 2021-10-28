/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.healthyhearts;

import java.util.Scanner;

/**
 *
 * @author QUEEN
 */
public class hearts {

    public static void main(String[] arg) {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("what is your age");
        int age = inputReader.nextInt();

        int max = 220 - age;
        double mintarget = .50 * max;
        double maxtarget = .85 * max;

        System.out.println("Your maximum heart should be " + max + " beats per minute ");
        System.out.println("Your target HR zone " + mintarget + " -" + maxtarget + " beats per minute ");

    }

}
