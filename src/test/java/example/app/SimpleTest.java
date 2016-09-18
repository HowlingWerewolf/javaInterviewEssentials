package example.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleTest {
	
	@Test
	public void testSimple() {
		
		int toTest = 2 + 2;
		int assertTestValue = 4;
		
		System.out.println("Sample test: Is " + toTest + " lesser or equals than " + assertTestValue + "?");
		
		assertTrue(toTest <= assertTestValue);
	}

}
