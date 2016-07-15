package Session2.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session2.DiamondPattern;

public class TestDiamondPattern {

	DiamondPattern object;
	int size=5;
	
	@Before
	public void setUp() throws Exception {
		object=new DiamondPattern();
	}

	//function to test getSpaces().
	@Test
	public void testGetSpaces() {
		assertEquals("", object.getSpaces(5,size));       //checking for 5th row.
		assertEquals("   ", object.getSpaces(2,size));    //checking for 2nd row.
		assertEquals("    ", object.getSpaces(9,size));   //checking for 9th row.
	}
	
	//function to test getNumber().
	@Test
	public void testGetNumber() {
		assertEquals("1", object.getNumber(1, size));      //checking for 1st row of size 5 of pyramid.
		assertEquals("121", object.getNumber(8, size));    //checking for 8th row of size 5 of pyramid.
		assertEquals("12321", object.getNumber(3, size));  //checking for 3rd row of size 5 of pyramid.
	}

	//function to test getDiamondPattern().
	@Test
	public void testGetDiamondPattern() {
		String[] expected={"    1","   121","  12321"," 1234321","123454321"," 1234321","  12321","   121","    1"};
		String[] actual=object.getDiamondPattern(size);  //getting pattern for size 5.

		assertArrayEquals(expected, actual);
	}

}
