package Session1.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session1.ArraySortedCheck;

public class TestArraySortedCheck {

	ArraySortedCheck check;
	int[] ascArray={1,2,3,4,5,6};
	int[] decArray={10,9,5,4,3};
	int[] unSorted={10,9,7,14,15};
	
	@Before
	public void setUp() throws Exception {
		check=new ArraySortedCheck();
	}

	//test function for checkArray().
	@Test
	public void testCheckArray() {
		assertEquals(1, check.checkArray(ascArray));
		assertEquals(2, check.checkArray(decArray));
		assertEquals(0, check.checkArray(unSorted));
	}
	
	//test function for checkArrayAscending().
	@Test
	public void testCheckArrayAscending() {
		assertEquals(true, check.checkArrayAscending(ascArray));
		assertEquals(false, check.checkArrayAscending(decArray));
	}
	
	//test function for checkArrayDescending().
	@Test
	public void testCheckArrayDescending() {
		assertEquals(false, check.checkArrayDescending(ascArray));
		assertEquals(true, check.checkArrayDescending(decArray));
	}
}
