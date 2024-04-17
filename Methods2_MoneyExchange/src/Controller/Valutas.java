package Controller;

public class Valutas {

    public static double transactie(double euros) {
        double percentageEuros = euros * 0.015;
        if (percentageEuros < 2) {
            percentageEuros = 2;
        }
        if (percentageEuros > 15) {
            percentageEuros = 15;
        }
        return percentageEuros;
    } // end of transactie



    public static double USD(double euros) {
        double usdSwap = euros * 1.23843;
        return usdSwap;
    }// end of USD

    public static double pond(double euros) {
        double pondSwap = euros * 0.88459;
        return pondSwap;

    }// end of pond

    public static double Yen(double euros) {
        double yenSwap = euros * 134.64711;
        return yenSwap;

    } //end of Yen

}
