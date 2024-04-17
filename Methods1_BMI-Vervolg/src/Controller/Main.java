//Mack Bakkum - BMI Calculeren d.m.v. methods.

package Controller;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geef je lengte in CM:");
        int lengte = scanner.nextInt();

        System.out.print("Geef je gewicht in KG:");
        double gewicht = scanner.nextDouble();

        double userBMI = Methods.berekenBMI(lengte, gewicht);

        System.out.println(); //empty to print empty line

        if (userBMI < 18.5) {
            System.out.println("Jouw BMI is: " + userBMI + " (Ondergewicht)");
        } if (userBMI < 25 && userBMI >= 18.5) {
            System.out.println("Jouw BMI is: " + userBMI + " (Gezond Gewicht)");
        } if (userBMI > 25 && userBMI <= 30) {
            System.out.println("Jouw BMI is: " + userBMI + " (Overgewicht)");
        } if (userBMI > 30) {
            System.out.println("Jouw BMI is: " + userBMI + " (Obesitas)");
        }
    } //end of main
} // end of class
