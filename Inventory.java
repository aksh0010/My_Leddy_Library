/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

  public static ArrayList<BookType> bookInventory = new ArrayList<>();
  public static Scanner input = new Scanner(System.in);

  // !! Add book
  // !! Returns String of all book name

  public String add_book() {
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
  public boolean remove_book() {
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
      view_books();
      System.out.println(
        "Choose an index of the book you want to remove from below list"
      );
      int user_choice;
      user_choice = input.nextInt();
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

  // !! Update details of individual object
  public boolean update_details() {
    if (bookInventory.size() == 0) {
      System.out.println("\n\nNo book in database to update details");
      System.out.println(
        "-----------------------------------------------------------"
      );
      return false;
    } else {
      view_books();
      System.out.println("Which book you want to update ( Choose index)");

      int temp = input.nextInt();

      if (temp <= bookInventory.size() && temp > 0) {
        BookType refBook = bookInventory.get(temp - 1);

        System.out.println(
          "What do you want to update regarding the book ?\n 1) Name 2)Author 3) Publisher 4) Cost 5) ISBN 6)Make Year 7)Total units available"
        );

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
          case 5:
            System.out.println("Enter new ISBN of the book");
            refBook.SetISBN(input.nextInt());
            System.out.println(
              "---------------------- Updated list ----------------------"
            );
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
        return true;
      } else {
        System.out.println("!! No such index");
        System.out.println(
          "-----------------------------------------------------------"
        );
        return false;
      }
    }
  }
  // !! Functions for customers below:

}