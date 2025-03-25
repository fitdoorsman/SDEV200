public class Exercise06_09 {

    /** Convert from feet to meters */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter) {
        return 3.2787 * meter;
    }

    public static void main(String[] args) {
        System.out.println("Feet    Meters    |    Meters    Feet");
        System.out.println("-----------------+--------------------");

        for (int i = 1, j = 20; i <= 10; i++, j += 5) {
            double feet = i;
            double meters = j;
            System.out.printf("%-7.1f %-9.3f |    %-9.1f %-7.3f\n",
                feet, footToMeter(feet),
                meters, meterToFoot(meters));
        }
    }
}
