import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase11 {
	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	Inventory sInventory = new Inventory();
	BookType refBook1 =  new BookType("Science");
	Customer_Account c = new Customer_Account("meep", "meep", "meep", "meep", 1);
	@Test
	void testcase3() { //view 1 books in wishlist
		try {
			refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
			c.add_to_wishlist(refBook1,1);
			sInventory.add_book(refBook1);
			assertEquals(true, c.view_wishlist());
		}catch(Exception e){
			fail("Error" + e);
		}
	}

}
