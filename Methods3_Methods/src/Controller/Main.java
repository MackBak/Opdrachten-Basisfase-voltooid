//Mack Bakkum - Methodes schrijven en in de main aanroepen

package Controller;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        toonSterrenVierkant();

        System.out.println();// empty println for empty line between methods

        System.out.print("Welk woord wil je vijf keer zien?");
        String userWoord = scanner.nextLine();
        toonWoordVijfKeer(userWoord);

        System.out.println();// empty println for empty line between methods

        System.out.print("Hoeveel euros wil je verdelen?:");
        int userEuros = scanner.nextInt();
        System.out.print("Met hoeveel personen?:");
        int userPersonen = scanner.nextInt();
        euroVerdeling(userEuros, userPersonen);

        System.out.println();// empty println for empty line between methods

        System.out.print("Hoeveel moet je betalen?");
        double toPay = scanner.nextDouble();
        System.out.print("Hoeveel heb je gegeven?");
        double amountPaid = scanner.nextDouble();
        double change = berekenWisselgeld(toPay, amountPaid);
        System.out.println("Je krijgt " + change + " terug.");

        System.out.println();// empty println for empty line between methods

        System.out.print("Hoeveel moet je betalen?");
        double advancedToPay = scanner.nextDouble();
        System.out.print("Hoeveel heb je gegeven?");
        double advancedAmountPaid = scanner.nextDouble();
        double advancedChange = advancedWisselgeld(advancedToPay, advancedAmountPaid);
        System.out.println("Je krijgt " + advancedChange + " terug.");

    }// end of main


    public static void toonSterrenVierkant() {
        System.out.println("* * * *");
        System.out.println("* * * *");
        System.out.println("* * * *");
        System.out.println("* * * *");
    }//end of toonSterren

    public static void toonWoordVijfKeer(String mpWoord) {
        System.out.println(mpWoord + mpWoord + mpWoord + mpWoord + mpWoord);
    }//end of toonWoord

    public static void euroVerdeling(int euros, int personen) {
        int dividedEuros = euros / personen;
        int restEuros = euros - (dividedEuros * personen);
        System.out.println("Als je " + euros + " euromunten verdeeld over " + personen + " mensen dan krijgt ieder " + dividedEuros + " munten en blijven er " + restEuros + " over.");
    }

    public static double berekenWisselgeld(double mpTeBetalen, double mpBetaald) {
        return mpBetaald - mpTeBetalen;
    }

    public static double advancedWisselgeld(double teBetalen, double betaald) {
        double change = betaald - teBetalen;
        return Math.round(change * 20) / 20.0;
    }
}//end of class