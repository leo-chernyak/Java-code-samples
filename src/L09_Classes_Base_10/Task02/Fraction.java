package L09_Classes_Base_10.Task02;

public class Fraction {
    int denominator; // знаменатель
    int divisor; // делитель
    Fraction(int denominator, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("The divisor can't be a zero: " + divisor);
        this.denominator = denominator;
        this.divisor = divisor;
    }

    public Fraction add(Fraction fraction) {
        return new Fraction(denominator * fraction.divisor + fraction.denominator * divisor, divisor * fraction.divisor);
    }

    public Fraction subtract(Fraction fraction) {
        return new Fraction(denominator * fraction.divisor - fraction.denominator * divisor, Math.abs(divisor) * Math.abs(fraction.divisor));
    }

    public Fraction multiply(Fraction fraction) {
        return new Fraction(denominator*fraction.denominator, divisor*fraction.divisor);
    }

    public Fraction devide(Fraction fraction) {
        return multiply(new Fraction(fraction.divisor, fraction.denominator));
    }

    @Override
    public String  toString() {
        return denominator + " / " + divisor;
    }
}
