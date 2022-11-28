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
        System.out.println(
          "--------------------------------------------------- "
        );
        System.out.println(
          "\n 1) View my Account \n 2) View Books avaibale in the Store \n 3) Update my account \n 4) Wishlist \n 5) Borrowed Book \n 6) Purchase a book \n 7) Quit\n"
        );
        System.out.print("\nChoose an option to perform ? ");
        user_choice = main_menu_input.nextInt();
        System.out.println();

        switch (user_choice) {
          case 1: // !! __________________________________ View Account  ______________________________________________
            c1.View_account();
            break;
          case 2: // !! __________________________________ View Available books in store __________________________________
            sInventory.view_books();
            break;
          case 3: // !! __________________________________ Update my account  __________________________________
            c1.update_account();
            break;
          case 4: // !! __________________________________ WISH LIST __________________________________
            System.out.println(
              "1)To view books\n2)Add to Wishlist\n3)Go back "
            );
            switch (main_menu_input.nextInt()) {
              case 1:
                c1.view_wishlist();
                break;
              case 2:
                sInventory.view_books();
                System.out.print(
                  "Choose an index of the book to add to your wishlist : "
                );
                int temp = main_menu_input.nextInt(); // !! Input for reference for book user wants
                System.out.println();
                System.out.print("Enter no of unit for the book : ");
                int unit = main_menu_input.nextInt();
                System.out.println();

                if (
                  temp > 0 &&
                  unit > 0 &&
                  temp < sInventory.bookInventory.size() - 1
                ) {
                  BookType refBook = sInventory.bookInventory.get(temp);
                  c1.add_to_wishlist(refBook, unit);
                } else {
                  System.out.println(" Please enter values correctly.");
                }
              case 3:
                break;
              default:
                System.out.println(" No such option");
            }
            // c1.view_wishlist();
            break;
          case 5: // !! __________________________________ Borrowed LIST __________________________________
            System.out.println(
              " 1) To view Borrowed books\n 2) Borrow a book ! \n 3) Go back "
            );
            switch (main_menu_input.nextInt()) {
              case 1:
                c1.view_Borrowed_books();
                break;
              case 2:
                sInventory.view_books();
                System.out.print(
                  " Choose an index of the book you want to borrow : "
                );
                int temp = main_menu_input.nextInt(); // !! Input for reference for book user wants
                System.out.println();
                System.out.print(" Enter no of unit for the book : ");
                System.out.println();

                int unit = main_menu_input.nextInt();
                if (
                  temp > 0 &&
                  unit > 0 &&
                  temp < sInventory.bookInventory.size() - 1
                ) {
                  BookType refBook = sInventory.bookInventory.get(temp);
                  c1.add_to_borrowedList(refBook, unit);
                } else {
                  System.out.println(" Please enter values correctly.");
                }

                break;
              case 3:
                break;
              default:
                System.out.println(" No such option");
            }
            break;
          case 6: // !! __________________________________ Purchase a book   __________________________________
            c1.view_bought_books();
            break;
          case 7: // !! __________________________________ Exit __________________________________
            loop_Condition = false;
            break;
          default:
            System.out.println("\n No such option \n\n");
        }
      } while (loop_Condition);
      System.out.println("\n\n Good Bye ! \n");
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
        "\n*****************Index number doesnot exist |" +
        e +
        "|*****************\n\n"
      );
    } catch (Exception e) {
      System.err.println(
        "\n***************** Error caught |" + e + "|*****************\n\n"
      );
    }

    // input.close();
    main_menu_input.close();
  }
}
