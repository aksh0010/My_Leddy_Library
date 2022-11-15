import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase8 {
	  //As a customer of the library, I want to buy a book  
		public static ArrayList<BookType> bookInventory = new ArrayList<>();
		Inventory sInventory = new Inventory();
		BookType refBook1 =  new BookType("science");
		
		@Test
		void testcase1() { //book is unavailable 
			try {
				//don't add book for testing purposes
				//assertEquals("Order not able to be placed", c.buy_book());
			}catch(Exception e){
				fail("Error" + e);
			}
		}
		@Test
		void testcase2() { //entered negative input
			try {
				refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
				sInventory.add_book(refBook1);
				//assertEquals("!!ERROR!!", c.buy_book());
			}catch(Exception e){
				fail("Error" + e);
			}
		}
		@Test
		void testcase3() { //book is available to buy
			try {
			    refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
				//assertEquals("Order placed", c.buy_book(refBook1,1));
			}catch(Exception e){
				fail("Error" + e);
			}
		}
		@Test
		void testcase4() { //entered multiple books
			try {
				refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
				sInventory.add_book(refBook1);
				sInventory.add_book(refBook1);
				sInventory.add_book(refBook1);
				sInventory.add_book(refBook1);
				sInventory.add_book(refBook1);
				sInventory.add_book(refBook1);
				//assertEquals("!!ERROR!!", c.buy_book(););
			}catch(Exception e){
				fail("Error" + e);
			}
		}	
}
