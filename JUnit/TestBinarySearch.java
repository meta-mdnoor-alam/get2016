package Session7.JUnit;

import static org.junit.Assert.*;
import Session7.BinarySearch;

import org.junit.Before;
import org.junit.Test;

/**Class to test the functions of BinarySearch class.
 * @author Noor
 */
public class TestBinarySearch {

	BinarySearch search;
	int[] sortedArray = {1,2,3,3,3,3,7,8,9};
	int[] unsortedArray = {1,5,6,3,4,8,9,0};
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		search = new BinarySearch(sortedArray);
	}

	//function to test isArraySorted()
	@Test
	public void testIsArraySorted() {
		assertEquals(false, new BinarySearch(unsortedArray).isArraySorted());
		assertEquals(true, search.isArraySorted());
	}
	
	//function to test performBinarySearch()
	@Test
	public void testPerformBinarySearch() {
		assertEquals(2, search.performBinarySearch(3, 0, sortedArray.length-1));
	}

}
