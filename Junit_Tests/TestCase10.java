import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase10 {
  //As a customer of the library, I want to view accounts
//	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	Inventory sInventory = new Inventory();
	Customer_Account c1 = new Customer_Account();
	
	@Test
	void testcase1() { //no books to view in wish list
		try {
			assertEquals(false, c1.view_wishlist1("jim@gmail.com"));
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	
	@Test
	void testcase2() { //no books to view in borrowed list
		try {
			assertEquals(false, c1.view_Borrowed_books1("jim@gmail.com"));
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase3() { //view 1 books in wishlist
		try {
			assertEquals(false, c1.view_wishlist1("jim@gmail.com"));
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase4() { //view 1 books in borrowed list
		try {
			
			c1.add_to_borrowedList1("jim@gmail.com", (long)12322);
			assertEquals(true, c1.view_Borrowed_books1("jim@gmail.com"));
			c1.return_borrowed_book("jim@gmail.com", (long)12322);
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase5() { //view all books in wishlist(enter more then 1 book)
		try {
			c1.add_to_wishlist1("jim@gmail.com",(long)3);
			assertEquals(true, c1.view_wishlist1("jim@gmail.com"));
			c1.remove_from_wishlist1("jim@gmail.com",(long)3);
		}catch(Exception e){
			fail("Error" + e);
		}
	}

	@Test
	void testcase7() { //view account details 
		try {
			assertEquals(true,c1.View_account1("jim@gmail.com"));
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	//view bought books in list
}
