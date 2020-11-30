package currencyToText;

import static org.junit.Assert.*;
import currencyToText.currencyToText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class currencyToTextTest {

	//you will need to give fraction separated by comma( , ) as the method will take 2 parameters
	
	@Test
	    public void Integer() throws Exception {
	       String result = currencyToText.convert(12345,0);
	       assertThat(result, is(" Rs.  Twelve Thousand Three Hundred and Forty Five Only"));
	 }
	 @Test
	    public void OnlyFraction() throws Exception {
		 	String resultForZero = currencyToText.convert(0,20);
	    	assertThat(resultForZero, is(" Rs.  20/100 only"));
	 }
	 @Test
	    public void Zero() throws Exception {
		 	String resultForZero = currencyToText.convert(0,0);
	    	assertThat(resultForZero, is("Rs. Zero Only"));
	 } 
	 
	 @Test
	 public void MinusValue() throws Exception {
		 	String resultForZero = currencyToText.convert(-12,0);
	    	assertThat(resultForZero, is("Negative Numbers not allowed"));
	 }
	 @Test
	 public void Double() throws Exception {
	       String result = currencyToText.convert(12345,54);
	       assertThat(result, is(" Rs. Twelve Thousand Three Hundred and Forty Five 54/100 only"));
	 }
	 @Test
	 public void MaxLim() throws Exception {
	       String result = currencyToText.convert(1000000,0);
	       assertThat(result, is(" Reached Max Value"));
	 }	 
	 
	/* Note :  As the currencyToText.convert() takes integer only 
	 * 	there is no need to check string and special character inputs 
	 * as it will give compilation errors */
}
