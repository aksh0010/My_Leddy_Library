/**
 * @author Naveed Chowdhury
 * @author Supreyo Atonu
 */

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class TestCase3 {
	Inventory inventory = new Inventory();
	/*As a bookkeeper, I want to remove books from my inventory.*/
	@Test
	void testcase1() {
		inventory.add_book();//add any number of books2
		try {
			assertEquals(true, inventory.remove_book1());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() {
		//Tester.add_book();
		//Test for not removing anything 
		try {
			assertEquals(false, inventory.remove_book1());
		}catch(Exception e){
			fail("Error" + e);
		}
	}

}
