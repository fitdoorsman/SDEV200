import java.math.BigInteger;
import java.util.Scanner;

public class TestRational {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input r1
        System.out.print("Enter rational r1 with numerator and denominator separated by a space: ");
        BigInteger num1 = input.nextBigInteger();
        BigInteger den1 = input.nextBigInteger();
        Rational r1 = new Rational(num1, den1);

        // Input r2
        System.out.print("Enter rational r2 with numerator and denominator separated by a space: ");
        BigInteger num2 = input.nextBigInteger();
        BigInteger den2 = input.nextBigInteger();
        Rational r2 = new Rational(num2, den2);

        // Display results
        System.out.println("r1 is " + r1);
        System.out.println("r2 is " + r2);
        System.out.println("r1 + r2 = " + r1.add(r2));
        System.out.println("r1 - r2 = " + r1.subtract(r2));
        System.out.println("r1 * r2 = " + r1.multiply(r2));
        System.out.println("r1 / r2 = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.toDouble());
    }
}
