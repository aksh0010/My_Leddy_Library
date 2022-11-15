import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase7 {
	//As a customer of the library, I want to return a book  
	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	Inventory sInventory = new Inventory();
	BookType refBook1 =  new BookType("science");
	Customer_Account c = new Customer_Account("Agile", "meep", "meep", "meep", 1);

	@Test
	void testcase1() { //return a book is not correct
		try {
			//assertEquals(true, inventory.return_borrowed_book());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() { //return a book is correct
		try {
			c.add_to_borrowedList(refBook1,1);
			//assertEquals(false, inventory.return_borrowed_book());
		}catch(Exception e){
			fail("Error" + e);
		}
	}

}
