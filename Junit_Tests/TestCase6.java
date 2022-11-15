import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase6 {
	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	// As a customer of the library, I want to borrow a book. 
	Inventory sInventory = new Inventory();
	BookType refBook1 =  new BookType("");
   
	Customer_Account c = new Customer_Account("meep", "meep", "meep", "meep", 1);
	@Test
	void testcase1() {//book is not available
		try {
			assertEquals(false, c.view_Borrowed_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() {//bad input for books//
		try {
			c.add_to_borrowedList(refBook1,-10000);
			assertEquals(false, c.view_Borrowed_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}

	@Test
	void testcase3() {//Add too many books , Maybe ask for user input to test
		try {
			refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
			sInventory.add_book(refBook1);
			c.add_to_borrowedList(refBook1,1000000000);
			assertEquals(true, c.view_Borrowed_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	
	@Test
	void testcase4() { //book is available 
		try {
			refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
			sInventory.add_book(refBook1);
			assertEquals(true, c.add_to_borrowedList(refBook1,1));
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	


}
