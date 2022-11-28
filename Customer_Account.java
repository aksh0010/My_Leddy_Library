/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Customer_Account {

  public static Scanner input = new Scanner(System.in);
  // public static ArrayList<BookType> borrowed_books = new ArrayList<>();
  public static HashMap<BookType, Integer> borrowed_books = new HashMap<>(); // !! Booktype , number of units
  // public static ArrayList<BookType> wishList_books = new ArrayList<>();
  public static HashMap<BookType, Integer> wishList_books = new HashMap<>();

  public static ArrayList<BookType> bought_books = new ArrayList<>();
  // public static Stack<BookType> bought_books = new Stack();

  String Fname;
  String Lname;
  String date_of_birth = "--";
  String email = "--";
  String address = "--";
  long contact_no;

  public Customer_Account(
    String fname,
    String lname,
    String dob,
    String email,
    long contact_no
  ) {
    this.Fname = fname;
    this.Lname = lname;
    this.date_of_birth = dob;
    this.email = email;
    this.contact_no = contact_no;
  }

  // !! Getter methods
  public String getAddress() {
    return address;
  }

  public String getFname() {
    return Fname;
  }

  public String getLname() {
    return Lname;
  }

  public String getDate_of_birth() {
    return date_of_birth;
  }

  public long getContact_no() {
    return contact_no;
  }

  public String getEmail() {
    return email;
  }

  public static HashMap<BookType, Integer> getBorrowed_books() {
    return borrowed_books;
  }

  public static ArrayList<BookType> getBought_books() {
    return bought_books;
  }

  public static HashMap<BookType, Integer> getWishList_books() {
    return wishList_books;
  }

  // !! Setter methods
  public void setAddress(String address) {
    this.address = address;
  }

  public void setFname(String fname) {
    Fname = fname;
  }

  public void setLname(String lname) {
    Lname = lname;
  }

  public void setDate_of_birth(String date_of_birth) {
    this.date_of_birth = date_of_birth;
  }

  public void setContact_no(long contact_no) {
    this.contact_no = contact_no;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // !! View Borrowed books

  public boolean view_Borrowed_books() {
    if (borrowed_books.isEmpty()) {
      System.out.println("___ No borrowed books ___");
      return false;
    } else {
      borrowed_books.forEach((key, value) ->
        System.out.println(key + " " + value)
      );
      return true;
    }
  }
  //method that gets borrowed books from the customer table from the database
  public String getBorrowedBooksFromDB() {
    String borrowedBooks = "";
    return borrowedBooks;
    
  }


  // !!
  public boolean add_to_borrowedList(BookType book, int units) {
    if (units > 0) {
      if (borrowed_books.containsKey(book)) {
        borrowed_books.replace(book, units);
        System.out.println(
          " Book already in Wishlist. \n Updated the no of units \n"
        );
        return false;
      } else {
        borrowed_books.putIfAbsent(book, units);
        return true;
      }
    } else {
      System.out.println("Negative values are not allowed. ");
      return false;
    }
  }

  // !!  Wishlist methods

  public boolean view_wishlist() {
    if (wishList_books.isEmpty()) {
      System.out.println("___ No books in Wishlist ___");
      return false;
    } else {
      // wishList_books.forEach((key, value) ->
      //   System.out.println(key + " " + value)
      // );

      wishList_books.forEach((key, value) ->
        System.out.println(key + " : " + value)
      );
      return true;
    }
  }

  public void add_to_wishlist(BookType book, int units) {
    if (units > 0) {
      if (wishList_books.containsKey(book)) {
        wishList_books.replace(book, units);
        System.out.println(
          " Book already in Wishlist. \n Updated the no of units \n"
        );
      } else {
        wishList_books.putIfAbsent(book, units);
      }
    } else {
      System.out.println("Negative values are not allowed. ");
    }
  }

  // !! View Bought/Purchased Books
  public void view_bought_books() {
    if (bought_books.isEmpty()) {
      System.out.println("___ No books Purchased so far ___");
    } else {
      for (BookType bookType : bought_books) {
        System.out.println(bookType);
      }
    }
  }

 
  // !!  View my account.

  public boolean View_account() {
    System.out.println("--------------------------------------------------");
    System.out.println(getFname() + " " + getLname());
    System.out.println("Date of birth " + getDate_of_birth());
    System.out.println("Email : " + getEmail());
    System.out.println("Contact no : " + getContact_no());
    System.out.println("Address : " + getAddress());
    System.out.println("--------------------------------------------------");
    return true;
  }

  //view customer account from database
  public boolean View_account1(int c_id){
    String uname = "root";
    String password = "Hotwings88$";
    String url = "jdbc:mysql://localhost:3306/test_schema";
    String query = "SELECT * FROM customer WHERE c_id = " + c_id;

    try {
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      while (rs.next()) {
        System.out.println("--------------------------------------------------");
        System.out.println(rs.getString("fname") + " " + rs.getString("lname"));
        System.out.println("Date of birth " + rs.getString("dob"));
        System.out.println("Email : " + rs.getString("email"));
        System.out.println("Contact no : " + rs.getString("contact_no"));
        System.out.println("Address : " + rs.getString("address"));
        System.out.println("--------------------------------------------------");
      }
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  // !! Add to Bought/Purchased Books
  public Boolean buy_books(String username,String name, String author, long isbn, int make_year, int units, double price) {
    String uname = "root";
	String password = "Hotwings88$";
    String url = "jdbc:mysql://localhost:3306/test_schema";
  
    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Where is your MySQL JDBC Driver?");
      e.printStackTrace();
    }
    final String insertQuery = "INSERT INTO books (name, author, isbn, make_year, total_in_stock, cost_per_unit) VALUES ('" + name + "', '" + author + "', '" + isbn + "', '" + make_year + "', '" + units + "', '" + price + "' )";
    try{
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement st = con.createStatement();
      st.executeUpdate(insertQuery);
      return true;
    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console");
      e.printStackTrace();
    }
    return false;
  }
  // !! Update account
  public void update_account() {
    System.out.println(
      "\nWhat do you want to update ?\n1)First Name \n2)Last Name\n3)Email \n4)Contact no \n5)Date of birth \n6)Address\n7)Go to previous menu\n"
    );

    switch (input.nextInt()) {
      case 1:
        input.nextLine(); // !! to put the pointer to next line
        System.out.print("\nEnter new first name :");
        setFname(input.nextLine());
        System.out.println("\n Details updated");
        break;
      case 2:
        input.nextLine(); // !! to put the pointer to next line
        System.out.print("\nEnter new last name :");
        setLname(input.nextLine());
        System.out.println("\n Details updated");

        break;
      case 3:
        input.nextLine(); // !! to put the pointer to next line
        System.out.print("\nEnter new email :");
        setEmail(input.nextLine());
        System.out.println("\n Details updated");

        break;
      case 4:
        System.out.print("\nEnter new contact no :");
        setContact_no(input.nextLong());
        System.out.println("\n Details updated");
        break;
      case 5:
        input.nextLine(); // !! to put the pointer to next line
        System.out.print("\nEnter new date of birth :");
        setDate_of_birth(input.nextLine());
        System.out.println("\n Details updated");
        break;
      case 6:
        input.nextLine(); // !! to put the pointer to next line
        System.out.print("\nEnter new name address :");
        setAddress(input.nextLine());
        System.out.println("\n Details updated");
        break;
      case 7:
        break;
      default:
        System.out.println("\nNo Such index");
    }
  }
}
