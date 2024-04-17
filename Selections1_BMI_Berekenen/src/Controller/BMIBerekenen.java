package Controller;
import java.util.Scanner;

public class BMIBerekenen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geef je lengte in CM:");
        int height = Integer.parseInt(scanner.nextLine());

        System.out.print("Geef je gewicht in KG:");
        double weight = Double.parseDouble(scanner.nextLine());

        double bmi = (10000 * weight / (height * height));

        System.out.println(bmi);

        if (bmi < 25.0) {
            System.out.println("Je bent op goed gewicht.");
        } else {
            System.out.println("Je bent te zwaar");
        }
    }
}
