//Mack Bakkum - Een programma wat de gebruiker vraagt hoeveel auto's er zijn geparkeerd.
//Op basis van vervolg informatie van de gebruiker (Kenteken, parkeer lengte) komt er een uitdraai met de bedragen passend bij elk kenteken en een totaal bedrag.

package Controller;

import java.util.Scanner;

public class Main {

    final static int MAX_HOURS = 24;
    final static int BASE_HOURS = 3;
    final static double PARKING_BASE_RATE = 3.75;
    final static double PARKING_SECONDARY_RATE = 2.75;
    final static double PARKING_DAY_RATE = 25.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Gebruiker geeft antwoord en de 3 Arrays worden gemaakt met de opgegeve hoeveelheid
        System.out.print("Hoeveel auto's hebben geparkeerd?:");
        int carAmount = scanner.nextInt();
        scanner.nextLine();

        String[] licensePlates = new String[carAmount];
        int[] parkingDuration = new int[carAmount];
        double[] parkingCosts = new double[carAmount];

        //Gebruiker wordt gevraagd om de informatie van de auto's in te voeren. Via een do/while loop wordt er als er >25 wordt opgegeven weer opnieuw om de uren gevraagd.
        for (int i = 0; i < carAmount; i++) {
            System.out.println("Auto " + (i + 1));
            System.out.print("Kenteken: ");
            String inputLicensePlate = String.valueOf(scanner.nextLine());
            licensePlates[i] = inputLicensePlate;
            int inputParkedHours;

            do {
                System.out.print("Geparkeerde uren (max. 24): ");
                inputParkedHours = scanner.nextInt();
                scanner.nextLine(); //emptying buffered line
                if (inputParkedHours > 24) {
                    System.out.println("De parkeerduur kan maximaal 24 uur zijn.");
                }
            } while (inputParkedHours > 24);
            parkingDuration[i] = inputParkedHours;//last
        }

        //Methode wordt aangeroepen om de parkeerkosten te berekenen per auto in de Array.
        for (int i = 0; i < carAmount; i++) {
            parkingCosts[i] = berekenParkeergeld(parkingDuration[i]);
        }

        //Print van het totale overzicht met kenteken en de uren / bedragen die bijhorend zijn.
        System.out.println();//empty println to match output from exercise.
        System.out.println("Parkeeroverzicht");
        System.out.printf("%-15s %-10s %-30s\n", "Kenteken", "Uren", "Bedrag");
        for (int i = 0; i < carAmount; i++) {
            System.out.printf("%-15s %-10d %-30.2f\n", licensePlates[i], parkingDuration[i], parkingCosts[i]);
        }

        //Laatste methode wordt opgevraagd om de totale parkeerkosten te berekenen en uit te printen.
        double totalParkSum = berekenTotaleParkeerKosten(parkingCosts);
        System.out.printf("Totaal van alle parkeergelden: %-1.2f euro\n", totalParkSum);
    } //end of Main


    public static double berekenParkeergeld(int mpParkeerduur) {
        double totalParkingCosts = 0.0;
        if (mpParkeerduur <= BASE_HOURS) {
            totalParkingCosts = mpParkeerduur * PARKING_BASE_RATE;

        }
        if (mpParkeerduur > BASE_HOURS && mpParkeerduur <= MAX_HOURS) {
            mpParkeerduur = mpParkeerduur - BASE_HOURS;
            totalParkingCosts = mpParkeerduur * PARKING_SECONDARY_RATE + (3 * PARKING_BASE_RATE);
            if (totalParkingCosts >= 25.0) {
                totalParkingCosts = PARKING_DAY_RATE;
            }
        }
        if (mpParkeerduur > MAX_HOURS) {
            System.out.println("De parkeerduur kan maximaal 24 uur zijn");
        }
        return totalParkingCosts;
    }//end of berekenParkeerGeld


    public static double berekenTotaleParkeerKosten(double[] mpParkeerKosten) {
        double totalCosts = 0.0;
        for (double v : mpParkeerKosten) {
            totalCosts = totalCosts + v;
        }
        return totalCosts;
    }//end of berekenTotaleParkeerKosten

}//end of class

