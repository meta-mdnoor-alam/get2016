package Session3.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session3.FindRemainder;

/** To test the functions of FindRemainder class.
 *  @author Noor
 */
public class TestFindRemainder {

	FindRemainder object;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object=new FindRemainder();
	}

	/**
	 * test function to handle invalid input by the user.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testHandlingIllegalException() {
		assertEquals(-1, object.getRemainder(2, 0));
	}
	
	/**
	 * test function for getRemainder().
	 */
	@Test
	public void testGetRemainder() {
		assertEquals(0, object.getRemainder(2, 1));
		assertEquals(1, object.getRemainder(100, 3));
	}

}
