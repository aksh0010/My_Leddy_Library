import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase10 {
  //As a customer of the library, I want to view accounts
	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	Inventory sInventory = new Inventory();
	BookType refBook1 =  new BookType("Science");
	BookType refBook2 =  new BookType("Science1");
	BookType refBook3 =  new BookType("Science2");

	Customer_Account c = new Customer_Account("meep", "meep", "meep", "meep", 1);
	@Test
	void testcase1() { //no books to view in wish list
		try {
			assertEquals(false, c.view_wishlist());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	
	@Test
	void testcase2() { //no books to view in borrowed list
		try {
			assertEquals(false, c.view_Borrowed_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
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
	@Test
	void testcase4() { //view 1 books in borrowed list
		try {
			refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
			c.add_to_borrowedList(refBook1, 1);
			assertEquals(true, c.view_Borrowed_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase5() { //view all books in wishlist(enter more then 1 book)
		try {
			refBook2.Set_all("Agile1", "Aksh1", 123456, 25, "UWindsor", 2020, 10);
			refBook3.Set_all("Agile2", "Aksh2", 123456, 25, "UWindsor", 2020, 10);
			c.add_to_wishlist(refBook2,2);
			c.add_to_wishlist(refBook3,3);
			assertEquals(true, c.view_wishlist());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase6() { //view all books in wishlist(enter more then 1 book)
		try {
			refBook2.Set_all("Agile1", "Aksh1", 123456, 25, "UWindsor", 2020, 10);
			refBook3.Set_all("Agile2", "Aksh2", 123456, 25, "UWindsor", 2020, 10);
			c.add_to_borrowedList(refBook2,1);
			c.add_to_borrowedList(refBook3,1);
			assertEquals(true,c.view_Borrowed_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	
	@Test
	void testcase7() { //view account details 
		try {
			assertEquals(true,c.View_account());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	/*
	@Test
	void testcase8() { //no account details
		try {
			
			assertEquals(false,c.view_Borrowed_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	
	/*view bought books in list
	@Test
	void testcase9() { //no books to view in wish list
		try {
			assertEquals(false, c.view_bought_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	/*view bought books in list
	@Test
	void testcase10() { //no books to view in wish list
		try {
			c.buy_bookk(refBook1);
			assertEquals(false, c.view_bought_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	 */
	
}
