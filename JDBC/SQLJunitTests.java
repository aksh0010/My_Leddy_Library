<<<<<<< Updated upstream
package JDBC;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.*;
import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import BookType;
import Customer_Account;

public class SQLJunitTests {
    public static Scanner input = new Scanner(System.in);

    public BookType testbook = new BookType();
    public Customer_Account customer = new Customer_Account( 
    "FNAME",
    "LNAME",
    "31/10/3005",
    "test@gmail.com",
    12345678);

    public ArrayList<BookType> bookInventory = new ArrayList<>();
    
    public static int user_choice = 1;
    String uname = "root";
	String password = "Hotwings88$";
	String query = "SELECT * FROM books";
    String url = "jdbc:mysql://localhost:3306/myleddy";
	
    @BeforeAll
    public void setUp() throws SQLException {
    	testbook.SetName("TestBook");
    	testbook.SetAuthor("TestAuthor");
    	testbook.SetPublisher("TestPublisher");
    	testbook.SetCategory("TestCategory");
    	testbook.SetISBN(9999999);
    	testbook.SetYear(2022);
    	testbook.SetUnit(10);
    	testbook.SetPrice(24.99);
    }

    /*Librarian tests*/

    //Successfully add new book
    @Test
    public void TestCase1(){
    	Connection con = DriverManager.getConnection(url, uname, password);
    	Statement stmt = con.createStatement();
    	stmt.execute("INSERT INTO Books " +
                "(NAME, AUTHOR, PUBLISHER, CATEGORY, ISBN, MAKE_YEAR, TOTAL_IN_STOCK, COST_PER_UNIT) VALUES ('" + 
                testbook.getName() + "', '" + 
                testbook.getAuthor() + "', '" + 
                testbook.getPublisher() + "', '" + 
                testbook.getCategory() + "', '" + 
                testbook.getISBN() + "', '" + 
                testbook.getYear() + "', '" +
                testbook.getUnit() + "', '" + 
                testbook.getPrice() + "')");

        assertEquals(true, );
    }

    //Successfully remove existing book
    @Test
    public void TestCase2(){
        boolean removedbook = stmt.execute("UPDATE Books SET TOTAL_IN_STOCK=0 WHERE num=" + user_choice);

        assertEquals(true, removedbook);
    }

    //Successfully return book list as object array
    @Test
    public void TestCase3(){
        //Retrieve the N amount of books in the inventory
        ResultSet inventorycount = stmt.executeQuery("SELECT COUNT(*) FROM Books");
        int N = inventorycount.getInt(1);

        BookType [] book = new BookType[10];

        for (int i = 1; i - 1 < N; i++)
        {
            ResultSet availcheck = stmt.executeQuery("SELECT * FROM Books WHERE num=" + i);

            if (availcheck.getInt(8) > 0)
            {
                book[i].SetName(availcheck.getString(2));
                book[i].SetAuthor(availcheck.getString(3));
                book[i].SetPublisher(availcheck.getString(4));
                book[i].SetCategory(availcheck.getString(5));
                book[i].SetISBN(availcheck.getInt(6));
                book[i].SetYear(availcheck.getInt(7));
                book[i].SetUnit(availcheck.getInt(8));
                book[i].SetPrice(availcheck.getFloat(9));

                bookInventory.add(book[i]);
            }

            assertEquals(true, availcheck);
        }
    }

    //Successfully update a value of an existing book
    @Test
    public void TestCase4(){
        testbook.SetCategory("CategoryTest");

        boolean updatedbook = stmt.execute("UPDATE Books SET CATEGORY = '" + testbook.getCategory() +
         "' WHERE num=" + user_choice);

        assertEquals(true, updatedbook);
    }

    /*
     * REPEATED FOR ALL OTHER BOOK ATTRIBUTE UPDATE FUNCTIONS
     */

    /*Customer tests*/

    //Successfully create new user
    @Test
    public void TestCase5(){
        boolean newuser = stmt.execute("INSERT INTO Customer_Account " + 
        "(EMAIL, PASSWORD, FIRST_NAME, LAST_NAME) VALUES ('" + 
        customer.getEmail() + "', '" + 
        customer.getPassword() + "', '" + 
        customer.getFname() + "', '" + 
        customer.getLname() + "')");

        assertEquals(true, newuser);
    }

    //Successfully returns existing user
    @Test
    public void TestCase6(){
        ResultSet customerinfo = stmt.execute("SELECT * FROM Customer_Account WHERE EMAIL=" + 
        customer.getEmail());

        customer.setFname(customerinfo.getString(3));
        customer.setLname(customerinfo.getString(4));

        assertEquals(true, customerinfo);
    }

    //Successfully update of existing user account
     @Test
     public void TestCase7(){
        customer.setContact_no(0000000000);

        boolean updateuser = stmt.execute("UPDATE Customer_Account SET CONTACT_NO='" + 
        customer.getContact_no() + " WHERE EMAIL='" + customer.getEmail() + "'");

        assertEquals(true, updateuser);
     }

     /*
     * REPEAT FOR ALL OTHER CUSTOMER ATTRIBUTE UPDATE FUNCTIONS
     */

     //User successfully borrows book
     @Test
     public void TestCase8(){
        //Add borrowed book data to SQL table and hashmap list
        boolean borrowbook = stmt.execute("INSERT INTO Orders (CUSTOMER, ISBN, RENT, UNITS) VALUES ('"
        + customer.getEmail() + "', '" + 
        + testbook.getISBN() + "', '1', '1')");

        customer.add_to_borrowedList(testbook, 1);

        //Decrease number of books available in stock
        ResultSet availunits = stmt.executeQuery("SELECT * FROM Books WHERE ISBN='" + 
        testbook.getISBN() + "'");
        int newunits = availunits.getInt(8) - 1;
        
        boolean decreasebookavail = stmt.execute("UPDATE Books SET TOTAL_IN_STOCK=" + newunits +
        " WHERE ISBN='9780785839828'");
        testbook.SetUnit(newunits);

        assertEquals(true, borrowbook && decreasebookavail);
     }

     //Successfully return borrowed book
     @Test
     public void TestCase9(){
        //Remove borrowed book data from SQL table and hashmap list
        boolean bookreturn = stmt.execute("DELETE FROM Orders WHERE CUSTOMER='" + 
        customer.getEmail() + "' AND ISBN='" + 
        testbook.getISBN() + "'");

        customer.remove_from_borrowedList(testbook);

        //Update the units available on the Books table
        ResultSet retrievestock = stmt.executeQuery("SELECT * FROM Books WHERE ISBN='9780785839828'");
        int newstock = retrievestock.getInt(6) + 1;
        boolean updatestock = stmt.execute("UPDATE Books SET TOTAL_IN_STOCK=" + newstock +
        "WHERE ISBN='9780785839828'");

        assertEquals(true, bookreturn && updatestock);
     }

     //Successfully add book to wishlist
     public void TestCase10(){
        boolean wishlistadd = stmt.execute("INSERT INTO WISHLIST (CUSTOMER, ISBN) " + 
        "VALUES ('" + customer.getEmail() + "', '" + testbook.getISBN() + "')");

        customer.add_to_wishlist(testbook, 1);

        assertEquals(true, wishlistadd);
     }

     //Successfully remove book from wishlist
     public void TestCase11(){
        boolean removewish = stmt.execute("DELETE FROM WISHLIST WHERE CUSTOMER='" + 
        customer.getEmail() + "' AND '" + testbook.getISBN() + "'");

        customer.remove_from_wishlist(testbook);

        assertEquals(true, removewish);
     }

     //Successfully purchase book
     public void TestCase12(){
        //int N = # of books to be ordered by customer
        ResultSet boughtbook = stmt.executeQuery("SELECT * FROM Books WHERE num=" + user_choice);

        boolean buybook = stmt.execute("INSERT INTO Orders (CUSTOMER, ISBN, RENT, UNITS) VALUES "
        + "('" + customer.getEmail() + "','" + boughtbook.getString(6) + "','0', '" + N + "')");

        //Decrease number of books available in stock
        ResultSet availunits = stmt.executeQuery("SELECT * FROM Books WHERE ISBN='9780785839828'");
        int newunits = availunits.getInt(8) - N;
        boolean decreasebookavail = stmt.execute("UPDATE Books SET TOTAL_IN_STOCK=" + newunits +
        " WHERE ISBN='9780785839828'");

        assertEquals(true, boughtbook && buybook && decreasebookavail);
     }
=======
package JDBC;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.*;
import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import BookType;
import Customer_Account;

public class SQLJunitTests {
    public static Scanner input = new Scanner(System.in);

    public BookType testbook = new BookType();
    public Customer_Account customer = new Customer_Account( 
    "FNAME",
    "LNAME",
    "31/10/3005",
    "test@gmail.com",
    12345678);

    public ArrayList<BookType> bookInventory = new ArrayList<>();
    
    public static int user_choice = 1;
    String uname = "root";
	String password = "Hotwings88$";
	String query = "SELECT * FROM books";
    String url = "jdbc:mysql://localhost:3306/myleddy";
	
    @BeforeAll
    public void setUp() throws SQLException {
    	testbook.SetName("TestBook");
    	testbook.SetAuthor("TestAuthor");
    	testbook.SetPublisher("TestPublisher");
    	testbook.SetCategory("TestCategory");
    	testbook.SetISBN(9999999);
    	testbook.SetYear(2022);
    	testbook.SetUnit(10);
    	testbook.SetPrice(24.99);
    }

    /*Librarian tests*/

    //Successfully add new book
    @Test
    public void TestCase1(){
    	Connection con = DriverManager.getConnection(url, uname, password);
    	Statement stmt = con.createStatement();
    	stmt.execute("INSERT INTO Books " +
                "(NAME, AUTHOR, PUBLISHER, CATEGORY, ISBN, MAKE_YEAR, TOTAL_IN_STOCK, COST_PER_UNIT) VALUES ('" + 
                testbook.getName() + "', '" + 
                testbook.getAuthor() + "', '" + 
                testbook.getPublisher() + "', '" + 
                testbook.getCategory() + "', '" + 
                testbook.getISBN() + "', '" + 
                testbook.getYear() + "', '" +
                testbook.getUnit() + "', '" + 
                testbook.getPrice() + "')");

        assertEquals(true, );
    }

    //Successfully remove existing book
    @Test
    public void TestCase2(){
        boolean removedbook = stmt.execute("UPDATE Books SET TOTAL_IN_STOCK=0 WHERE num=" + user_choice);

        assertEquals(true, removedbook);
    }

    //Successfully return book list as object array
    @Test
    public void TestCase3(){
        //Retrieve the N amount of books in the inventory
        ResultSet inventorycount = stmt.executeQuery("SELECT COUNT(*) FROM Books");
        int N = inventorycount.getInt(1);

        BookType [] book = new BookType[10];

        for (int i = 1; i - 1 < N; i++)
        {
            ResultSet availcheck = stmt.executeQuery("SELECT * FROM Books WHERE num=" + i);

            if (availcheck.getInt(8) > 0)
            {
                book[i].SetName(availcheck.getString(2));
                book[i].SetAuthor(availcheck.getString(3));
                book[i].SetPublisher(availcheck.getString(4));
                book[i].SetCategory(availcheck.getString(5));
                book[i].SetISBN(availcheck.getInt(6));
                book[i].SetYear(availcheck.getInt(7));
                book[i].SetUnit(availcheck.getInt(8));
                book[i].SetPrice(availcheck.getFloat(9));

                bookInventory.add(book[i]);
            }

            assertEquals(true, availcheck);
        }
    }

    //Successfully update a value of an existing book
    @Test
    public void TestCase4(){
        testbook.SetCategory("CategoryTest");

        boolean updatedbook = stmt.execute("UPDATE Books SET CATEGORY = '" + testbook.getCategory() +
         "' WHERE num=" + user_choice);

        assertEquals(true, updatedbook);
    }

    /*
     * REPEATED FOR ALL OTHER BOOK ATTRIBUTE UPDATE FUNCTIONS
     */

    /*Customer tests*/

    //Successfully create new user
    @Test
    public void TestCase5(){
        boolean newuser = stmt.execute("INSERT INTO Customer_Account " + 
        "(EMAIL, PASSWORD, FIRST_NAME, LAST_NAME) VALUES ('" + 
        customer.getEmail() + "', '" + 
        customer.getPassword() + "', '" + 
        customer.getFname() + "', '" + 
        customer.getLname() + "')");

        assertEquals(true, newuser);
    }

    //Successfully returns existing user
    @Test
    public void TestCase6(){
        ResultSet customerinfo = stmt.execute("SELECT * FROM Customer_Account WHERE EMAIL=" + 
        customer.getEmail());

        customer.setFname(customerinfo.getString(3));
        customer.setLname(customerinfo.getString(4));

        assertEquals(true, customerinfo);
    }

    //Successfully update of existing user account
     @Test
     public void TestCase7(){
        customer.setContact_no(0000000000);

        boolean updateuser = stmt.execute("UPDATE Customer_Account SET CONTACT_NO='" + 
        customer.getContact_no() + " WHERE EMAIL='" + customer.getEmail() + "'");

        assertEquals(true, updateuser);
     }

     /*
     * REPEAT FOR ALL OTHER CUSTOMER ATTRIBUTE UPDATE FUNCTIONS
     */

     //User successfully borrows book
     @Test
     public void TestCase8(){
        //Add borrowed book data to SQL table and hashmap list
        boolean borrowbook = stmt.execute("INSERT INTO Orders (CUSTOMER, ISBN, RENT, UNITS) VALUES ('"
        + customer.getEmail() + "', '" + 
        + testbook.getISBN() + "', '1', '1')");

        customer.add_to_borrowedList(testbook, 1);

        //Decrease number of books available in stock
        ResultSet availunits = stmt.executeQuery("SELECT * FROM Books WHERE ISBN='" + 
        testbook.getISBN() + "'");
        int newunits = availunits.getInt(8) - 1;
        
        boolean decreasebookavail = stmt.execute("UPDATE Books SET TOTAL_IN_STOCK=" + newunits +
        " WHERE ISBN='9780785839828'");
        testbook.SetUnit(newunits);

        assertEquals(true, borrowbook && decreasebookavail);
     }

     //Successfully return borrowed book
     @Test
     public void TestCase9(){
        //Remove borrowed book data from SQL table and hashmap list
        boolean bookreturn = stmt.execute("DELETE FROM Orders WHERE CUSTOMER='" + 
        customer.getEmail() + "' AND ISBN='" + 
        testbook.getISBN() + "'");

        customer.remove_from_borrowedList(testbook);

        //Update the units available on the Books table
        ResultSet retrievestock = stmt.executeQuery("SELECT * FROM Books WHERE ISBN='9780785839828'");
        int newstock = retrievestock.getInt(6) + 1;
        boolean updatestock = stmt.execute("UPDATE Books SET TOTAL_IN_STOCK=" + newstock +
        "WHERE ISBN='9780785839828'");

        assertEquals(true, bookreturn && updatestock);
     }

     //Successfully add book to wishlist
     public void TestCase10(){
        boolean wishlistadd = stmt.execute("INSERT INTO WISHLIST (CUSTOMER, ISBN) " + 
        "VALUES ('" + customer.getEmail() + "', '" + testbook.getISBN() + "')");

        customer.add_to_wishlist(testbook, 1);

        assertEquals(true, wishlistadd);
     }

     //Successfully remove book from wishlist
     public void TestCase11(){
        boolean removewish = stmt.execute("DELETE FROM WISHLIST WHERE CUSTOMER='" + 
        customer.getEmail() + "' AND '" + testbook.getISBN() + "'");

        customer.remove_from_wishlist(testbook);

        assertEquals(true, removewish);
     }

     //Successfully purchase book
     public void TestCase12(){
        //int N = # of books to be ordered by customer
        ResultSet boughtbook = stmt.executeQuery("SELECT * FROM Books WHERE num=" + user_choice);

        boolean buybook = stmt.execute("INSERT INTO Orders (CUSTOMER, ISBN, RENT, UNITS) VALUES "
        + "('" + customer.getEmail() + "','" + boughtbook.getString(6) + "','0', '" + N + "')");

        //Decrease number of books available in stock
        ResultSet availunits = stmt.executeQuery("SELECT * FROM Books WHERE ISBN='9780785839828'");
        int newunits = availunits.getInt(8) - N;
        boolean decreasebookavail = stmt.execute("UPDATE Books SET TOTAL_IN_STOCK=" + newunits +
        " WHERE ISBN='9780785839828'");

        assertEquals(true, boughtbook && buybook && decreasebookavail);
     }
>>>>>>> Stashed changes
}