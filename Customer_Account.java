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
	
  static String uname = "root";
  static String password = "Hotwings88$";
  static String url = "jdbc:mysql://localhost:3306/test_schema";
  
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

  public Customer_Account() {
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

  
  public boolean add_user(){
    Customer_Account new_user = new Customer_Account("test", "test", "test", "test", 0);
    Scanner input = new Scanner(System.in);
    System.out.println(
      "---------------------- Adding User ----------------------"
    );
    System.out.println("What is the first name of the user ?");
    new_user.setFname(input.nextLine());
    System.out.println("What is the last name of the user ?");
    new_user.setLname(input.nextLine());
    System.out.println("What is the email of the user ?");
    new_user.setEmail(input.nextLine());
    System.out.println("What is the Address of the user ?");
    new_user.setAddress(input.nextLine());
    System.out.println("What is the phone number of the user ?");
    new_user.setContact_no(input.nextLong());
    System.out.println(
      "-----------------------------------------------------------"
    );
    //now add this  user to the customer account database
    String insertQuery = "INSERT INTO customer_account (Fname, Lname, email, address, contact_no) VALUES ('" + new_user.getFname() + "', '" + new_user.getLname() + "', '" + 
          new_user.getEmail() + "', '" + new_user.getAddress() + "', '" + new_user.getContact_no() + "' )";

         try{
          Connection con = DriverManager.getConnection(url, uname, password);
          Statement stmt = con.createStatement();
          stmt.executeUpdate(insertQuery);
          con.close();
          return true;
        }catch (SQLException e){
          e.printStackTrace() ;
          return false;
        }
  }
  public boolean delete_user(){
    Scanner input = new Scanner(System.in);
    System.out.println(
      "---------------------- Deleting User ----------------------"
    );
    System.out.println("What is the email of the user ?");
    String email = input.nextLine();
    System.out.println(
      "-----------------------------------------------------------"
    );
    //now delete this  user from the customer account database
    String deleteQuery = "DELETE FROM customer_account WHERE email = '" + email + "'";

         try{
          Connection con = DriverManager.getConnection(url, uname, password);
          Statement stmt = con.createStatement();
          stmt.executeUpdate(deleteQuery);
          con.close();
          return true;
        }catch (SQLException e){
          e.printStackTrace() ;
          return false;
        }
  }

  //method that adds a book to orders table if based on the isbn and customer email
  public boolean add_to_borrowedList1(String Email, Long ISBN){
    try {
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement stmt = con.createStatement();

      //use join in database to get c_id and email from customer_account table and total_units from books table
      ResultSet rs1 = stmt.executeQuery("SELECT c_id, email, total_units FROM customer_account JOIN books ON customer_account.email = '" + Email + "' AND books.ISBN = '" + ISBN + "'");

      if (rs1.next() && rs1.getInt("total_units") > 0) {
        //insert into orders if its been borrowed, the isbn of the book, the customer id, and the email of that customer
        stmt.executeUpdate("INSERT INTO orders (borrowed, isbn, c_id, user_email) VALUES (" + 1 + ", " + ISBN + ", " + rs1.getInt(1) + ", '" + rs1.getString("email") + "')"); 
        //sets units minus 1 of the book borrowed
        stmt.executeUpdate("UPDATE books SET total_units = total_units - 1 WHERE isbn = " + ISBN);
      }else{
        System.out.println("\nBook not available");
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return true;
  }

//Views the orders from database for a scpefic customer id that is also flagged as a borrowed book
public boolean view_Borrowed_books1(String Email){
  try {
    Connection con = DriverManager.getConnection(url, uname, password);
    Statement stmt2 = con.createStatement();
    //ResultSet rs = stmt.executeQuery("SELECT * FROM orders WHERE user_email = '" + Email + "' AND borrowed = 1");
    //gets name from book and all from orders using join 
    
    ResultSet rs = stmt2.executeQuery("SELECT name, orders.* FROM orders JOIN books ON orders.isbn = books.isbn AND orders.user_email = '" + Email + "' AND orders.borrowed = 1");
    if(rs.next()){
      while (rs.next()) {
        System.out.println("\n\n\nName: "+ rs.getString("name") +" | ISBN: " + rs.getLong("isbn") + " | Borrowed: " + rs.getBoolean("borrowed") + " | Customer ID: " + rs.getInt("c_id") + " | User Email: " + rs.getString("user_email"));
      }
      return true;
    }else{
      return false;
    }
  } catch (SQLException e) {
    e.printStackTrace();
    return false;
  }

}
//add function to return borrowed book borrowed gets set back to zero and units goes up by 1
public boolean return_borrowed_book(String Email, Long ISBN){
  try{ 
    Connection con = DriverManager.getConnection(url, uname, password);
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM orders WHERE user_email = '" + Email + "' AND isbn = " + ISBN + " AND borrowed = 1");
    if(rs.next()){
      stmt.executeUpdate("UPDATE orders SET borrowed = 0 WHERE user_email = '" + Email + "' AND isbn = " + ISBN);
      //deletes the order from the database
      stmt.executeUpdate("DELETE FROM orders WHERE user_email = '" + Email + "' AND isbn = " + ISBN + " AND borrowed = 0");
      stmt.executeUpdate("UPDATE books SET total_units = total_units + 1 WHERE isbn = " + ISBN);
      return true;
    }else{
      System.out.println("Book not borrowed");
      return false;
    }
  }catch (SQLException e) {
    e.printStackTrace();
    return false;
  }
}

public boolean buy_book(String Email, Long ISBN){
  try {
    Connection con = DriverManager.getConnection(url, uname, password);
    Statement stmt = con.createStatement();
    ResultSet rs1 = stmt.executeQuery("SELECT c_id, email, total_units FROM customer_account JOIN books ON customer_account.email = '" + Email + "' AND books.ISBN = '" + ISBN + "'");

    //select customer id from the user email
    //insert into orders the borrowed book
    if (rs1.next() && rs1.getInt("total_units") > 0) {
      //insert into orders if its been borrowed, the isbn of the book, the customer id, and the email of that customer
      stmt.executeUpdate("INSERT INTO orders (borrowed, isbn, c_id, user_email) VALUES (" + 0 + ", " + ISBN + ", " + rs1.getInt(1) + ", '" + rs1.getString("email") + "')"); 
      //sets units minus 1 of the book borrowed
      stmt.executeUpdate("UPDATE books SET total_units = total_units - 1 WHERE isbn = " + ISBN);
      return true;
    }else{
      System.out.println("\n\nBook not available");
      return false;
    }
  } catch (SQLException e) {
    e.printStackTrace();
    return false;
  }
}
//return bought book
public boolean return_bought_book(String Email, Long ISBN){
  try{ 
    Connection con = DriverManager.getConnection(url, uname, password);
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM orders WHERE user_email = '" + Email + "' AND isbn = " + ISBN + " AND borrowed = 0");
    if(rs.next()){
      stmt.executeUpdate("UPDATE orders SET borrowed = 1 WHERE user_email = '" + Email + "' AND isbn = " + ISBN);
      //deletes the order from the database
      stmt.executeUpdate("DELETE FROM orders WHERE user_email = '" + Email + "' AND isbn = " + ISBN + " AND borrowed = 1");
      stmt.executeUpdate("UPDATE books SET total_units = total_units + 1 WHERE isbn = " + ISBN);
      return true;
    }else{
      System.out.println("Book not bought");
      return false;
    }

  }catch (SQLException e) {
    e.printStackTrace();
    return false;
  }
}

  // view wishlist books from wishlist table in database for a specific customer email
  public boolean view_wishlist1(String Email){
    try {
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM wishlist WHERE user_email = '" + Email + "'");
      if(rs.next()){
        while (rs.next()) {
          System.out.println("\n\n\nISBN: " + rs.getLong("isbn") +  " | User Email: " + rs.getString("user_email"));
        }
        return true;
      }else{
        System.out.println("No books in wishlist");
        return false;
      }
     
    
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  //adds book name, email and isbn to wishlist table in database for a specific customer email 
  public boolean add_to_wishlist1(String Email, Long ISBN){
    try {
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement stmt = con.createStatement();
      ResultSet rs1 = stmt.executeQuery("SELECT email FROM customer_account WHERE email = '" + Email + "'");
      if (rs1.next()) {
        stmt.executeUpdate("INSERT INTO wishlist (isbn,user_email) VALUES (" + ISBN + ", '" + rs1.getString("email") + "')"); 
        return true;
      }else{
        System.out.println("\n\nBook not available");
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
  //remove from wishlist table in database for a specific customer email
  public boolean remove_from_wishlist1(String Email, Long ISBN){
    try {
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement stmt = con.createStatement();
      ResultSet rs1 = stmt.executeQuery("SELECT email FROM customer_account WHERE email = '" + Email + "'");
      if (rs1.next()) {
        stmt.executeUpdate("DELETE FROM wishlist WHERE user_email = '" + rs1.getString("email") + "' AND isbn = " + ISBN); 
        return true;
      }else{
        System.out.println("\n\nBook not available");
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }
 
  // !!  View my account.

  /* 
  public boolean View_account() {
    System.out.println("--------------------------------------------------");
    System.out.println(getFname() + " " + getLname());
    System.out.println("Date of birth " + getDate_of_birth());
    System.out.println("Email : " + getEmail());
    System.out.println("Contact no : " + getContact_no());
    System.out.println("Address : " + getAddress());
    System.out.println("--------------------------------------------------");
    return true;
  }*/

  //view customer account from database
  public boolean View_account1(String email){ 
    //Query to select all the data from the customer account table where the email is equal to the email that is passed in
    String query = "SELECT * FROM customer_account WHERE email = '" + email + "'";

    try {
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      while (rs.next()) {
        System.out.println("--------------------------------------------------");
        System.out.println(rs.getString(2) + " " + rs.getString(3));
        System.out.println("Date of birth " + rs.getString(4));
        System.out.println("Email : " + rs.getString(5));
        System.out.println("Contact no : " + rs.getString(6));
        System.out.println("Address : " + rs.getString(7));
        System.out.println("--------------------------------------------------");
      }
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }


  //LOGIN AND SIGNUP PUT ON BACKLOG FOR 4th SPRINT
/*
  //customer login method to check if the customer is in the database
  public boolean customer_login(String username, String password) {
    String query = "SELECT * FROM customer_account WHERE username = '" + username + "' AND password = '" + password + "'";
    try {
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      if (rs.next()) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }
  //customer signup method to add customer to the database
  public boolean customer_signup(String fname, String lname, String date_of_birth, String email, String contact_no, String address, String username, String password) {
    String query = "INSERT INTO customer_account (fname, lname, date_of_birth, email, contact_no, address, username, password) VALUES ('" + fname + "', '" + lname + "', '" + date_of_birth + "', '" + email + "', '" + contact_no + "', '" + address + "', '" + username + "', '" + password + "' )";
    try {
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement st = con.createStatement();
      st.executeUpdate(query);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }*/

  // !! Update account
  public boolean update_account(String email) {
    //create connectiom
    try{
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement stmt = con.createStatement();

      
      System.out.println(
      "\nWhat do you want to update ?\n1)First Name \n2)Last Name\n3)Email \n4)Contact no \n5)Date of birth \n6)Address\n7)Go to previous menu\n"
      );
      //add update statement for each part in switch statement
    switch (input.nextInt()) {
      case 1:
        input.nextLine(); // !! to put the pointer to next line
        System.out.print("\nEnter new first name :");
        // setFname(input.nextLine());
        // update statement to update fname in database
        stmt.executeUpdate("UPDATE customer_account SET fname = '" + input.nextLine() + "' WHERE email = '" + email + "'");
        System.out.println("\n Details updated");
        break;
      case 2:
        input.nextLine(); // !! to put the pointer to next line
        System.out.print("\nEnter new last name :");
        //setLname(input.nextLine());
        // update statement to update lname in database
        stmt.executeUpdate("UPDATE customer_account SET lname = '" + input.nextLine() + "' WHERE email = '" + email + "'");
        System.out.println("\n Details updated");

        break;
      case 3:
        input.nextLine(); // !! to put the pointer to next line
        System.out.print("\nEnter new email :");
        //setEmail(input.nextLine());
        // update statement to update email in database
        stmt.executeUpdate("UPDATE customer_account SET email = '" + input.nextLine() + "' WHERE email = '" + email + "'");
        System.out.println("\n Details updated");

        break;
      case 4:
        System.out.print("\nEnter new contact no :");
        //setContact_no(input.nextLong());
        // update statement to update contact_no in database
        stmt.executeUpdate("UPDATE customer_account SET contact_no = '" + input.nextLong() + "' WHERE email = '" + email + "'");
        System.out.println("\n Details updated");
        break;
      case 5:
        input.nextLine(); // !! to put the pointer to next line
        System.out.print("\nEnter new date of birth :");
        //setDate_of_birth(input.nextLine());
        // update statement to update date_of_birth in database
        stmt.executeUpdate("UPDATE customer_account SET date_of_birth = '" + input.nextLine() + "' WHERE email = '" + email + "'");
        System.out.println("\n Details updated");
        break;
      case 6:
        input.nextLine(); // !! to put the pointer to next line
        System.out.print("\nEnter new name address :");
        //setAddress(input.nextLine());
        // update statement to update address in database
        stmt.executeUpdate("UPDATE customer_account SET address = '" + input.nextLine() + "' WHERE email = '" + email + "'");
        System.out.println("\n Details updated");
        break;
      case 7:
        break;
      default:
        System.out.println("\nNo Such index");
    }

    return true;
    
      //create query
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  


    
  }


}
