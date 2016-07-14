package Session1.JUnit;

import static org.junit.Assert.*;
import Session1.RemoveDuplicatesFromArray;

import org.junit.Before;
import org.junit.Test;

public class TestRemoveDuplicatesFromArray {

	RemoveDuplicatesFromArray object;
	int[] input={1,2,1,5,4,2,1};
	int[] expected={1,2,5,4};
	
	@Before
	public void setUp() throws Exception {
		object=new RemoveDuplicatesFromArray();
	}

	//test function for listSearch().
	@Test
	public void testListSearch() {
		assertEquals(true, object.listSearch("1234", 3));
		assertEquals(false, object.listSearch("1234", 6));
	}
	
	//test function for removeDuplicates()
	@Test
	public void testRemoveDuplicates() {
		assertArrayEquals(expected, object.removeDuplicate(input));
	}

}
