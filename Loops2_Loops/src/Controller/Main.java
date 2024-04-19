package Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        toonRijSterren(8);

        System.out.println(); //empty line for clearer division between tasks.
        System.out.println(); //empty line for clearer division between tasks.

        toonSterrenVierkant(6);

        System.out.println(); //empty line for clearer division between tasks.

        System.out.println("Welk karakter wil je dit keer gebruiken?");
        String userString = scanner.nextLine();
        char userChar = userString.charAt(0);
        System.out.println("Hoe vaak wil je het zien?");
        int amount = Integer.valueOf(scanner.nextLine());
        toonCharRij(userChar, amount);

        System.out.println();//empty line for clearer division between tasks.

        tot1000(1);

        System.out.println();//empty line for clearer division between tasks.

        System.out.print("Geef een bovengetal:");
        int userGetalInput = Integer.valueOf(scanner.nextLine());
        int gettallenVoorInput = telAantalTeSommerenGetallen(userGetalInput);
        System.out.println("De eerste " + (gettallenVoorInput - 1) + " getallen zijn net geen " + userGetalInput + ".");

    }//end of main


    public static void toonRijSterren(int mpAantal) {
        for (int i = 1; i < mpAantal; i++) {
            System.out.print("* ");
        }
    }


    public static void toonSterrenVierkant(int mpAantal) {
        for (int i = 1; i <= mpAantal; i++) {
            for (int j = 1; j <= mpAantal; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static void toonCharRij(char mpKarakter, int mpAantal) {
        for (int i = 1; i <= mpAantal; i++) {
            System.out.print(mpKarakter);
        }
    }


    public static void tot1000(int number) {
        int i = 1;
        int sum = 0;
        int totalSum = 0;
        int amountOfNumbers = 0;

        while (totalSum < 1000) {
            sum = sum + 1;
            totalSum = totalSum + sum;
            System.out.println(totalSum + " Opgetelde nummer.");
            amountOfNumbers++;
            i++;
            System.out.println(amountOfNumbers + " <-- Hoeveelheid nummers opgeteld in totaal.");
        }
    }


    public static int telAantalTeSommerenGetallen(int mpGrens) {
        int start = 1;
        int sumGetal = 0;
        int totalSumGetal = 0;
        int amountOfNumbersGetal = 0;

        while (totalSumGetal < mpGrens) {
            sumGetal = sumGetal + 1;
            totalSumGetal = totalSumGetal + sumGetal;
            amountOfNumbersGetal++;
            start++;

        }
        return amountOfNumbersGetal;
    }
}//end of class

