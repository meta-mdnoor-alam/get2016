package Session1.JUnit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import Session1.FirstComeFirstServe;

public class TestFirstComeFirstServe {

	FirstComeFirstServe object;
	
	@Before
	public void setUp() throws Exception {
		object=new FirstComeFirstServe();
	}
	
	//function to check whether expected array is equal to actual array or not.
	boolean isArrayEqual(int expected[][], int actual[][]) {
		for (int i = 0; i < 4; i++) {
			if(!Arrays.equals(expected[i], actual[i])) {
				return false;
			}
		}
		return true;
	}

	//test function for getFCFS().
	@Test
	public void testGetFCFS() {
		int[] arrivalTime={1,5,9,25};
		int[] jobSize={12,7,2,5};
		int expected[][]={{1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
		int actual[][]=object.getFCFS(arrivalTime, jobSize);
		assertEquals(true, isArrayEqual(expected, actual));		
	}

}
