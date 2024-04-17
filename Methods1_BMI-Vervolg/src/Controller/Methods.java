package Controller;

public class Methods {

    public static double berekenBMI(int mpLengte, double mpGewicht) {

        double lengteMeters = (double) mpLengte / 100;
        double bmiResult = mpGewicht / Math.pow(lengteMeters, 2);
        double roundedNumber = Math.round(bmiResult * 10.0) / 10.0;

        return roundedNumber;
    }
}