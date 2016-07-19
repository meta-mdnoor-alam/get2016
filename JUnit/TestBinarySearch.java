package Session3.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session3.BinarySearch;

/**To test the functions of the class BinarySearch.
 * @author Noor
 */
public class TestBinarySearch {

	BinarySearch object;
	int[] input={2,5,8,9,10,55,77};
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object=new BinarySearch();
	}

	/**
	 * test function for searchElement()
	 */
	@Test
	public void testSearchElement() {
		assertEquals(-1, object.searchElement(input, 0, 6, 88));
		assertEquals(6, object.searchElement(input, 0, 6, 77));
	}

}
