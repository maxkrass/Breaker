/**
 * Created for Breaker by Max on 14.11.2016.
 */
public class Fraction {

	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	int getNumerator() {
		return numerator;
	}

	int getDenominator() {
		return denominator;
	}

	void extend(int n) {
		denominator *= n;
		numerator *= n;
	}

	void reduce() {
		for (int i = Math.max(numerator, denominator); i > 1; i--) {
			if ((denominator % i == 0) && (numerator % i == 0)) {
				denominator /= i;
				numerator /= i;
				System.out.println("gekürzt mit " + i);
				reduce();
			}
		}
		System.out.println(denominator);
		System.out.println("-");
		System.out.println(numerator);
	}
}
