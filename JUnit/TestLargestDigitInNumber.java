package Session3.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session3.LargestDigitInNumber;

/**To test the functions of class LargestDigitInNumber
 * @author Noor
 */
public class TestLargestDigitInNumber {

	LargestDigitInNumber object;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object=new LargestDigitInNumber();
	}

	/**
	 * Function to handle invalid input by the user.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testHandleInvalidInput() {
		assertEquals(-1, object.getLargestDigit(-25));
	}
	
	/**
	 * Test function for findMaximun()
	 */
	@Test
	public void testFindMaximum() {
		assertEquals(30, object.findMaximun(30, 25));
	}
	
	/**
	 * Test function for getLargestDigit()
	 */
	@Test
	public void testGetLargestDigit() {
		assertEquals(2, object.getLargestDigit(2));
		assertEquals(9, object.getLargestDigit(1257369));
		assertEquals(4, object.getLargestDigit(444));
	}
}
