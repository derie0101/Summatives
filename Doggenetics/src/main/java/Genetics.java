
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author QUEEN
 */
public class Genetics {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("What is your dog's name?");
        String name = scan.nextLine();

        //int sum = 100;
        
        int a = rand.nextInt(10000);
        int b = rand.nextInt(10000);
        int c = rand.nextInt(10000);
        int d = rand.nextInt(10000);
        int e = rand.nextInt(10000);
        
        int sum = a + b + c + d + e;
        
        a = a * 100 / sum;
        b = b * 100 / sum;
        c = c * 100 / sum;
        d = d * 100 / sum;
        e = 100 - a - b - c - d;
        
        
        
        System.out.println("Well then, I have this highly reliable report on Sir Fluffy McFlufferkins Esquire's prestigious background right here.");
        int dna = rand.nextInt(sum + 1);
        System.out.println(dna + "% st bernard");
        sum -= dna;
        dna = rand.nextInt(sum + 1);
        System.out.println(dna + "% Chihuahua ");

        sum -= dna;
        dna = rand.nextInt(sum + 1);
        System.out.println(dna + "% Dramatic RedNosed Asian Pug");

        sum -= dna;
        dna = rand.nextInt(sum + 1);
        System.out.println(dna + "% Common Cur");

        sum -= dna;
        dna = (sum);
        System.out.println(dna + "% King Doberman");
       
    }

}
