//Mack Bakkum - Een programma waarin de student cijfers kan invoeren, studiepunten kan zien, en vervolgens kan zien of hij/zij on track is om te slagen.

package Controller;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] vakNamen = {"Project Fasten Your Seatbelts", "Programming", "Databases", "Personal Skills", "Project Skills", "OOP1", "User Interaction"};
        int[] vakPunten = {12, 3, 3, 2, 2, 3, 3};
        double[] vakCijfers = new double[vakNamen.length];

        int totalPunten = bepaalTotaalPunten(vakPunten);
        System.out.println(totalPunten);

        //Loop en invoer voor de cijfers van het semester.
        System.out.println("Voer behaalde cijfers in:");
        for (int i = 0; i < vakNamen.length; i++) {
            System.out.println(vakNamen[i] + ": ");
            double grade;

            do {
                grade = scanner.nextDouble();
                if (grade <= 1.0 || grade > 10.0) {
                    System.out.println("Ongeldig! Cijfer moet tussen 1 & 10.");
                }
            } while (grade <= 1.0 || grade >= 10.0);
            vakCijfers[i] = grade;
        }

        //For loop die zorgt dat alle onvoldoendes geen studiepunten geven.
        for (int i = 0; i < vakCijfers.length; i++) {
            double minGrade = 5.5;
            if (vakCijfers[i] < 5.5) {
                vakPunten[i] = 0;
            }
        }

        //Roept de methode op om op te halen of de totale punten zijn behaald.
        int finalSumGrades = bepaalTotaalPunten(vakPunten);
        //System.out.println("Totale punten behaald " + finalSumGrades); <-- Gebruikt om te testen


        //Print alle vaknamen en bijbehorende cijfers/puntens geformat. Met %-35s start het links en worden er altijd 35 spaties gebruikt. Met 10 en 3 het zelfde alleen een kleiner getal.
        for (int i = 0; i < vakNamen.length; i++) {
            System.out.printf("Vak/project: %-35s Cijfer: %-10.1f Behaalde punten: %-3d\n", vakNamen[i], vakCijfers[i], vakPunten[i]);
        }


        //De laatste print om de studiepunten te printen en percentueel te bepalen of de student voldoende op weg is.
        System.out.println("Totaal behaalde studiepunten: " + finalSumGrades);
        double percentageNeeded = (6 / 5) * 5;
        if (finalSumGrades < (percentageNeeded * totalPunten)) {
            System.out.println("Je ligt op schema voor een negatief BSA");
        } else {
            System.out.println("Je ligt op schema voor een positief BSA");
        }

    } //end of Main



    public static int bepaalTotaalPunten(int[] mpPuntenRij) {
        int sumGrades = 0;
        for (int i = 0; i < mpPuntenRij.length; i++) {
            sumGrades = sumGrades + mpPuntenRij[i];
        }
        return sumGrades;
    }

}// end of Class
