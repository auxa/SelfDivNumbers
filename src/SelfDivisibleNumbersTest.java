import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class SelfDivisibleNumbersTest {

	static SelfDivisibleNumbers sdn;
	@BeforeClass
	public static void oneTimeSetUp() throws Exception { 
		sdn = new SelfDivisibleNumbers();
	}
	
	@Test
	public void constructorTest() {
		assertNotNull("Checking the constructor",sdn);
	}
	@Test
	public void testDivise() {
		assertEquals("checking if compare works", true, sdn.isDivisible(11, 1));
		assertEquals("check when it should not work", false , sdn.isDivisible(34, 3));
	}
	@Test
	public void testSize() {
		assertEquals("checking quantity of sqaures", 1, sdn.getNumberOfSelfDivisibleNumbers()); 
	}
	int[] temp = {1,2, 4,5,6};
	@Test
	public void testcheckingmethod() {
		assertEquals("checking number of sqaures", 124, sdn.getFirstKDigitNumber(temp, 3));
	}
}