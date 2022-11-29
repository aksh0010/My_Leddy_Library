import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase6 {
	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	// As a customer of the library, I want to borrow a book. 
	Inventory sInventory = new Inventory();
	BookType refBook1 =  new BookType("");
   
	Customer_Account c1 = new Customer_Account("Agile", "meep", "meep", "meep", 1);
	@Test
	void testcase1() {//book is not available
		try {
			 assertEquals(true,c1.view_Borrowed_books1("test@gmail.com"));
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() {//bad input for books//
		try {
			 c1.add_to_borrowedList1("test@gmail.com", (long)1);
			 assertEquals(true,c1.view_Borrowed_books1("test@gmail.com"));
		}catch(Exception e){
			fail("Error" + e);
		}
	}

	@Test
	void testcase3() {//Add too many books , Maybe ask for user input to test
		try {
			c1.return_borrowed_book("test@gmail.com",(long)12347);
			sInventory.add_book();
			c1.add_to_borrowedList1("test@gmail.com",(long)12347); //remeber to add book 12347
			assertEquals(false, c1.view_Borrowed_books1("test@gmail.com"));
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	
	@Test
	void testcase4() { //book is available 
		try {
			assertEquals(true, c1.add_to_borrowedList1("test@gmail.com",(long)1234));
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	


}
