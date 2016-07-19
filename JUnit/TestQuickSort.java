package Session3.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session3.QuickSort;

/**To test the functions of the class QuickSort.
 * @author Noor
 */
public class TestQuickSort {

	QuickSort object;
	int[] inputArray={2,5,8,9,10,77,55,11};
	int[] inputEmptyArray={};
	int[] expectedSwappedElementArray={2,5,8,9,11,77,55,10};
	int[] expectedSortedArray={2,5,8,9,10,11,55,77};
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object=new QuickSort();
	}

	/**
	 * Test function to handle empty array as input. 
	 */
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testHandleEmptyArrayInput() {
		assertEquals(-1, object.quickSort(inputEmptyArray, 0, 0));
	}
	
	/**
	 * Test function for swapArrayElements().
	 */
	@Test
	public void testSwapArrayElements() {
		assertArrayEquals(expectedSwappedElementArray, object.swapArrayElements(inputArray, 4, 7));
	}

	/**
	 * Test function for partition().
	 */
	@Test
	public void testPartition() {
		assertEquals(5, object.partition(inputArray, 0, 7));
	}
	
	/**
	 * Test function for quickSort().
	 */
	@Test
	public void testQuickSort() {
		assertArrayEquals(expectedSortedArray, object.quickSort(inputArray, 0, 7));
	}
	
}

































