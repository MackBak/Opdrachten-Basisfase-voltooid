//Mack Bakkum -- Oefenopdracht V2
//Een programma waar per kenteken het te betalen bedrag wordt berekend op basis van de parkeerprijzen.
//Gebruiker geeft invoer over hoeveel auto's geparkeerd zijn, de kentekens en de geparkeerde uren.

package Controller;

import java.util.Scanner;

public class Main {

    //Static variables are defined to avoid magic numbers as per request in the exercise.
    final static int MAX_PARK_DURATION = 24;
    final static int MAX_BASE_HOURS = 3;
    final static double INITIAL_RATE = 3.75;
    final static double MAX_INITIAL_PRICE = MAX_BASE_HOURS * INITIAL_RATE;
    final static double SECONDARY_RATE = 2.75;
    final static double MAX_DAY_PRICE = 25.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //User is being prompted to fill in how many cars have parked. Following this the correctly sized Arrays are made.
        System.out.print("Hoeveel auto's hebben geparkeerd?:");
        int carsAmount = Integer.parseInt(scanner.nextLine());
        String[] licensePlate = new String[carsAmount];
        int[] parkingDuration = new int[carsAmount];
        double[] parkingCosts = new double[carsAmount];

        //For loop to save all licensepates. Next a do/while loop to save the parkers hours per vehicle.
        for (int i = 0; i < carsAmount; i++) {
            System.out.println("Auto " + (i + 1));
            System.out.print("Kenteken:");
            licensePlate[i] = scanner.nextLine();
            do {
                System.out.print("Geparkeerde uren (max. 24):");
                parkingDuration[i] = Integer.parseInt(scanner.nextLine());
                if (parkingDuration[i] > 24) {
                    System.out.println("De parkeerduur kan maximaal 24 uur zijn.");
                }
            } while (parkingDuration[i] > 24);
            parkingCosts[i] = berekenParkeergeld(parkingDuration[i]);
        }

        //Prints the complete overview of license plates, hours & costs in correct format.
        System.out.println("\nParkeeroverzicht");
        System.out.printf("%-20s %-20s %-20s %n", "Kenteken", "Uren", "Bedrag");
        for (int i = 0; i < carsAmount; i++) {
            System.out.printf("%-20s %-20d %-20.2f %n", licensePlate[i], parkingDuration[i], parkingCosts[i]);
        }

        //Calls the method to calculate the total combined to be paid money of all parked cars.
        double totalParkingCosts = berekenTotaleParkeerKosten(parkingCosts);
        System.out.println("Totaal van alle parkeergelden: " + totalParkingCosts);

    }//end of main

    public static double berekenParkeergeld(int mpParkeerduur) {
        double parkingCosts = 0;
        if (mpParkeerduur <= MAX_BASE_HOURS) {
            parkingCosts = mpParkeerduur * INITIAL_RATE;
        }
        if (mpParkeerduur > MAX_BASE_HOURS) {
            mpParkeerduur = (mpParkeerduur - MAX_BASE_HOURS);
            parkingCosts = MAX_INITIAL_PRICE + (mpParkeerduur * SECONDARY_RATE);
            if (parkingCosts > MAX_DAY_PRICE) {
                parkingCosts = MAX_DAY_PRICE;
            }
        }
        if (mpParkeerduur > MAX_PARK_DURATION) {
            parkingCosts = MAX_DAY_PRICE;
        } return parkingCosts;
    }

    public static double berekenTotaleParkeerKosten(double[] mpParkeerKosten) {
        double totalParkingCosts = 0;
        for (double v : mpParkeerKosten) {
            totalParkingCosts += v;
        }
        return totalParkingCosts;
    }

}//end of class
