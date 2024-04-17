package controller;
import java.util.Scanner;
import java.time.*;


public class LeeftijdBerekeningLauncher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Year thisYear = Year.now();
        int yearNow = thisYear.getValue();

        System.out.print("Hoe heet je?");
        String name = scanner.nextLine();

        System.out.print("Wat is je geboortejaar?");
        int birthYear = Integer.parseInt(scanner.nextLine());

       System.out.println("Beste " + name + ", eind " + yearNow + " zal je leeftijd " + (yearNow - birthYear) + " zijn.");
    }
}
