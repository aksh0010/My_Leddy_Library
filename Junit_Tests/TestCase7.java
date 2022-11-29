import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase7 {
	//As a customer of the library, I want to return a book  
	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	Inventory sInventory = new Inventory();

	Customer_Account c1 = new Customer_Account("Agile", "meep", "meep", "meep", 1);

	@Test
	void testcase1() { //return a book is not correct
		try {
			assertEquals(false,c1.return_borrowed_book("jim@gmail.com",(long)123));
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() { //return a book is correct
		try {
			c1.return_borrowed_book("test@gmail.com",(long)1234);
			c1.add_to_borrowedList1("test@gmail.com",(long)1234);
			assertEquals(true, c1.return_borrowed_book("test@gmail.com",(long)1234));
		}catch(Exception e){
			fail("Error" + e);
		}
	}

}
