/**
 * @author Naveed Chowdhury
 * @author Supreyo Atonu
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCase5 {
	Book b1 = new Book();
	
	/*As a bookkeeper, I want to update the availability of a book.*/
	@Test
	void testcase1() {
		b1.setAvailability(false);
		assertEquals(false, b1.getAvailability());
	}
	@Test
	void testcase2() {
		b1.setAvailability(true);
		assertEquals(true, b1.getAvailability());
	}
	@Test
	void testcase3() {
		b1.SetUnit(10);
		assertEquals(10, b1.getUnit());
	}
	@Test
	void testcase8() {
		b1.SetUnit(0);
		assertEquals(0, b1.getUnit());
	}
	@Test
	void testcase4() {
		b1.SetUnit(-1); // should fail cannot have negative value 
		assertEquals(-1, b1.getUnit());
	}
	@Test
	void testcase5() {
		b1.SetYear(1);
		assertEquals(1, b1.getYear());
	}
	@Test
	void testcase6() {
		b1.SetYear(0);
		assertEquals(0, b1.getYear());
	}
	@Test
	void testcase7() {
		b1.SetYear(-1);
		assertEquals(-1, b1.getYear());
	}
	@Test
	void testcase9() {
		b1.SetPublisher("jimmy");
		assertEquals("jimmy", b1.getPublisher());
	}
	@Test
	void testcase10() {
		b1.SetAuthor("jimmy");
		assertEquals("jimmy", b1.getAuthor());
	}
	@Test
	void testcase11() {
		b1.SetName("jimmy");
		assertEquals("jimmy", b1.getName());
	}
	@Test
	void testcase12() {
		b1.SetISBN(1);
		assertEquals(1, b1.getISBN());
	}
	@Test
	void testcase13() {
		b1.SetISBN(0);
		assertEquals(0, b1.getISBN());
	}
	@Test
	void testcase14() {
		b1.SetISBN(-1);
		assertEquals(-1, b1.getISBN());
	}
	@Test
	void testcase15() {
		b1.SetPrice(0);
		assertEquals(0, b1.getPrice());
	}
	@Test
	void testcase16() {
		b1.SetPrice(-1);
		assertEquals(-1, b1.getPrice());
	}
	@Test
	void testcase17() {
		b1.SetPrice(10);
		assertEquals(10, b1.getPrice());
	}
	
}
