package Session1.JUnit;

import static org.junit.Assert.*;

import Session1.*;

import org.junit.Before;
import org.junit.Test;

public class TestBinaryConversion {

	BinaryConversion convert;
	
	//setUp() to initialize the object.
	@Before
	public void setUp() throws Exception {
		convert=new BinaryConversion();
	}

	//test function for convertBinaryToOctal().
	@Test
	public void testConvertBinaryToOctal() { 
		assertEquals(15, convert.convertBinaryToOctal(1101));
		assertEquals(35, convert.convertBinaryToOctal(11101));
		assertEquals(13, convert.convertBinaryToOctal(1011));
		assertEquals(33, convert.convertBinaryToOctal(11011));
		assertEquals(26, convert.convertBinaryToOctal(10110));
	}
	
	//test function for getBinToDec().
	@Test
	public void testGetBinToOctal() {
		assertEquals(7, convert.getBinToDec("111"));
	}

}
