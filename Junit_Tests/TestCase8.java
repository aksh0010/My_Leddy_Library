import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase8 {
	  //As a customer of the library, I want to buy a book  
		public static ArrayList<BookType> bookInventory = new ArrayList<>();
		Inventory sInventory = new Inventory();
		BookType refBook1 =  new BookType("science");
		Customer_Account c1 = new Customer_Account();
		
		@Test
		void testcase1() { //book is unavailable 
			try {
				//don't add book for testing purposes
				assertEquals(false,c1.buy_book("test@gmail.com", (long)193992));//book that doesnt exist in database 
			}catch(Exception e){
				fail("Error" + e);
			}
		}
		@Test
		void testcase2() { //entered negative input
			try {
				assertEquals(false,c1.buy_book("test@gmail.com", (long)-1)); //book doesnt exist but works with negatives
			}catch(Exception e){
				fail("Error" + e);
			}
		}
		@Test
		void testcase3() { //book is available to buy
			try {
			    sInventory.add_book();//enter book with isbn 44123
			    assertEquals(true,c1.buy_book("test@gmail.com", (long)44123));
			}catch(Exception e){
				fail("Error" + e);
			}
		}
}
