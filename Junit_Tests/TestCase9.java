import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestCase9 {
    //As a customer of the library, I want to view all available books
	Inventory sInventory = new Inventory();
	public static ArrayList<BookType> bookInventory = new ArrayList<>();
	Customer_Account c = new Customer_Account("meep", "meep", "meep", "meep", 1);
	BookType refBook1 =  new BookType("Science");
	BookType refBook2 =  new BookType("Physics");
	BookType refBook3 =  new BookType("CompSci");
	BookType refBook4 =  new BookType("Meep");
	@Test
	void testcase1() { //view no books
		try {
			assertEquals(false, sInventory.view_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase2() { //view 1 books
		try {
			refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
			sInventory.add_book(refBook1);
			assertEquals(true, sInventory.view_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
	@Test
	void testcase3() { //view multiple books
		try {
			refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
			refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
			refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
			refBook1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);
			sInventory.add_book(refBook1);
			sInventory.add_book(refBook2);
			sInventory.add_book(refBook3);
			sInventory.add_book(refBook4);
			assertEquals(true, sInventory.view_books());
		}catch(Exception e){
			fail("Error" + e);
		}
	}
}
