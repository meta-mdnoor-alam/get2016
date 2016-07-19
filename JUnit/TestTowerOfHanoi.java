package Session4.JUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Session4.TowerOfHanoi;

/**To test the functions of class TowerOfHanoi.
 * @author admin
 */
@RunWith(value=Parameterized.class)
public class TestTowerOfHanoi {

	TowerOfHanoi object;
	int noOfDisk;
	List<String> expectedMovesList=new ArrayList<String>();
	List<String> actualMovesList=new ArrayList<String>();
	
	@Parameters
	public static Collection<Object []> data() {
		return  Arrays.asList(new Object[][]{{new ArrayList<String>(Arrays.asList("Move Disk 1 from A to B")),1},
											 {new ArrayList<String>(Arrays.asList("Move Disk 1 from A to C","Move Disk 2 from A to B","Move Disk 1 from C to B")),2},
											 {new ArrayList<String>(Arrays.asList("Move Disk 1 from A to B","Move Disk 2 from A to C","Move Disk 1 from B to C",
													 							  "Move Disk 3 from A to B","Move Disk 1 from C to A","Move Disk 2 from C to B",
													 							  "Move Disk 1 from A to B")),3}});
	}
	
	//Parameterized constructor to initialize the Object.
	public TestTowerOfHanoi(List<String> expectedMovesList, int noOfDisk) {
		// TODO Auto-generated constructor stub
		
		this.expectedMovesList=expectedMovesList;
		this.noOfDisk=noOfDisk;
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object=new TowerOfHanoi();
	}

	/**
	 * Test function for towerOfHanoi().
	 */
	@Test
	public void testTowerOfHanoi() {
		actualMovesList=object.towerOfHanoi("A", "B", "C", noOfDisk);
		
		assertEquals(expectedMovesList, actualMovesList);
		
		actualMovesList.clear(); //to clear the actual list
	}

}
