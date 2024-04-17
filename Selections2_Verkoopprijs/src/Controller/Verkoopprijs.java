//Mack Bakkum
//Een applicatie die de verkoopprijs berekent van een product.

package Controller;

import java.util.Scanner;

public class Verkoopprijs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inkoopprijs:");
        double inkoopPrijs = scanner.nextDouble();

        System.out.println("Winstmarge in %:");
        double winstmarge = scanner.nextDouble();

        double totalSum = inkoopPrijs + (inkoopPrijs * (0.01 * winstmarge));

        System.out.println("Verkoopprijs exclusief BTW: " + totalSum);

        System.out.println("Onder welk BTW-tarief valt het product?");
        System.out.println("1 - Hoog");
        System.out.println("2 - Laag");
        System.out.print("Geef je keuze");
        int btwTarief = scanner.nextInt();

        if (btwTarief == 1) {
            double finalPrice = totalSum + (totalSum * (0.01 * 21));
            System.out.println("Verkoopprijs inclusief 21% BTW: " + finalPrice);
        } else if (btwTarief == 2) {
            double finalPrice = totalSum + (totalSum * (0.01 * 9));
            System.out.println("Verkoopprijs inclusief 9% BTW: " + finalPrice);
        } else {
            System.out.println("Ongeldige input");
        }
    }
}