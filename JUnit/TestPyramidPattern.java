package Session2.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session2.PyramidPattern;

public class TestPyramidPattern {

	PyramidPattern object;
	int size=5;
	
	@Before
	public void setUp() throws Exception {
		object=new PyramidPattern();
	}

	//function to test getSpaces().
	@Test
	public void testGetSpaces() {
		assertEquals("    ", object.getSpaces(5)); //checking for 5th row.
		assertEquals("   ", object.getSpaces(4));  //checking for 4th row.
		assertEquals("  ", object.getSpaces(3));   //checking for 3rd row.
	}
	
	//function to test getNumber().
	@Test
	public void testGetNumber() {
		assertEquals("12345", object.getNumber(1, size));  //checking for 1st row of size 5 of pyramid.
		assertEquals("1234", object.getNumber(2, size));   //checking for 2nd row of size 5 of pyramid.
		assertEquals("123", object.getNumber(3, size));    //checking for 3rd row of size 5 of pyramid.
	}
	
	//function to test getPyramidPattern().
	@Test
	public void testGetPyramidPattern() {
		String[] expected={"12345"," 1234","  123","   12","    1"};
		String[] actual=object.getPyramidPattern(size);  //getting pattern for size 5.
		
		assertArrayEquals(expected, actual);
	}

}
