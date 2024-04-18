//Mack Bakkum - Programma wat de tafel print van een getal wat de gebruiker geeft.

package Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(); //empty println to repeat the question on a new line after the loop comes around.
            System.out.print("Welke tafel wilt u afdrukken? (0=stoppen):");
            int userNumber = Integer.valueOf(scanner.nextLine());

            if (userNumber != 0) {

                System.out.println("Hoeveel getallen wilt u afdrukken?:");
                int numbersAmount = Integer.valueOf(scanner.nextLine());
                int finalNumber = userNumber * numbersAmount;
                int nextPrintNumber = userNumber;
                int numbersPerRow = 5;

                for (int i = 1; i <= numbersAmount; i++) {
                    System.out.print(nextPrintNumber + " ");
                    nextPrintNumber = nextPrintNumber + userNumber;

                    if (i % numbersPerRow == 0) {
                        System.out.println();//empty println to print an empty line once 5 numbers have been printed.(i % numbersPerRow(5) equals 0 means integer i is divisible by 5
                    }
                }
            }
            if (userNumber == 0) {
                break;
            }
        }
    } //end of Main

} // end of class
