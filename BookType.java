/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */

public class BookType extends Book {

  String category;

  public BookType() {
    super();
    this.category = "";
  }

  public BookType(String category) {
    super();
    this.category = category;
  }

  // Setter methods
  public void SetCategory(String a) {
    this.category = a;
  }

  // Getter methods
  public String getCategory() {
    return this.category;
  }
}
