/**
 * @author Naveed Chowdhury
 * @author Supreyo Atonu
 */


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCase4 {
	
	/*As a bookkeeper, I want to update the book*/
	@Test
	void testcase1() { // !!update exisitng book
		try {
			Tester.add_book();
			assertEquals(true, Tester.update_details());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() { // !! want to update a book which doesnt exist
		try {
			assertEquals(false,Tester.update_details());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
}
