/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.m1rps;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author QUEEN
 */
public class RockpaperScissors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int endGame = 1;
        while (endGame == 1) {
            System.out.println("how many do you want to play");
            int howManyRounds = sc.nextInt();
            int rock = 1;
            int pape = 2;
            int scisscors = 3;
            int maxRounds = 10;
            int minRound = 1;
            int rounds = 0;
            int computerAnswer = 0;
            int userAnswer = 0;
            int win = 0;
            int lost = 0;
            int tie = 0;

            for (int i = 0; i < howManyRounds; i++) {
                int minRounds = 1;

                if (howManyRounds > maxRounds || howManyRounds < minRounds) {
                    System.out.println("Error Message");
                    System.out.println("You can only play 10 rounds");
                    break;
                    //if (howmanyRounds > 10){
                    
                }
                System.out.println("Choose 1 for Rock, 2 for paper and 3 for scissors");
                userAnswer = sc.nextInt();
                computerAnswer = r.nextInt(3) + 1;

                if (computerAnswer == userAnswer) {
                    System.out.println("It was a TIE!!");
                    tie++;

                } else if (computerAnswer == rock && userAnswer == pape) {
                    System.out.println("You WON!!");
                    win++;

                } else if (computerAnswer == 1 && userAnswer == 3) {
                    System.out.println("You LOST!!");
                    lost++;

                } else if (computerAnswer == 2 && userAnswer == 1) {
                    System.out.println("You LOST!!");
                    win++;

                } else if (computerAnswer == 2 && userAnswer == 3) {
                    System.out.println("You WON!!");
                    lost++;

                } else if (computerAnswer == 3 && userAnswer == 1) {
                    System.out.println("You WON!!");
                    lost++;

                } else if (computerAnswer == 3 && userAnswer == 2) {
                    System.out.println("You LOST!!");
                    lost++;

                } else if (computerAnswer == 12) {
                    rounds++;
                }
            }

            System.out.println("You had a " + tie + " tie," + win + " User Wins, and " + lost + "Computer Wins");
            if (win > lost) {
                System.out.println("You are the Overall Winner! Congrats! ");
            } else if (win < lost) {
                System.out.println("Computer is the overall Winner");
            } else {
                System.out.println("Game ended in a tie.");
            }
            System.out.println("Do You Want to Play Again? Yes(1) or No(2)?");
            int newGame = sc.nextInt();
            if (newGame == 2) {
                endGame = 0;
                System.out.println("Goodbye");

            } else if (newGame == 1) {
                endGame = 1;
            }
        }
    }
}
