/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer_tester {

  public static void main(String[] args) throws ParseException {
    // !!_____________________________________________________________________
    // !! Creating books and adding them to inventory
    Inventory sInventory = new Inventory(); // !! this is empty inventory

    BookType b1 = new BookType("Science");
    b1.Set_all("Agile", "Aksh", 123456, 25, "UWindsor", 2020, 10);

    BookType b2 = new BookType("Science1");
    b2.Set_all("Agile1", "Aksh", 123456, 25, "UWindsor", 2020, 10);

    BookType b3 = new BookType("Science2");
    b3.Set_all("Agile2", "Aksh", 123456, 25, "UWindsor", 2020, 10);

    sInventory.add_book(b1);
    sInventory.add_book(b2);
    sInventory.add_book(b3);
    // !!_____________________________________________________________________
    Customer_Account c1 = new Customer_Account( // !! Hard creating customer account with details
      "Aksh",
      "Patel",
      "10/08/2001",
      "aksh@gmail.com",
      12345678
    );

    // !! Printing List of all items for user

    Scanner main_menu_input = new Scanner(System.in);

    try {
      int user_choice;
      Boolean loop_Condition = true;
      System.out.println(
        "---------------------- Welcome ---------------------- "
      );
      do {
        System.out.println("\nChoose an option to perform ? ");
        System.out.println(
          "\n1) View my Account \n2) View Books avaibale in the Store \n3) Update my account \n4)Wishlist \n5)Borrowed Book \n6) Books Purchased so far\n7) Quit\n"
        );
        user_choice = main_menu_input.nextInt();

        switch (user_choice) {
          case 1: // !! __________________________________ View Account  __________________________________
            c1.View_account();
            break;
          case 2: // !! __________________________________ View Available books in store __________________________________
            sInventory.view_books();
            break;
          case 3: // !! __________________________________ Update my account  __________________________________
            c1.update_account();
            break;
          case 4: // !! __________________________________ WISH LIST __________________________________
            System.out.println("1)To view books\n2)Add to Wishlist");
            switch (main_menu_input.nextInt()) {
              case 1:
                c1.view_wishlist();
                break;
              case 2:
                sInventory.view_books();
                System.out.println(
                  "Choose an index of the book to add to your wishlist"
                );
                int temp = main_menu_input.nextInt(); // !! Input for reference for book user wants
                System.out.println("Enter no of unit for the book");
                int unit = main_menu_input.nextInt();
                if (
                  temp > 0 &&
                  unit > 0 &&
                  temp < sInventory.bookInventory.size() - 1
                ) {
                  BookType refBook = sInventory.bookInventory.get(temp);
                  c1.add_to_wishlist(refBook, unit);
                } else {
                  System.out.println("Please enter values correctly.");
                }

                break;
              default:
                System.out.println("No such option");
            }
            // c1.view_wishlist();
            break;
          case 5: // !! __________________________________ Borrowed LIST __________________________________
            c1.view_Borrowed_books(); // !! Working hereeee
            break;
          case 6: // !! __________________________________ Purchased history  __________________________________
            c1.view_bought_books();
            break;
          case 7: // !! __________________________________ Exit __________________________________
            loop_Condition = false;
            break;
          default:
            System.out.println("\nNo such option \n\n");
        }
      } while (loop_Condition);
      System.out.println("\n\nGood Bye ! \n");
      System.out.println(
        "-----------------------------------------------------------"
      );
    } catch (InputMismatchException e) {
      System.err.println(
        "***************** You have entered wrong format of input |" +
        e +
        "|*****************\n\n"
      );
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println(
        "*****************Index number doesnot exist |" +
        e +
        "|*****************\n\n"
      );
    } catch (Exception e) {
      System.err.println(
        "***************** Error caught |" + e + "|*****************\n\n"
      );
    }

    // input.close();
    main_menu_input.close();
  }
}
