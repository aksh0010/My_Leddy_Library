/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */
public class Book {

  String name;
  String author;
  long isbn; // !! unique
  double price;
  String publisher;
  int year;
  int total_units;
  boolean available = false;

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
    long isbn,
    double cost,
    String publisher,
    int year,
    int total_units,
    boolean available
  ) {
    this.name = name;
    this.author = author;
    this.isbn = isbn;
    this.price = cost;
    this.publisher = publisher;
    this.year = year;
    this.total_units = total_units;
    this.available = available;
  }

  // !! Setter methods
  public void Set_all(
    String name,
    String author,
    long isbn,
    double cost,
    String publisher,
    int year,
    int total_units,
    boolean available
  ) {
    this.name = name;
    this.author = author;
    this.isbn = isbn;
    this.price = cost;
    this.publisher = publisher;
    this.year = year;
    this.total_units = total_units;
    this.available = available;
  }

  public void SetName(String a) {
    this.name = a;
  }

  public void SetAuthor(String a) {
    this.author = a;
  }

  public void SetISBN(long a) {
    if (a > 0) this.isbn = a;
  }

  public void SetPrice(double a) {
    if (a >= 0) this.price = a;
  }

  public void SetPublisher(String a) {
    this.publisher = a;
  }

  public void SetYear(int a) {
    if (a > 0) this.year = a;
  }

  public void SetUnit(int a) {
    if (a >= 0) {
      this.total_units = a;
      calc_Availability();
    }
  }

  public void setAvailability(boolean a) {
    this.available = a;
  }

  //   !! getter methods

  public String getName() {
    return this.name;
  }

  public String getAuthor() {
    return this.author;
  }

  public long getISBN() {
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

  public void calc_Availability() {
    if (total_units > 0) {
      this.available = true;
    }
  }

  public boolean getAvailability() {
    return this.available;
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
      " Category "
    );
  }
  /**
   * @param args
   */
  //Remove a book from
}
