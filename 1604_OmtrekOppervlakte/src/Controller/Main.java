//Mack Bakkum - Cirkel & Driehoek berekenen d.m.v. methods.

package Controller;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cirkel of Driehoek?");
        String answer = scanner.nextLine().toLowerCase();

        if (answer.equals("cirkel")) {
            System.out.println("Wat is de diameter van de cirkel?");
            double diameter = Double.valueOf(scanner.nextLine());

            Methods.cirkel(diameter);

        } if (answer.equals("driehoek")) {
            System.out.println("Wat is de lengte van de driehoek?");
            double lengte = Double.valueOf(scanner.nextLine());
            System.out.println("Wat is de breedte van de driehoek?");
            double breedte = Double.valueOf(scanner.nextLine());

            Methods.driehoek(lengte, breedte);

        } else {
            System.out.println("Invalid input");
        }

    }// end of main
}// end of class
