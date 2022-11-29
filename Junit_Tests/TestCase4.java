/**
 * @author Naveed Chowdhury
 * @author Supreyo Atonu
 */


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCase4 {
	Inventory inventory = new Inventory();
	/*As a bookkeeper, I want to update the book*/
	@Test
	void testcase1() { // !!update exisitng book
		try {
			assertEquals(true, inventory.update_details1());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() { // !! want to update a book which doesnt exist
		try {
			assertEquals(false,inventory.update_details1());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
}
