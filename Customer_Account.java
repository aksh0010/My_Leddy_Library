/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */

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

  public void view_Borrowed_books() {
    if (borrowed_books.isEmpty()) {
      System.out.println("___ No borrowed books ___");
    } else {
      borrowed_books.forEach((key, value) ->
        System.out.println(key + " " + value)
      );
    }
  }

  // !!
  public void add_to_borrowedList(BookType book, int units) {
    if (units > 0) {
      if (borrowed_books.containsKey(book)) {
        borrowed_books.replace(book, units);
        System.out.println(
          " Book already in Wishlist. \n Updated the no of units \n"
        );
      } else {
        borrowed_books.putIfAbsent(book, units);
      }
    } else {
      System.out.println("Negative values are not allowed. ");
    }
  }

  // !!  Wishlist methods

  public void view_wishlist() {
    if (wishList_books.isEmpty()) {
      System.out.println("___ No books in Wishlist ___");
    } else {
      // wishList_books.forEach((key, value) ->
      //   System.out.println(key + " " + value)
      // );

      wishList_books.forEach((key, value) ->
        System.out.println(key + " : " + value)
      );
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

  public void View_account() {
    System.out.println("--------------------------------------------------");
    System.out.println(getFname() + " " + getLname());
    System.out.println("Date of birth " + getDate_of_birth());
    System.out.println("Email : " + getEmail());
    System.out.println("Contact no : " + getContact_no());
    System.out.println("Address : " + getAddress());
    System.out.println("--------------------------------------------------");
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
