package Controller;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Wat is je invoer?:");
        int input = Integer.valueOf(scanner.nextLine());

        switch (input) {
            case 1:
                System.out.println("Hier is je Mars");
                break;

            case 2:
                System.out.println("Hier is je Snickers");
                break;

            case 3:
                System.out.println("Hier zijn je M&Ms");
                break;

            default:
                System.out.println("Ongeldige keuze");

        }
    }
}
