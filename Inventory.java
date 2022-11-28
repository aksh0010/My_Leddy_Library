/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Inventory {

  public ArrayList<BookType> bookInventory = new ArrayList<>();
  public static Scanner input = new Scanner(System.in);

  // !! Add book
  // !! Overloading add method to add book directly to inventory
  public void add_book(BookType a) {
    bookInventory.add(a);
  }

  // !! Returns String of all book name

  public String add_book() {
    String uname = "root";
		String password = "Hotwings88$";
    String url = "jdbc:mysql://localhost:3306/test_schema";

    System.out.println(
      "---------------------- Adding Book ----------------------"
    );
    System.out.println("\nHow many books you want to add ? ");
    String to_return = "";
    int total_books = input.nextInt();
    if (total_books >= 1) {
      for (int i = 0; i < total_books; i++) {
        input.nextLine(); // !! Using this to make input scanner point to new line as nextint() takes only int and point to next space
        BookType loop_book_type = new BookType();
        System.out.println(
          "\n\nWhat is the Category(Science, Chemistry, Physics ...) of the book " +
          (i + 1) +
          "? "
        );
        loop_book_type.SetCategory(input.nextLine());

        System.out.println("What is the Title of the book ?");
        loop_book_type.SetName(input.nextLine());

        System.out.println("Who is the author of the book ?");
        loop_book_type.SetAuthor(input.nextLine());

        System.out.println("Who is the publisher of the book ?");
        loop_book_type.SetPublisher(input.nextLine());
        System.out.println("What is the ISBN of the book ?");
        loop_book_type.SetISBN(input.nextLong());

        System.out.println("What is the make year of the book ?");
        loop_book_type.SetYear(input.nextInt());

        System.out.println("How many units in total do we have ?");
        loop_book_type.SetUnit(input.nextInt());

        System.out.println(
          "What is the cost of each units in Canadian Dollars ?"
        );
        loop_book_type.SetPrice(input.nextDouble());

        int available ;
        
        if (loop_book_type.available()) {
        	available = 1;
        }else {
        	available = 0;
        }
        String insertQuery = "INSERT INTO books (isbn, name, author, price, publisher, year, total_units, available, Booktype) VALUES ('" + loop_book_type.getISBN() + "', '" + loop_book_type.getName() + "', '" 
         + loop_book_type.getAuthor() + "', '" + loop_book_type.getPrice() + "', '" + loop_book_type.getPublisher() + "', '" + loop_book_type.getYear() + "', '" + loop_book_type.getUnit() +  "', '" + available + "', '" + loop_book_type.getCategory() +"' )";

         try{
          Connection con = DriverManager.getConnection(url, uname, password);
          Statement stmt = con.createStatement();
          stmt.executeUpdate(insertQuery);
          con.close();
        }catch (SQLException e){
          e.printStackTrace() ;
        }
        bookInventory.add(loop_book_type);
        to_return = to_return + loop_book_type.getName();
      }
    } else {
      to_return = "!!Error!!";
    }
    System.out.println(
      "-----------------------------------------------------------"
    );
    // input.close();
    return to_return;
  }

  // !! Remove book
  // !! Overloading remove method to remove book directly to inventory
  public void remove_book(BookType a) {
    bookInventory.remove(a);
  }
  /*
  public boolean remove_book() {
    String uname = "root";
		String password = "Hotwings88$";
    String url = "jdbc:mysql://localhost:3306/test_schema";

    // Scanner input = new Scanner(System.in);
    System.out.println(
      "---------------------- Removing Book ----------------------"
    );
    if (bookInventory.size() == 0) {
      System.out.println("No Book Found in the data to remove\n");
      System.out.println(
        "-----------------------------------------------------------"
      );
      return false;
    } else {
      view_books1();
      System.out.println(
        "Choose an index of the book you want to remove from below list"
      );
      int user_choice;
      user_choice = input.nextInt();
      
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement stmt = con.createStatement();
      String query = "select count(*) from Cricketers_Data";
      //Executing the query
      ResultSet rs = stmt.executeQuery(query);
      //Retrieving the result
      rs.next();
      int count = rs.getInt(1);

      if (user_choice <= bookInventory.size() && user_choice > 0) {
        System.out.println(
          bookInventory.get(user_choice - 1).getName() +
          " Removed from the inventory"
        );
        bookInventory.remove(user_choice - 1);
        System.out.println(
          "-----------------------------------------------------------"
        );
        return true;
      } else {
        System.out.println(" !! No Such Index");
        System.out.println(
          "-----------------------------------------------------------"
        );
        return false;
      }
    }
  }*/

  //drop book from table based on selected index 
  public void remove_book1(){
    String uname = "root";
		String password = "Hotwings88$";
    String url = "jdbc:mysql://localhost:3306/test_schema";

    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        } 
    catch (ClassNotFoundException e) {
        System.out.println("Where is your MySQL JDBC Driver?");
        e.printStackTrace();
    }
    System.out.println(
      "---------------------- Removing Book ----------------------"
    );
    //removes book based on the name of book inputted by user
    view_books1();
    System.out.println("\nEnter the isbn of the book you want to remove: ");
    long ISBN = input.nextLong();
    String deleteQuery = "DELETE FROM books WHERE isbn = '" + ISBN + "'";
    try{
      Connection con = DriverManager.getConnection(url, uname, password);
      Statement stmt = con.createStatement();
      stmt.executeUpdate(deleteQuery);
      con.close();
    }catch (SQLException e){
      e.printStackTrace() ;
    }
    System.out.println(
    	      "---------------------- New Book list----------------------"
    	    );
    view_books1();
    
    System.out.println(
    	      "-------------------------------------------------"
    	    );

  } 

  // !! Priting inventory in tabulor form
  public boolean view_books() {
    if (bookInventory.size() == 0) {
      System.out.println("\n\n There is no data to show :( \n ");
      return false;
    } else {
      System.out.println(
        "---------------------------------------------------------------------------------------------------------------------------"
      );
      System.out.printf(
        "%3s %10s %15s %15s%15s %15s%15s %15s %9s",
        "INDEX",
        "NAME",
        "AUTHOR",
        "PUBLISHER",
        "CATEGORY",
        "ISBN",
        "MAKE_YEAR",
        "TOTAL_IN_STOCK",
        "COST_PER_UNIT"
      );

      System.out.println();
      System.out.println(
        "---------------------------------------------------------------------------------------------------------------------------"
      );
      int i = 1;
      for (BookType a : bookInventory) {
        System.out.printf(
          "%3s %10s %15s %15s%15s %15s%15s %15s %9s",
          i,
          a.getName(),
          a.getAuthor(),
          a.getPublisher(),
          a.getCategory(),
          a.getISBN(),
          a.getYear(),
          a.getUnit(),
          a.getPrice()
        );
        System.out.println();
        i++;
      }
      System.out.println(
        "---------------------------------------------------------------------------------------------------------------------------"
      );
      return true;
    }
  }
  //view all books data from database table 
  public void view_books1(){
    String uname = "root";
    String password = "Hotwings88$";
    String url = "jdbc:mysql://localhost:3306/test_schema";
    String query = "SELECT * FROM books";
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,uname,password);
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      while(rs.next()){
        System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3)+ " " + rs.getString(4) + " " + rs.getString(5) +" " + rs.getString(6)+ " " + rs.getString(7));
      }
    }catch(SQLException e){
      System.out.println(e);
      e.printStackTrace();
    }
    catch(Exception e){
      System.out.println(e);
    }
}

/*
  // !! Update details of individual object
  public boolean update_details() {
	  String uname = "root";
	  String password = "Hotwings88$";
      String url = "jdbc:mysql://localhost:3306/test_schema";
      try {
			Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
          System.out.println("Where is your MySQL JDBC Driver?");
          e.printStackTrace();
      }
      
      
      
    if (bookInventory.size() == 0) {
      System.out.println("\n\nNo book in database to update details");
      System.out.println(
        "-----------------------------------------------------------"
      );
      return false;
    } else {
      view_books1();
      System.out.println("Which book you want to update ( Choose index)");

      int temp = input.nextInt();

      //temp <= bookInventory.size() && temp > 0
      if (true) {
        BookType refBook = bookInventory.get(temp - 1);

        System.out.println(
          "What do you want to update regarding the book ?\n 1) Name 2)Author 3) Publisher 4) Cost 6)Make Year 7)Total units available"
        );
        
        Long isbn = refBook.getISBN();
        
        switch (input.nextInt()) {
          case 1:
            System.out.println("Enter new name of the book");
            input.nextLine(); // !! reference  the input to new line as nextint() doesnot point to new line

            refBook.SetName(input.nextLine());
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books();

            break;
          case 2:
            System.out.println("Enter new Author name of the book");
            input.nextLine(); // !! reference  the input to new line as nextint() doesnot point to new line
            refBook.SetAuthor(input.nextLine());
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books();

            break;
          case 3:
            System.out.println("Enter new Publisher name of the book");
            input.nextLine(); // !! reference  the input to new line as nextint() doesnot point to new line
            refBook.SetPublisher(input.nextLine());
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books();
            break;
          case 4:
            System.out.println("Enter new Cost per unit of the book");
            refBook.SetPrice(input.nextDouble());
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books();
            break;
          /*case 5:
            System.out.println("Enter new ISBN of the book");
            refBook.SetISBN(input.nextInt());
            System.out.println(
              "---------------------- Updated list ----------------------"
            )
            view_books();
            break;
          case 6:
            System.out.println("Enter new Make Year of the book");
            refBook.SetYear(input.nextInt());
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books();
            break;
          case 7:
            System.out.println("Enter new Make Year of the book");
            refBook.SetUnit((input.nextInt()));
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books();
            break;
          default:
            System.out.println("!! No such index");
            System.out.println(
              "-----------------------------------------------------------"
            );
            return false;
        }
        //update book on database using the isbn number selected by user
        String insertQuery = "UPDATE books SET name = "+ refBook.getName() + " , author = "+ refBook.getAuthor() + ", publisher = "+ refBook.getPublisher() + ", category = "+ refBook.getCategory() + ", make_year = "+ refBook.getYear() + ", total_in_stock = "+ refBook.getUnit() + ", cost_per_unit = "+ refBook.getPrice() + " WHERE isbn = " +isbn+";";
        
          try{
              Connection con = DriverManager.getConnection(url, uname, password);
              Statement stmt = con.createStatement();
              stmt.executeUpdate(insertQuery);
              con.close();
          }catch (SQLException e){
              e.printStackTrace() ;
          }
        return true;
      } else {
        System.out.println("!! No such index");
        System.out.println(
          "-----------------------------------------------------------"
        );
        return false;
      }
    }
  }*/

  public boolean update_details1() {
	  String uname = "root";
	  String password = "Hotwings88$";
      String url = "jdbc:mysql://localhost:3306/test_schema";
      try {
			Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e) {
          System.out.println("Where is your MySQL JDBC Driver?");
          e.printStackTrace();
      }
/* */
      view_books1();
      System.out.println("\nEnter the isbn of the book you want to remove: ");
      long ISBN = input.nextLong();

      //temp <= bookInventory.size() && temp > 0
      
        //BookType refBook = bookInventory.get(temp - 1);

        System.out.println(
          "What do you want to update regarding the book ?\n 1) Name 2)Author 3) Publisher 4) Cost 6)Make Year 7)Total units available"
        );
   
        
        switch (input.nextInt()) {
          case 1:
            System.out.println("Enter new name of the book: ");
            input.nextLine();// move the buffer reader to next character instead of empty space 
            String temp = input.nextLine();
             // !! reference  the input to new line as nextint() doesnot point to new line
            
            //update  theh name of the book using the temp variable comparing with the isbn using a prepared staeement
            String insertQuery = "UPDATE books SET name = ? WHERE isbn = ?;";
            
            try{
                Connection con = DriverManager.getConnection(url, uname, password);
                PreparedStatement stmt = con.prepareStatement(insertQuery);
                stmt.setString(1, temp);
                stmt.setLong(2, ISBN);
                
                stmt.executeUpdate();
                con.close();
            }catch (SQLException e){
                e.printStackTrace() ;
            }
            catch(Exception e) {
            	System.out.print(e);
            }
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books1();

            break;
          case 2:
            System.out.println("Enter new Author name of the book");
            input.nextLine();// move the buffer reader to next character instead of empty space 
            temp = input.nextLine();
             // !! reference  the input to new line as nextint() doesnot point to new line
            
            //update  theh name of the book using the temp variable comparing with the isbn using a prepared staeement
            insertQuery = "UPDATE books SET Author = ? WHERE isbn = ?;";
            
            try{
                Connection con = DriverManager.getConnection(url, uname, password);
                PreparedStatement stmt = con.prepareStatement(insertQuery);
                stmt.setString(1, temp);
                stmt.setLong(2, ISBN);
                
                stmt.executeUpdate();
                con.close();
            }catch (SQLException e){
                e.printStackTrace() ;
            }
            catch(Exception e) {
            	System.out.print(e);
            }
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books1();

            break;
          case 3:
            System.out.println("Enter new Publisher name of the book");
            input.nextLine();// move the buffer reader to next character instead of empty space 
            temp = input.nextLine();
             // !! reference  the input to new line as nextint() doesnot point to new line
            
            //update  theh name of the book using the temp variable comparing with the isbn using a prepared staeement
            insertQuery = "UPDATE books SET publisher = ? WHERE isbn = ?;";
            
            try{
                Connection con = DriverManager.getConnection(url, uname, password);
                PreparedStatement stmt = con.prepareStatement(insertQuery);
                stmt.setString(1, temp);
                stmt.setLong(2, ISBN);
                
                stmt.executeUpdate();
                con.close();
            }catch (SQLException e){
                e.printStackTrace() ;
            }
            catch(Exception e) {
            	System.out.print(e);
            }
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books1();
            break;
          case 4:
            System.out.println("Enter new Cost per unit of the book");
            temp = input.nextLine();
             // !! reference  the input to new line as nextint() doesnot point to new line
            
            //update  the name of the book using the temp variable comparing with the isbn using a prepared staeement
            insertQuery = "UPDATE books SET price = ? WHERE isbn = ?;";
            
            try{
                Connection con = DriverManager.getConnection(url, uname, password);
                PreparedStatement stmt = con.prepareStatement(insertQuery);
                stmt.setString(1, temp);
                stmt.setLong(2, ISBN);
                
                stmt.executeUpdate();
                con.close();
            }catch (SQLException e){
                e.printStackTrace() ;
            }
            catch(Exception e) {
            	System.out.print(e);
            }
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books1();
            break;
          /*case 5:
            System.out.println("Enter new ISBN of the book");
            refBook.SetISBN(input.nextInt());
            System.out.println(
              "---------------------- Updated list ----------------------"
            )
            view_books();
            break;*/
          case 6:
            System.out.println("Enter new Make Year of the book");
            temp = input.nextLine();
             // !! reference  the input to new line as nextint() doesnot point to new line
            
            //update  the name of the book using the temp variable comparing with the isbn using a prepared staeement
            insertQuery = "UPDATE books SET year = ? WHERE isbn = ?;";
            
            try{
                Connection con = DriverManager.getConnection(url, uname, password);
                PreparedStatement stmt = con.prepareStatement(insertQuery);
                stmt.setString(1, temp);
                stmt.setLong(2, ISBN);
                
                stmt.executeUpdate();
                con.close();
            }catch (SQLException e){
                e.printStackTrace() ;
            }
            catch(Exception e) {
            	System.out.print(e);
            }
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books1();
            break;
          case 7:
            System.out.println("Enter new total units of the book");
            temp = input.nextLine();
             // !! reference  the input to new line as nextint() doesnot point to new line
            
            //update  theh name of the book using the temp variable comparing with the isbn using a prepared staeement
            insertQuery = "UPDATE books SET total_units = ? WHERE isbn = ?;";
            
            try{
                Connection con = DriverManager.getConnection(url, uname, password);
                PreparedStatement stmt = con.prepareStatement(insertQuery);
                stmt.setString(1, temp);
                stmt.setLong(2, ISBN);
                
                stmt.executeUpdate();
                con.close();
            }catch (SQLException e){
                e.printStackTrace() ;
            }
            catch(Exception e) {
            	System.out.print(e);
            }
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
            view_books1();
            break;
          default:
            System.out.println("!! Not a valid  option");
            System.out.println(
              "-----------------------------------------------------------"
            );
            return false;
        }
        return true;
  // !! Functions for customers below:
    }
  
}
