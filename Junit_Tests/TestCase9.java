import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase9 {
    //As a customer of the library, I want to view all available books
	Inventory sInventory = new Inventory();
	public static ArrayList<BookType> bookInventory = new ArrayList<>();

	@Test
	void testcase1() { //view all books
		try {
			assertEquals(true, sInventory.view_books1());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
}
