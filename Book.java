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
  public Book(
    String name,
    String author,
    int isbn,
    double cost,
    String publisher,
    int year
  ) {
    this.name = name;
    this.author = author;
    this.isbn = isbn;
    this.price = cost;
    this.publisher = publisher;
    this.year = year;
  }

  // Setter methods
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

  public void SetPublisher(String a) {
    this.publisher = a;
  }

  public void SetYear(int a) {
    this.year = a;
  }

  //   getter methods

  public String getName(String a) {
    return this.name;
  }

  public String getAuthor(String a) {
    return this.author;
  }

  public int getISBN(int a) {
    return this.isbn;
  }

  public double getPrice(double a) {
    return this.price;
  }

  public String getPublisher(String a) {
    return this.publisher;
  }

  public int getYear(int a) {
    return this.year;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }
}
