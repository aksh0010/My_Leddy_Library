/**
 *
 */

/**
 * @author akshr
 *
 */
public class Book {

  String name;
  String author;
  int isbn; // unique
  double price;
  String publisher;
  int year;

  public Book() {}

  /**
 * @param name
 * @param author
 * @param isbn
 * @param cost
 * @param publisher
 * @param year
 */
public Book(String name, String author, int isbn, double cost, String publisher, int year) {
    this.name = name;
    this.author = author;
    this.isbn = isbn;
    this.price = cost;
	this.publisher =publisher;
	this.year=year;
  }

  public void SetName(String a) {
    this.name = a;
  }

  public void SetAuthor(String a) {
    this.author = a;
  }

  public void SetISBN(int a) {
    this.isbn = a;
  }

  public void SetPrice(double a) {
    this.price = a;
  }

//   public void print_book() {}

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
}
