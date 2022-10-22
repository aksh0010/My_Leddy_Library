import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

  public static ArrayList<BookType> bookInventory = new ArrayList<>();
  public static Scanner input = new Scanner(System.in);

  // !! Add book

  public static void add_book() {
    System.out.println("\nHow many books you want to add ? ");

    int total_books = input.nextInt();
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
      loop_book_type.SetISBN(input.nextInt());

      System.out.println("What is the make year of the book ?");
      loop_book_type.SetYear(input.nextInt());

      System.out.println("How many units in total do we have ?");
      loop_book_type.SetUnit(input.nextInt());

      System.out.println(
        "What is the cost of each units in Canadian Dollars ?"
      );
      loop_book_type.SetPrice(input.nextDouble());

      bookInventory.add(loop_book_type);
    }
    // input.close();
  }

  // !! Remove book
  public static void remove_book() {
    // Scanner input = new Scanner(System.in);

    System.out.println(
      "Choose an index of the book you want to remove from below list"
    );
    view_books();
    int user_choice;
    user_choice = input.nextInt();
    if (user_choice <= bookInventory.size() && user_choice > 0) {
      System.out.println("Book Removed from the inventory");
      bookInventory.remove(user_choice - 1);
    } else {
      System.out.println("No Such Index");
    }
    view_books();
  }

  public static void view_books() {
    int i = 1; // !! variable i is used to iterated using index for arraylist
    for (BookType a : bookInventory) {
      System.out.println("(" + i + ") " + a);
      i++;
    }
  }

  public static void main(String[] args) {
    // !! Printing List of all items for user
    view_books();
    add_book();
    remove_book();
    
    // for (BookType a : bookInventory) {
    //   System.out.println(a);
    // }

    input.close();
  }
}
