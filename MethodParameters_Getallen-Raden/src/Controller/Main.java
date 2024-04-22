//Mack Bakkum

package Controller;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Generating the 3 random numbers with method genereerGetallen. Then establishing the counters for correct and amount of guesses.
        int[] threeRNG = genereerGetallen();
        int amountCorrect = 0;
        int amountGuesses = 1;

        //-----USE FOR LOOP BELOW TO PRINT THE RANDOM NUMBERS FOR TESTING THE PROGRAM-----
    /*    for (int i = 0; i < threeRNG.length; i++) {
            System.out.println(threeRNG[i]);
        }

     */

        //While loop to repeat the question and store the answer if the 3 numbers were not correct.
        //2 Arrays are created, 1 for a String which will store the answer. 1 for Integers which will be converted from the String.
        while (amountCorrect < 3) {
            System.out.print("Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties:");
            String userNubersString = scanner.nextLine();
            String[] userNumbersStringArray = userNubersString.split(" ");
            int[] userNumbersIntArray = new int[userNumbersStringArray.length];

            //For loop convert the String to Integers.
            for (int i = 0; i < userNumbersStringArray.length; i++) {
                userNumbersIntArray[i] = Integer.parseInt(userNumbersStringArray[i]);
            }

            //Setting amountCorrect to 0 before it's checked every time in the loop.
            amountCorrect = 0;
            for (int i = 0; i < userNumbersIntArray.length; i++) {
                boolean trueOrNot = komtVoorIn(userNumbersIntArray[i], threeRNG);
                if (trueOrNot == true) {
                    amountCorrect++;
                }
            }

            //If 3 numbers are not guessed correctly the amount of guesses go up and the loop restarts.
            if (amountCorrect < 3) {
                System.out.println("Aantal correcte getallen = " + amountCorrect);
                amountGuesses++;
            }
        }

        //Final print with the results.
        System.out.println("\nU heeft " + amountGuesses + " keer geraden.");
        System.out.print("De te raden getallen waren:");
        for (int i = 0; i < 3; i++) {
            System.out.print(threeRNG[i] + " ");
        }
    } //end of Main


    public static int[] genereerGetallen() {
        Random random = new Random();
        int firstNumber = random.nextInt(9) + 1;
        int secondNumber = random.nextInt(9) + 1;
        int thirdNumber = random.nextInt(9) + 1;
        while (secondNumber == firstNumber || secondNumber == thirdNumber || thirdNumber == firstNumber) {
            secondNumber = random.nextInt(9) + 1;
            thirdNumber = random.nextInt(9) + 1;
        }
        return new int[]{firstNumber, secondNumber, thirdNumber};
    }

    public static boolean komtVoorIn(int mpZoekgetal, int[] mpLijst) {
        for (int i = 0; i < mpLijst.length; i++) {
            if (mpLijst[i] == mpZoekgetal) {
                return true;
            }
        }
        return false;
    }
}//end of class