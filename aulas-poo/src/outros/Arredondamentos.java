package outros;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Arredondamentos {

	public static void main(String[] args) {

		// https://www.baeldung.com/java-round-decimal-number
		// Java provides two primitive types that can be used for storing decimal
		// numbers: float and double. Double is the type used by default:

		double PI = 3.1415;

		// However, both types should never be used for precise values, such as
		// currencies. For that, and also for rounding, we can use the BigDecimal class.
		// If we just want to print a decimal number with n digits after decimal point,
		// we can simply format the output String:

		System.out.printf("Value with 3 digits after decimal point %.3f %n", PI);

		// Alternatively, we can format the value with the DecimalFormat class:

		DecimalFormat df = new DecimalFormat("###.###");
		System.out.println(df.format(PI));

		// DecimalFormat allows us to explicitly set rounding behavior, giving more
		// control of the output than String.format() used above.

		System.out.println(round(PI, 3));
	}
	// Rounding Doubles With BigDecimal

	// To round doubles to n decimal places, we can write a helper method:

	private static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	// There is one important thing to notice in this solution – when constructing
	// BigDecimal; we must always use BigDecimal(String) constructor. This prevents
	// issues with representing inexact values.

}
