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

import Session4.StringPermutation;

/**To test the functions of class StringPermutation.
 * @author Noor
 */
@RunWith(value=Parameterized.class)
public class TestStringPermutation {

	StringPermutation object;
	static StringBuffer stringABC=new StringBuffer("ABC");
	static StringBuffer stringABCD=new StringBuffer("ABCD");
	StringBuffer inputString=new StringBuffer();
	List<String> expectedPermutationList=new ArrayList<String>();
	List<String> actualPermutationList=new ArrayList<String>();
	StringBuffer actualUnswappedString=new StringBuffer("ABCD");
	StringBuffer expectedSwappedString=new StringBuffer("ACBD");
	int startIndex;
	int endIndex;
	
	@Parameters
	public static Collection<Object []> data() {
		return Arrays.asList(new Object[][]{{new ArrayList<String>(Arrays.asList("ABC","ACB","BAC","BCA","CBA","CAB")),stringABC,0,2},
											{new ArrayList<String>(Arrays.asList("ABCD","ABDC","ACBD","ACDB","ADCB","ADBC","BACD","BADC","BCAD","BCDA","BDCA","BDAC","CBAD",
																				 "CBDA","CABD","CADB","CDAB","CDBA","DBCA","DBAC","DCBA","DCAB","DACB","DABC")),stringABCD,0,3}});
	}
	
	//Parameterized constructor to initialize the Object.
	public TestStringPermutation(List<String> expectedPermutationList, StringBuffer inputString, int startIndex, int endIndex) {
		// TODO Auto-generated constructor stub

		this.expectedPermutationList=expectedPermutationList;
		this.inputString=inputString;
		this.startIndex=startIndex;
		this.endIndex=endIndex;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		object=new StringPermutation();
	}

	/**
	 * Test function for swapStringCharacters().
	 */
	@Test
	public void testSwapStringCharacters() {
		assertEquals(expectedSwappedString.toString(), object.swapStringCharacters(actualUnswappedString, 1, 2).toString());
	}
	
	/**
	 * Test function for genratePermutationOfString().
	 */
	@Test
	public void testGeneratePermutationOfString() {
		actualPermutationList=object.generatePermutationOfString(inputString, startIndex, endIndex);
		
		assertEquals(expectedPermutationList, actualPermutationList);
		
		actualPermutationList.clear();
	}

}
