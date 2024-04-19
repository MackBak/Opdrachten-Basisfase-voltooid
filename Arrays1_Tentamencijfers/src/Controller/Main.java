//Mack Bakkum - Een applicatie maken om docenten te helpen met het analyseren van examenresultaten.
//De docent wordt gevraagd om de cijfers, vervolgens toont het programma het aantal cijfers, gemiddelde, aantal voldoendes, & hoogste cijfer.

package Controller;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gradesAmount;

        System.out.println("Hoeveel cijfers wilt u invoeren?");
        gradesAmount = Integer.valueOf(scanner.nextLine());
        double gradesAmountDbl = 1.0 * gradesAmount;
        ArrayList<Double> gradesList = new ArrayList<Double>(gradesAmount);

        //Loop to ask the teacher for the student grades, limited to the amount he has previously stated.
        for (int i = 0; i < gradesAmount; i++) {
            System.out.println("Cijfer student " + (i + 1));
            double studentGrade = Double.valueOf(scanner.nextLine());
            gradesList.add(studentGrade);
        }

        // Loop to print all grades back to teacher.
        for (int i = 0; i < gradesAmount; i++) {
            System.out.println("Cijfer student " + (i + 1) + ": " + gradesList.get(i));
        }

        //All commands to call the methods and print the values returned.
        int totalGrades = gradesList.size();
        System.out.println("Aantal cijfers " + totalGrades);

        double averageCall = krijgGemiddelde(gradesList);
        System.out.println("Gemiddelde cijfer: " + averageCall);

        int totalPassed = krijgAntalVoldoendes(gradesList);
        System.out.println("Hoeveel voldoendes: " + totalPassed);

        double highestGradeInList = krijgHoogsteCijfer(gradesList);
        System.out.println("Hoogste cijfer: " + highestGradeInList);
    }


    public static double krijgGemiddelde(ArrayList<Double> gradesList) {
        double totalNumbers = 0.0;
        for (double grade : gradesList) {
            totalNumbers += grade;
        }
        return totalNumbers / gradesList.size();
    }

    public static int krijgAntalVoldoendes(ArrayList<Double> gradesList) {
        int totalPasses = 0;
        for (double grade : gradesList) {
            if (grade >= 5.5) {
                totalPasses++;
            }
        }
        return totalPasses;
    }

    public static double krijgHoogsteCijfer(ArrayList<Double> gradesList) {
        double highestGrade = 0;
        for (double grade : gradesList) {
            if (grade > highestGrade) {
                highestGrade = grade;
            }
        }
        return highestGrade;
    }
}


