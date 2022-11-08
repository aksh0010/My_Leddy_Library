/**
 * @author Naveed Chowdhury
 * @author Supreyo Atonu
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase1 {
	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	/*As a bookkeeper, I want to see all my books.*/
	
	@Test
	void testcase1() {
		try {
		Tester.add_book(); // !! Mandatory 0 or negative value (anything below 1)
		assertEquals(false,Tester.view_books());
		}
		catch(Exception e){
			 fail("Error" + e);
		}
	}

	@Test
	void testcase2() {
		try {
			Tester.add_book(); 	// !! Mandatory add only 1 book		
			assertEquals(true,Tester.view_books());
			}
			catch(Exception e){
				fail("Error" + e);
			}
	}
	
	@Test
	void testcase3() {
		try {
			Tester.add_book(); // !! add more then 1 book
			assertEquals(true,Tester.view_books());
			}
			catch(Exception e){
				fail("Error" + e);
			}
	}
	
}
