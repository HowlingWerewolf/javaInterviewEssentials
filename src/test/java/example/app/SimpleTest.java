package example.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Button;

import org.junit.Test;

public class SimpleTest {
	
	@Test
	public void testSimple() {
		
		int toTest = 2 + 2;
		int assertTestValue = 4;
		
		System.out.println("Sample test: Is " + toTest + " lesser or equals than " + assertTestValue + "?");
		
		assertTrue(toTest <= assertTestValue);
	}
	
	@Test
	public void testInvalidAssignment() {
		//int x = y = 1; // this is not valid assignment in Java, so it won't compile
	}
	
	@Test
	public void testEqualMarkToVSEquals() {
		String s1 = "test";
		String s2 = new String("test"); // this create unnecessary new object
		String s3 = "test";
		
		assertEquals(false, s1 == s2); // false, references are not the same.
		assertEquals(true, s1.equals(s2)); // true, the objects referenced are equal
		
		assertEquals(true, s1 == s3); // true, references are the same.
		assertEquals(true, s1.equals(s3)); // true, the objects referenced are equal
	}
	
	@Test
	public void testCompareToVSEquals() {
		assertEquals(false, "foo".equals((String)null));

		Exception ex = null;
		try {
			assertEquals(false, "foo".compareTo((String)null)); // note that compareTo throws NullPointerException when comparing a string with null, while equals not
		} catch (NullPointerException npe) {
			ex = npe;
		}		
		assertTrue(!ex.equals(null));  // ex will get a value, since NPE was thrown
	}
	
	@Test
	public void testEquals() {
		assertEquals(true, "john" == "john");
		assertEquals(true, "john".equals("john"));
//		assertEquals(?, "john" = "john"); // does not compile
		assertEquals(false, "john".equals(new Button("john")));
	}
	
	@Test
	public void testHashcodeToVSEquals() {
		// if equals is true, then these the objects must have the same hashcode

		String s1 = "test";
		String s2 = new String("test"); // this create unnecessary new object

		assertEquals(true, s1.equals(s2)); // true, the objects referenced are equal
		assertEquals(true, s1.hashCode() == s2.hashCode()); // equals true, so hashcode is true also
		
		// reverse: same hashcode, but the equals can be false
		// assume we return 1 for hashcode always. Then "foo" and "bar" will have false equals result!
	}
	
	@Test
	public void testStringOperations() {
		String s1 = new String("Hello");
		String s2 = new String("there");
		String s3 = new String();
		
		s3 = s1 + s2;
//		s3 = s1 - s2; // does not compile
//		s3 = s1 & s2; // does not compile
//		s3 = s1 && s2; // does not compile
	}
	
	@Test
	public void testNumberConversion() {
		Integer ten = new Integer(10);
		Long nine = new Long(9);
		System.out.println(ten + nine);
		int i = 1;
		System.out.println(i + ten);
	}
	
	@Test
	public void testStringArrays() {
		String stringArray [] = {"a", "b", "c"};
		for (int i = 0; i < stringArray.length; i++) {
			String string = stringArray[i];
			System.out.println(stringArray[i]);
			
		}
	}

}
