//Mack Bakkum - 500721202

/*Een programma wat een gebruiker vraagt om input hoeveel autopolissen er geregistreerd moeten worden.
Op Basis van deze informatie worden Arrays in het juiste formaat aangemaakt en moet de gebruiker weer input geven over
de informatie van de auto's. Deze informatie komt in de Arrays en op basis van deze informatie wordt de jaarpremie berekend.
*/

package Controller;
import java.util.Scanner;

public class Verzekeringmaatschappij {

    final static double BASIS_JAAR_PREMIE = 0.1;
    final static double KORTING_PER_JAAR = 0.05;
    final static double MAX_BASIS_BEDRAG_PRCT = 0.7;
    final static double MAX_YRS_NO_DAMAGE = 14;
    final static double LAGE_PREMIES = 1000;
    final static int MAX_NODMG_YRS = 40;
    final static int MIN_NODMG_YRS = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Initial input from user is asked and converted to an integer to create the Arrays in the correct size.
        System.out.print("Hoeveel autopolissen wil je registreren?");
        int policyAmount = Integer.parseInt(scanner.nextLine());
        String[] policyName = new String[policyAmount];
        int[] carValue = new int[policyAmount];
        int[] damageFreeYrs = new int[policyAmount];
        double[] annualPremium = new double[policyAmount];

        //for loop to continuously ask for the information until the max amount of policies is reached.
        for (int i = 0; i < policyAmount; i++) {
            System.out.println("Autpolis " + (i + 1));
            System.out.printf("\t%s", "Naam polishouder:");
            policyName[i] = scanner.nextLine();

            do {//do/while loop to make sure the user enters a value greater than 1000
                System.out.printf("\t%s", "Waarde van de auto in euro’s : ");
                carValue[i] = Integer.parseInt(scanner.nextLine());
                if (carValue[i] < 1000) {
                    System.out.printf("\t%s", "De waarde moet minimaal 1000 euro zijn!\n");
                }
            } while (carValue[i] < 1000);

            do
            {//do/while loop to make sure the user enters a value greater than 0 and doesn't exceed the maximum years (40)
                System.out.printf("\t%s", "Aantal schadevrije jaren : ");
                damageFreeYrs[i] = Integer.parseInt(scanner.nextLine());
                if (damageFreeYrs[i] < MIN_NODMG_YRS) {
                    System.out.printf("\t%s", "Het aantal schadevrije jaren moet minimaal 0 zijn!\n");
                }
                if (damageFreeYrs[i] > MAX_NODMG_YRS) {
                    System.out.printf("\t%s", "Het aantal schadevrije jaren mag maximaal 40 zijn!\n");
                }
            } while (damageFreeYrs[i] > MAX_NODMG_YRS || damageFreeYrs[i] < MIN_NODMG_YRS);
        } // end of for loop.


        //for loop to calculate all yearly premiums per car and put them in their array.
        for (int i = 0; i < policyAmount; i++) {
            annualPremium[i] = berekenJaarpremie(carValue[i], damageFreeYrs[i]);
        }

        //Print out all information of the Arrays with the correct formatting as per exercise template.
        System.out.printf("%nOverzicht van de autopolissen%n");
        System.out.printf("%-20s %-20s %-20s %-20s %n", "polishouder", "waarde", "aantal jaren", "jaarpremie");
        for (int i = 0; i < policyAmount; i++) {
            System.out.printf("%-20s %-20d %-20d %-20.2f %n", policyName[i], carValue[i], damageFreeYrs[i], annualPremium[i]);
        }

        //Calling method bepaalLageJaarPremies to calculate the amount of premiums below 1000 euros (LAGE_PREMIES).
        int lowPremiums = bepaalLageJaarPremies(annualPremium);
        System.out.printf("%nAantal lage premies: " + lowPremiums);

    }//end of main

    public static double berekenJaarpremie(int mpWaarde, int mpAantalSchadevrijeJaren) {
        double actualPremium = mpWaarde * BASIS_JAAR_PREMIE;

        if (mpAantalSchadevrijeJaren > 0 && mpAantalSchadevrijeJaren <= MAX_YRS_NO_DAMAGE) {
            actualPremium = actualPremium - (actualPremium * KORTING_PER_JAAR * mpAantalSchadevrijeJaren);
        }
        if (mpAantalSchadevrijeJaren > MAX_YRS_NO_DAMAGE) {
            actualPremium = actualPremium - (actualPremium * MAX_BASIS_BEDRAG_PRCT);
        }
        return actualPremium;
    }

    public static int bepaalLageJaarPremies(double[] mpJaarPremies) {
        int lowPremiumAmount = 0;
        for (int i = 0; i < mpJaarPremies.length; i++) {
            if (mpJaarPremies[i] < LAGE_PREMIES) {
                lowPremiumAmount++;
            }
        }
        return lowPremiumAmount;
    }

}//end of class