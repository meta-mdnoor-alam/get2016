package Session3.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session3.GreatestCommonDivisor;

/**
 * To test the functions of GreatestCommonDivisor class.
 * @author Noor
 */
public class TestGreatestCommonDivisor {

	GreatestCommonDivisor object;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object=new GreatestCommonDivisor();
	}

	/**
	 * test function to handle invalid input by the user.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testHandleInvalidInput() {
		assertEquals(-1, object.findGCD(7, -1));
	}
	
	/**
	 * test function for findGCD()
	 */
	@Test
	public void testFindGCD() {
		assertEquals(1, object.findGCD(2, 1));
		assertEquals(6, object.findGCD(12, 18));
		assertEquals(1, object.findGCD(100, 3));
	}
}