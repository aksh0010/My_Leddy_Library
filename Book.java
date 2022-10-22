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

  public Book() {}

  public Book(String a, String b, int c, double d) {
    this.name = a;
    this.author = b;
    this.isbn = c;
    this.price = d;
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
