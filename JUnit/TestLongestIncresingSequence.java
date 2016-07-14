package Session1.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session1.LongestIncreasingSequence;

public class TestLongestIncresingSequence {

	LongestIncreasingSequence object;
	int[] actual={1,2,3,1,4,5,7};
	int[] expected={1,4,5,7};
	
	@Before
	public void setUp() throws Exception {
		object=new LongestIncreasingSequence();
	}

	//test function for longestSequence().
	@Test
	public void testGetLongestSequence() {
		assertArrayEquals(expected, object.getLongestSequence(actual));
	}

}
