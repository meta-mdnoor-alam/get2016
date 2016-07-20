package Session1.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Session1.Matrix;

/**To test the functions of class Matrix.
 * @author Noor
 */
public class TestMatrix {

	Matrix object;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object=new Matrix(3,3);
	}

	/**
	 * Test function for addElement().
	 */
	@Test
	public void testAddElement() {
		assertTrue(object.addElement(0, 0, 5));
	}

	/**
	 * Test function for transposeOfMatrix().
	 */
	@Test
	public void testTransposeOfMatrix() {
		int[][] actual={{1,2,3},{4,5,6},{7,8,9}};
		int[][] expected={{1,4,7},{2,5,8},{3,6,9}};
		object.matrix=actual;
		assertArrayEquals(expected, object.transposeOfMatrix().matrix);
	}
	
	/**
	 * Test function for showMatrix().
	 */
	@Test
	public void testShowMatrix() {
		int[][] actual={{1,2,3},{4,5,6},{7,8,9}};
		object.matrix=actual;
		assertEquals(5, object.showMatrix(1, 1));
	}
	
	/**
	 * Test function for matrixMultiply().
	 */
	@Test
	public void testMatrixMultiply() {
		int[][] firstMatrix={{1,2,0},{0,1,1},{2,0,1}};
		int[][] secondMatrix={{1,1,2},{2,1,1},{1,2,1}};
		int[][] expectedMatrix={{5,3,4},{3,3,2},{3,4,5}};
		
		Matrix firstMatrixObject=new Matrix(3, 3);
		Matrix secondMatrixObject=new Matrix(3, 3);
		Matrix multipliedMatrixObject=new Matrix(3, 3);
		
		firstMatrixObject.matrix=firstMatrix;
		secondMatrixObject.matrix=secondMatrix;
		
		multipliedMatrixObject=firstMatrixObject.matrixMultiply(secondMatrixObject);
		
		assertArrayEquals(expectedMatrix, multipliedMatrixObject.matrix);
	}
}












