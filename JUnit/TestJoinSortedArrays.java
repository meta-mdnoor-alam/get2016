package Session1.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

import Session1.JoinSortedArrays;

public class TestJoinSortedArrays {

	JoinSortedArrays object;
	int[] aActual={1,5,10,12,15};
	int[] bActual={2,3,7,11,20,25,30};
	int[] resultant=new int[aActual.length+bActual.length];
	int[] expected={1,2,3,5,7,10,11,12,15,20,25,30};
	
	@Before
	public void setUp() throws Exception {
		object=new JoinSortedArrays();
	}
	
	//function to check whether the expected result is same as given by join().
	boolean checkAssert(int[] input1, int[] input2) {
		if (Arrays.equals(expected, object.join(input1, input1.length, input2, input2.length, resultant))) {
			return true;
		}
		return false;
	}

	//test function for join().
	@Test
	public void testJoin() {
		assertEquals(true, checkAssert(aActual, bActual));
	}

}
