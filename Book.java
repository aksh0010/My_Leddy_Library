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
  int total_units;

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
    int year,
    int total_units
  ) {
    this.name = name;
    this.author = author;
    this.isbn = isbn;
    this.price = cost;
    this.publisher = publisher;
    this.year = year;
    this.total_units = total_units;
  }

  // Setter methods
  public void Set_all(
    String name,
    String author,
    int isbn,
    double cost,
    String publisher,
    int year,
    int total_units
  ) {
    this.name = name;
    this.author = author;
    this.isbn = isbn;
    this.price = cost;
    this.publisher = publisher;
    this.year = year;
    this.total_units = total_units;
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

  public void SetPublisher(String a) {
    this.publisher = a;
  }

  public void SetYear(int a) {
    this.year = a;
  }

  public void SetUnit(int a) {
    this.total_units = a;
  }

  //   getter methods

  public String getName() {
    return this.name;
  }

  public String getAuthor() {
    return this.author;
  }

  public int getISBN() {
    return this.isbn;
  }

  public double getPrice() {
    return this.price;
  }

  public String getPublisher() {
    return this.publisher;
  }

  public int getYear() {
    return this.year;
  }

  public int getUnit() {
    return this.total_units;
  }

  @Override
  public String toString() {
    return (
      this.name.toUpperCase() +
      " | " +
      this.author.toUpperCase() +
      ", ISBN" +
      this.isbn +
      "|" +
      this.publisher.toUpperCase() +
      " in " +
      this.year +
      ", Cost " +
      this.price +
      "CAD" +
      ",Total available :" +
      this.total_units +
      " Category"
    );
  }
  /**
   * @param args
   */
}
