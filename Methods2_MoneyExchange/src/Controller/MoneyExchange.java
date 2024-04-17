//Mack Bakkum - Programma wat Euro's omrekent naar buitenlandse valuta volgens de wisselkoers en een toevoeging van transactiekosten..

package Controller;
import java.util.Scanner;


public class MoneyExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("In te wisselen bedrag (alleen gehele getallen):");
        double euros = scanner.nextDouble();

        double processedEuros = Valutas.transactie(euros);

        double calculatedEuros = euros - processedEuros;

        double returnUSD = Valutas.USD(calculatedEuros);
        double returnPond = Valutas.pond(calculatedEuros);
        double returnYen = Valutas.Yen(calculatedEuros);

        System.out.println("U krijgt hier voor " + Math.round(returnUSD) + " Dollar.");
        System.out.println("U krijgt hier voor " + Math.round(returnPond) + " Pond.");
        System.out.println("U krijgt hier voor " + Math.round(returnYen) + " Yen.");

    }
}
