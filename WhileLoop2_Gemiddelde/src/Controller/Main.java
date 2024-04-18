//Mack Bakkum - Programma dat d.m.v. een loop het gemiddelde berekent voor de gebruiker.
package Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dit programma berekent het gemiddelde van twee of meer getallen.");
        System.out.print("Geef het eerste getal:");
        double numberOne = Double.valueOf(scanner.nextLine());
        System.out.print("Geef het tweede getal:");
        double numberTwo = Double.valueOf(scanner.nextLine());

        double sum = numberOne + numberTwo;
        int totalNumbers = 2;

        while (true) {
            System.out.print("Wil je van meer getallen het gemiddelde bepalen (ja/nee)?");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase("ja")) {
                System.out.print("Geef het volgende getal:");
                sum = sum + scanner.nextDouble();
                totalNumbers++;
            } if (userAnswer.equalsIgnoreCase("nee")) {
                double averageNumbers = sum / totalNumbers;
                double finalAverage = Math.round(averageNumbers * 100) / 100.0;
                System.out.println("Het gemiddelde van jouw " + totalNumbers + " getallen is: " + finalAverage);
                break;
            } if (!userAnswer.equalsIgnoreCase("nee") && !userAnswer.equalsIgnoreCase("ja")) {
                System.out.println("Je moet ‘ja’ of ‘nee’ antwoorden.");
            }
        }

    }//end of main

}//end of class
