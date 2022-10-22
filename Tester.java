import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

  public static void main(String[] args) {
    ArrayList<BookType> bookInventory = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    System.out.println("How many books you want to add ? ");

    int total_books = input.nextInt();
    for (int i = 0; i < total_books; i++) {
      //   String loop_book_type = "bookType" + i;
      BookType loop_book_type = new BookType();
      System.out.println(
        "What is the Category(Science, Chemistry, Physics ...) of the book ?"
      );
      loop_book_type.SetCategory(input.nextLine());

      System.out.println("What is the Title of the book ?");
      loop_book_type.SetName(input.nextLine());

      System.out.println("Who is the author of the book ?");
      loop_book_type.SetAuthor(input.nextLine());

      System.out.println("What is the ISBN of the book ?");
      loop_book_type.SetISBN(input.nextInt());

      System.out.println("Who is the publisher of the book ?");
      loop_book_type.SetPublisher(input.nextLine());
      System.out.println("What is the make year of the book ?");
      loop_book_type.SetYear(input.nextInt());

      System.out.println("How many units in total do we have ?");
      loop_book_type.SetUnit(input.nextInt());

      System.out.println(
        "What is the cost of each units in Canadian Dollars ?"
      );
      loop_book_type.SetPrice(input.nextDouble());

      System.out.println(
        "What is the cost of each units in Canadian Dollars ?"
      );
      loop_book_type.SetPrice(input.nextDouble());

      bookInventory.add(loop_book_type);
    }
    for (BookType a : bookInventory) {
      System.out.println(a);
    }

    System.out.println(bookInventory.get(0));

    // BookType b1 = new BookType("Science");
    // b1.Set_all("Agile", "Aksh", 123456, 500, "Uwindsor", 2000, 10);

    // BookType b2 = new BookType("Science");
    // b2.Set_all("Cyber", "Patel", 123456, 500, "Uwindsor", 2000, 10);
    // bookInventory.add(b1);
    // bookInventory.add(b2);

    // System.out.println(bookInventory);

    input.close();
  }
}
