//Mack Bakkum - Een programma maken waarin je een dobbelsteen loopt tot hij op 6 komt.

package Controller;

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welk karakter moet ik gebruiken voor het oog?:");
        String userAnswer = scanner.nextLine();
        char userChar = userAnswer.charAt(0);
        int randomNumber;

        do {
            double randomValue = Math.random();
            randomNumber = (int) (randomValue * 6) + 1;
            dobbelsteen(randomNumber, userChar);
            System.out.println("-------"); //empty line to seperate dices per output.
        } while (randomNumber != 6);
    }//end of main

    public static void dobbelsteen(int rng, char character) {
        if (rng == 1) {
            System.out.println(character);
        }

        if (rng == 2) {
            System.out.println(character);
            System.out.println();
            System.out.println("  " + character);
        }

        if (rng == 3) {
            System.out.println(character + "");
            System.out.println(" " + character);
            System.out.println("  " + character);
        }

        if (rng == 4) {
            System.out.println(character + " " + character);
            System.out.println();
            System.out.println(character + " " + character);
        }

        if (rng == 5) {
            System.out.println(character + " " + character);
            System.out.println(" " + character);
            System.out.println(character + " " + character);
        }

        if (rng == 6) {
            System.out.println(character + " " + character);
            System.out.println(character + " " + character);
            System.out.println(character + " " + character);
        }
    }
}//end of class
