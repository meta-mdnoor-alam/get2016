package Session4.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session4.NQueensProblem;

/**To test the functions of class NQueensProblem
 * @author Noor
 */
public class TestNQueensProblem {

	NQueensProblem object;
	int[][] initialMatrixBoard={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	int[][] expectedMatrixBoard={{0,1,0,0},{0,0,0,1},{1,0,0,0},{0,0,1,0}};
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object=new NQueensProblem();
	}

	/**
	 * Function to test canPlaceQueen()
	 */
	@Test
	public void testCanPlaceQueen() {
		assertEquals(true, object.canPlaceQueen(initialMatrixBoard, 0, 0));
	}
	
	/**
	 * Function to test nQueen()
	 */
	@Test
	public void testNQueen() {
		assertEquals(true, object.nQueen(initialMatrixBoard, 0, 4));
	}
	
	/**
	 * Function to test showSolutionNQueen()
	 */
	@Test
	public void testShowSolutionNQueen() {
		assertArrayEquals(expectedMatrixBoard, object.showSolutionNQueen(initialMatrixBoard, 0, 4));
	}
}