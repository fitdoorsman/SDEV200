import java.math.BigInteger;

public class Rational {
    private BigInteger numerator;
    private BigInteger denominator;

    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);

        // Keep denominator positive
        if (this.denominator.compareTo(BigInteger.ZERO) < 0) {
            this.numerator = this.numerator.negate();
            this.denominator = this.denominator.negate();
        }
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public Rational add(Rational r) {
        BigInteger num = numerator.multiply(r.getDenominator()).add(
                         denominator.multiply(r.getNumerator()));
        BigInteger den = denominator.multiply(r.getDenominator());
        return new Rational(num, den);
    }

    public Rational subtract(Rational r) {
        BigInteger num = numerator.multiply(r.getDenominator()).subtract(
                         denominator.multiply(r.getNumerator()));
        BigInteger den = denominator.multiply(r.getDenominator());
        return new Rational(num, den);
    }

    public Rational multiply(Rational r) {
        return new Rational(numerator.multiply(r.getNumerator()),
                            denominator.multiply(r.getDenominator()));
    }

    public Rational divide(Rational r) {
        return new Rational(numerator.multiply(r.getDenominator()),
                            denominator.multiply(r.getNumerator()));
    }

    public double toDouble() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator.toString();
        else
            return numerator + "/" + denominator;
    }
}
