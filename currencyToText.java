

import java.util.*;
import java.io.*;
public class currencyToText
{
	private static final String EMPTY = "";
	// When number is between 1 to 19
	private static final String[] X ={ EMPTY, "One", "Two", "Three", "Four", "Five", "Six",
	"Seven ", "Eight ", "Nine", "Ten", "Eleven","Twelve",
	"Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ",
	"Seventeen", "Eighteen ", "Nineteen "};

	// For number 20 and above it for a prefix
	private static final String[] Y = {EMPTY, EMPTY, "Twenty ", "Thirty ", "Forty ", "Fifty ",
	"Sixty ", "Seventy ", "Eighty ", "Ninety " };

	private static String convertToDigit(int n, String suffix)
	{
		if (n == 0)
			return EMPTY;

		if (n > 19)
			return Y[n / 10] + X[n % 10] + suffix;

		else
			return X[n] + suffix;
	}

	public static String convert(int n, int fractional)
	{
		if(n == 0 & fractional == 0 ) // when number and fraction both are zero
			return("Rs. Zero Only");

		else if( n < 0 ) //for Minus values as we are talking currency
			return("Negative Numbers not allowed");

		/*  because the limit is 999999.99,
			We can simply remove this  else if section below to extend the limit */

		else if ( n > 999999.99 )
			return(" Reached Max Value");


		StringBuilder res = new StringBuilder();
		res.append(convertToDigit(((n / 100000) % 100), " Lakh, "));
		res.append(convertToDigit(((n / 1000) % 100), " Thousand "));
		res.append(convertToDigit(((n / 100) % 10), " Hundred "));

		if ((n > 100) && (n % 100 != 0))
		{
			res.append("and ");
		}

		res.append(convertToDigit((n % 100), ""));
		String word = res.toString();

		String temp;
			if (fractional == 0)
				//when there is no fraction used, we don't need "fractional/100" See the below statement
				temp = (" Rs.  " + word + " Only" ) ;

			else
				temp = (" Rs. " + word  + " " + fractional + "/100" + " only");

			return temp;
	}

		public static void main(String[] args)
		{
			Double doubleValue; // value to get from user
			int n; // to save the non fractional value from the given input

			System.out.println("\nEnter a number : ");
			Scanner sc = new Scanner(System.in);
			doubleValue = sc.nextDouble();

			//When number is Zero we do not need the whole program to run in the below statement

			String numberStr = Double.toString(doubleValue);
			String fractionalStr = numberStr.substring(numberStr.indexOf('.')+1);
			int fractional = Integer.valueOf(fractionalStr);
			n = (int)Math.round(doubleValue);

			/* we use the Math.round method to get the number before the fraction,
			as it will round up the integer, if fraction is above 50 We use the bellow statement
			 to get the original number */

			if (fractional <= 9)
				fractional = fractional * 10;

			if (fractional >= 50)
				n = n - 1;

			String temp = convert(n,fractional);
			System.out.println(temp);

		}
}


