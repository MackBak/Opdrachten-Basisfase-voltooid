//Mack Bakkum - Een programma wat random nummers genereerd en vervolgens de getallen laat zien, de som uitrekent & het gemiddelde laat zien.
//Hierna checkt het programma hoe vaak getallen voorkomen in de Array.

package Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hoeveel getallen wil je genereren?:");
        int amountNumbers = Integer.valueOf(scanner.nextLine());
        System.out.print("Wat is het grootste getal dat mag voorkomen?");
        int biggestNumber = Integer.valueOf(scanner.nextLine());

        int[] arrayRandom = maakRandomRijGetallen(amountNumbers, biggestNumber);
        System.out.print("Dit zijn de getallen:");
        for (int i = 0; i < arrayRandom.length; i++) {
            System.out.print(arrayRandom[i] + " ");
        }

        //Som van een rij getallen (basis):
        System.out.println();
        System.out.println("------------");

        int totalSum = somVanRij(arrayRandom);
        System.out.print("De totale som getallen is: " + totalSum);

        //Gemiddelde van een rij getallen (basis):
        System.out.println();
        System.out.println("------------");

        double average = gemiddeldeVanRij(arrayRandom);
        System.out.print("Het gemiddelde is: " + average);

        //Minimum van een rij (basis):
        System.out.println();
        System.out.println("------------");

        int minNumber = minimumNumber(arrayRandom);
        System.out.println("Het laagste getal is: " + minNumber);

        //Hoe vaak komt een getal voor? (basis):
        System.out.println();
        System.out.println("------------");

        System.out.print("Welk getal wil je checken?:");
        int userNumberCheck = Integer.valueOf(scanner.nextLine());
        int amountUsed = telVoorkomensInRij(arrayRandom, userNumberCheck);
        System.out.println("Het getal " + userNumberCheck + " is " + amountUsed + " keer gebruikt.");

        //Voorkomen van alle getallen tellen (gevorderd):
        System.out.println();
        System.out.println("------------");

        advancedVoorkomenRij(arrayRandom, 0);
    }

    public static int[] maakRandomRijGetallen(int mpAantal, int mpMaximum) {
        int[] arrayRandom = new int[mpAantal];
        for (int i = 0; i < mpAantal; i++) {
            arrayRandom[i] = (int) (Math.random() * (mpMaximum + 1));
        }
        return arrayRandom;
    }

    public static int somVanRij(int[] mpRij) {
        int totalSum = 0;
        for (int number : mpRij) {
            totalSum += number;
        }
        return totalSum;
    }

    public static double gemiddeldeVanRij(int[] mpRij) {
        int sum = somVanRij(mpRij);
        double average = (double) sum / mpRij.length;
        return average;
    }

    public static int minimumNumber(int[] mpRij) {
        int minNumber = mpRij[0];
        for (int i = 0; i < mpRij.length; i++) {
            if (mpRij[i] < minNumber) {
                minNumber = mpRij[i];
            }
        }
        return minNumber;
    }

    public static int telVoorkomensInRij(int[] mpRij, int mpGetal) {
        int sumCheck = 0;
        for (int i = 0; i < mpRij.length; i++) {
            if (mpRij[i] == mpGetal) {
                sumCheck++;
            }
        }
        return sumCheck;
    }

    public static void advancedVoorkomenRij(int[] mpRij, int mpGetal) {
        mpGetal = 0;
        while (mpGetal <= 50) {
            int sumCheck = 0;
            for (int i = 0; i < mpRij.length; i++) {
                if (mpRij[i] == mpGetal) {
                    sumCheck++;
                }
            }
            System.out.println("Getal " + mpGetal + " komt " + sumCheck + " keer voor.");
            mpGetal++;
        }
    }
}
