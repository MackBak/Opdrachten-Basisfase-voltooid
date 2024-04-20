//Mack Bakkum - Een applicatie die van een cirkel, rechthoek, vierkant & driehoek de oppervlakte uit kan rekenen.
//De applicatie vraagt de gebruiker welk figuur moet worden berekend en vraagt hierna om de juiste informatie.

package Controller;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double oppervlakteFiguur;


    public static void main(String[] args) {
        int userAnswer = 5;

        while (userAnswer != 0) {
            System.out.println("Van welke figuur wil je de oppervlakte uit laten rekenen");
            System.out.print("(cirkel = 1; rechthoek = 2; vierkant = 3; driehoek = 4; stoppen = 0):");
            userAnswer = scanner.nextInt();
            scanner.nextLine();// used so loop can run, would have an empty ln in buffer and quit the program after 1 run.

            switch (userAnswer) {
                case 1:
                    System.out.print("Wat is de straal?:");
                    double circleRadius = scanner.nextDouble();
                    oppervlakteFiguur = behandelCirkel(circleRadius);
                    System.out.println();//empty println to match exercise template
                    System.out.printf("De oppervlakte van jouw cirkel is %.0f vierkante centimeter.", oppervlakteFiguur);
                    System.out.println();//empty println to match exercise template
                    break;

                case 2:
                    System.out.print("Wat is de hoogte in cm?:");
                    double rectangleHeight = scanner.nextDouble();
                    System.out.print("Wat is de breedte in cm?:");
                    double rectangleWidth = scanner.nextDouble();
                    oppervlakteFiguur = behandekRechthoek(rectangleHeight, rectangleWidth);
                    System.out.println();//empty println to match exercise template
                    System.out.printf("De oppervlakte van jouw rechthoek is %.0f vierkante centimeter.", oppervlakteFiguur);
                    System.out.println();//empty println to match exercise template
                    break;

                case 3:
                    System.out.print("Wat is de zijde in cm?:");
                    double squareSide = scanner.nextDouble();
                    oppervlakteFiguur = behandelVierkant(squareSide);
                    System.out.println();//empty println to match exercise template
                    System.out.printf("De oppervlakte van jouw vierkant is %.0f vierkante centimeter.", oppervlakteFiguur);
                    System.out.println();//empty println to match exercise template
                    break;

                case 4:
                    System.out.print("Wat is de basis in cm?:");
                    double triangleBase = scanner.nextDouble();
                    System.out.print("Wat is de hoogte in cm?:");
                    double triangleHeight = scanner.nextDouble();
                    oppervlakteFiguur = behandelDriehoek(triangleBase, triangleHeight);
                    System.out.println();//empty println to match exercise template
                    System.out.printf("De oppervlakte van jouw driehoek is %.0f vierkante centimeter.", oppervlakteFiguur);
                    System.out.println();//empty println to match exercise template
                    break;
            }
        }
        System.out.println("Het programma wordt nu gestopt.");

    }//end of main


    public static double behandelCirkel(double radius) {
        return Math.PI * radius * radius;
    }


    public static double behandekRechthoek(double height, double width) {
        return height * width;
    }


    public static double behandelVierkant(double side) {
        return side * side;
    }


    public static double behandelDriehoek(double base, double height) {
        return 0.5 * height * base;
    }

}//end of class