//Mack Bakkum - Applicatie maken waarin gebruiker kan oefenen met het uitrekenen van de oppervlakte van een driehoek

package Controller;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wil je de oppervlakte van een driehoek uitrekenen?");
        System.out.print("Doorgaan (j/n)?:");
        String input = scanner.nextLine();

        int min = 2;
        int max = 10;

        while (!input.equals("n")) {
            int randomBasis =  (int)(Math.random() * (max - min + 1)) + min;
            int randomHoogte = (int)(Math.random() * (max - min + 1)) + min;
            
            double oppervlakte = Methods.berekenOppervlakteDriehoek(randomBasis, randomHoogte);

            System.out.println("Bereken de oppervlakte van een driehoek met basis " + randomBasis + " en hoogte " + randomHoogte + ":");
            double userOppervlakte = scanner.nextDouble();

            if (userOppervlakte == oppervlakte) {
                System.out.println("Jouw antwoord is goed!");
            } else {
                System.out.println("Jouw antwoord is fout!");
                System.out.println("Het juiste antwoord is: " + oppervlakte);
            }

        }//end of while loop
        System.out.println("Het programma wordt gestopt.");
    }
}