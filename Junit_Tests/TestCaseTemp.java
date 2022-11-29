/**
 * @author Naveed Chowdhury
 * @author Supreyo Atonu
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


class TestCaseTemp {
	
    public static Scanner input = new Scanner(System.in);
    
	Inventory inventory = new Inventory();
	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	//add customer account
    Customer_Account c1 = new Customer_Account();
    
    /*As a bookkeeper, I want to see all my books.*/
	
    //Create test case for view_wishlist1() in customer_account.java
	@Test
    void testcase1(){
        assertEquals(true,c1.view_wishlist1("jimmy@gmail.com"));
    }
	//case to test other functions in customer_account.java
	@Test
	void testcase2() {
		c1.add_to_borrowedList1("jim@gmail.com", (long)123);
		assertEquals(true,c1.return_borrowed_book("jim@gmail.com",(long)123));
		
	}

    @Test
	void testcase3(){
		assertEquals(true, c1.add_to_borrowedList1("jimmy@gmail.com", (long)123));
		c1.return_borrowed_book("jimmy@gmail.com",(long)123);
		
	}
    //test for add user
    @Test
    void testcase4(){
        assertEquals(true,c1.add_user());
    }
    //test for remove user
    @Test
    void testcase5(){
        assertEquals(true,c1.delete_user());
    }
    //view borrowed list
    @Test
    void testcase6(){
        assertEquals(true,c1.view_Borrowed_books1("1"));// test email
    }
    //buy book
    @Test
    void testcase7(){
        assertEquals(true,c1.buy_book("test@gmail.com", (long)123));// test email
    }
      //add to wishlist
    @Test
    void testcase8(){
        assertEquals(true,c1.add_to_wishlist1("test@gmail.com", (long)123));// test email
    }
    //view wishlist
    @Test
    void testcase9(){
        assertEquals(true,c1.view_wishlist1("test@gmail.com"));// test email
    }
    @Test
    void testcase10(){
        assertEquals(true,c1.remove_from_wishlist1("test@gmail.com", (long)123));// test email
    }

    //view account
    @Test
    void testcase11(){
        assertEquals(true,c1.View_account1("test@gmail.com"));
    }
    @Test
    void testcase12(){
        assertEquals(true,c1.update_account("test@gmail.com"));
    }
}   