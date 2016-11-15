/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class FractionTools {

	Fraction add(Fraction fraction1, Fraction fraction2) {

		normalize(fraction1, fraction2);
		Fraction result = new Fraction(fraction1.getNumerator() + fraction2.getNumerator(), fraction1.getDenominator());
		result.reduce();

		return result;

	}

	Fraction subtract(Fraction fraction1, Fraction fraction2) {

		normalize(fraction1, fraction2);
		Fraction result = new Fraction(fraction1.getNumerator() - fraction2.getNumerator(), fraction1.getDenominator());
		result.reduce();

		return result;

	}

	Fraction multiply(Fraction fraction1, Fraction fraction2) {

		Fraction result = new Fraction(fraction1.getNumerator() * fraction2.getNumerator(), fraction1.getDenominator() * fraction2.getDenominator());
		result.reduce();

		return result;

	}

	Fraction divide(Fraction fraction1, Fraction fraction2) {

		Fraction result = new Fraction(fraction1.getNumerator() * fraction2.getDenominator(), fraction1.getDenominator() * fraction2.getNumerator());
		result.reduce();

		return result;

	}

	// erweitert immer n1*n2
	private void normalize(Fraction fraction1, Fraction fraction2) {
		if (fraction1.getDenominator() != fraction2.getDenominator()) {
			int d1 = fraction1.getDenominator();
			int d2 = fraction2.getDenominator();
			fraction1.extend(d2);
			fraction2.extend(d1);
		}
	}
}
