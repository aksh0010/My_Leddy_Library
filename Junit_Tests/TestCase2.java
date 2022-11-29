/**
 * @author Naveed Chowdhury
 * @author Supreyo Atonu
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase2 {
	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	Inventory inventory = new Inventory();
	/*As a bookkeeper, I want to add new books to my inventory.*/	
	@Test
	void testcase1() {
	//test not adding anybooks
		try {
			assertEquals("!!Error!!",inventory.add_book());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() {
	//enter two books 1/ and 2 
		try {
			assertEquals("true",inventory.add_book());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase3() {
		//Check for invalid input #ofBooks <= 1
		try {
			assertEquals("!!Error!!",inventory.add_book());
		}catch(Exception e){
			fail("Error" + e);
		}
	}

}
