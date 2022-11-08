/**
 * @author Naveed Chowdhury
 * @author Supreyo Atonu
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase2 {
	public static ArrayList<BookType> bookInventory = new ArrayList<>();

	/*As a bookkeeper, I want to add new books to my inventory.*/	
	@Test
	void testcase1() {
	//enter 1 book named 1
		try {
			assertEquals("1",Tester.add_book());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() {
	//enter two books 1 and 2 
		try {
			assertEquals("12",Tester.add_book());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase3() {
		//Check for invalid input #ofBooks <= 1
		try {
			assertEquals("!!Error!!",Tester.add_book());
		}catch(Exception e){
			fail("Error" + e);
		}
	}

}
