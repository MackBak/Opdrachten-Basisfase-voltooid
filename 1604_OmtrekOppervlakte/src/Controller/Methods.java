package Controller;

public class Methods {

    public static void cirkel(double diameter) {

        double omtrek = Math.PI * diameter;
        double straal = diameter / 2;
        double oppervlakte = Math.PI * straal * straal;

        System.out.printf("De omtrek van je cirkel is: %.2f\n", omtrek);
        System.out.printf("De oppervlakte van je cirkel is: %.2f\n", oppervlakte);
    }//end of cirkel

    public static void driehoek(double lengte, double breedte) {

        double omtrek = 2 * (lengte + breedte);
        double oppervlakte = 0.5 * lengte * breedte;

        System.out.printf("De omtrek van je driehoek is: %.2f\n", omtrek);
        System.out.printf("De oppervlakte van je driehoek is: %.2f\n", oppervlakte);
    }//end of driehoek
}