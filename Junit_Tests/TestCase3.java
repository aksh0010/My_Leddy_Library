/**
 * @author Naveed Chowdhury
 * @author Supreyo Atonu
 */

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class TestCase3 {
	/*As a bookkeeper, I want to remove books from my inventory.*/
	@Test
	void testcase1() {
		Function.add_book();//add any number of books2
		try {
			assertEquals(true, Function.remove_book());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() {
		//Tester.add_book();
		//Test for not removing anything 
		try {
			assertEquals(false, Function.remove_book());
		}catch(Exception e){
			fail("Error" + e);
		}
	}

}
