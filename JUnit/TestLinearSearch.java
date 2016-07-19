package Session3.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session3.LinearSearch;

/**To test the functions of class LinearSearch
 * @author Noor
 */
public class TestLinearSearch {

	LinearSearch object;
	int[] input={2,5,8,9,10,77,55,11};
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object=new LinearSearch();
	}

	/**
	 * test function for searchElement()
	 */
	@Test
	public void testSearchElement() {
		assertEquals(-1, object.searchElement(input, 0, 7, 88));
		assertEquals(5, object.searchElement(input, 0, 7, 77));
	}
}