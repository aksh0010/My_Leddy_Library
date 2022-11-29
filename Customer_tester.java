/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer_tester {
  
  public static void main(String[] args) throws ParseException {
  String uname = "root";
  String password = "Hotwings88$";
  String url = "jdbc:mysql://localhost:3306/test_schema";

    // !!_____________________________________________________________________
    // !! Creating books and adding them to inventory
    Inventory sInventory = new Inventory(); // !! this is empty inventory

    // !!_____________________________________________________________________
    Customer_Account c1 = new Customer_Account( // !! Hard creating customer account with details
    );

    // !! Printing List of all items for user
    
    Scanner main_menu_input = new Scanner(System.in);
    System.out.println("Enter a email to login: ");
    String userEmail = main_menu_input.nextLine();

    try {
      System.out.println(
        "------------------- Welcome------------------- "
      );
      int user_choice;
      Boolean loop_Condition = true;
      do {
     
        System.out.println(
          "--------------------------------------------------- "
        );
        System.out.println(
          "\n 1) View my Account \n 2) View Books avaibale in the Store \n 3) Update my account \n 4) Wishlist \n 5) Borrowed Book \n 6) Purchase a book \n 7) Quit\n"
        );
        System.out.println(
          "\n--------------------------------------------------- "
        );
        System.out.print("\nChoose an option to perform ? ");
        System.out.println(
          "\n--------------------------------------------------- "
        );
        user_choice = main_menu_input.nextInt();
        System.out.println();

        switch (user_choice) {
          case 1: // !! __________________________________ View Account  ______________________________________________
          
            c1.View_account1(userEmail); //maybe use username
            break;
          case 2: // !! __________________________________ View Available books in store __________________________________
            sInventory.view_books1();
            break;
          case 3: // !! __________________________________ Update my account  __________________________________
            c1.update_account(userEmail);
            break;
          case 4: // !! __________________________________ WISH LIST __________________________________
            System.out.println(
              "1)To view books\n2)Add to Wishlist\n3)Remove from Wishlist\n4)Go back "
            );
            switch (main_menu_input.nextInt()) {
              case 1:
                c1.view_wishlist1(userEmail);
                break;
              case 2:
                sInventory.view_books1();

                System.out.print(
                  " Choose an ISBN of the book you want to add to your wishlist: "
                );
                long user_isbn = main_menu_input.nextLong();
                c1.add_to_wishlist1(userEmail, user_isbn);
                /*
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
                }*/
                break;
              case 3:
                sInventory.view_books1();

                System.out.print(
                  " Choose an ISBN of the book you want to add to your wishlist: "
                );
                long user_isbn1 = main_menu_input.nextLong();
                c1.remove_from_wishlist1(userEmail, user_isbn1); 
                break;
              case 4:
                break;
              default:
                System.out.println(" No such option");
            }
            // c1.view_wishlist();
            break;
          case 5: // !! __________________________________ Borrowed LIST __________________________________
            System.out.println(
              " 1) To view Borrowed books\n 2) Borrow a book ! \n3) Return borrowed book ! \n 4) Go back "
            );
            switch (main_menu_input.nextInt()) {
              case 1:
               //sInventory.view_books1();
               c1.view_Borrowed_books1(userEmail);
                break;
              case 2:
                sInventory.view_books1();
                System.out.print(
                  " Choose an ISBN of the book you want to borrow : "
                );
                long user_isbn = main_menu_input.nextLong(); // !! Input for reference for book user wants

               
                //scan for email
                c1.add_to_borrowedList1(userEmail, user_isbn);

                break;
              case 3:
                sInventory.view_books1();
                System.out.print(
                " Enter the ISBN of the book you want to return: "
                );
                long user_isbn1 = main_menu_input.nextLong();
                c1.return_borrowed_book(userEmail,user_isbn1);
                break;
              case 4:
                break;
              default:
                System.out.println(" No such option");
            }
            break;
          case 6: // !! __________________________________ Purchase a book   __________________________________
            sInventory.view_books1();
            System.out.println(
              "\n--------------------------------------------------- "
               );
            System.out.print(
            "Choose an ISBN of the book you want to purchase : \n "
            );
            long user_isbn = main_menu_input.nextLong();

            System.out.println(
           "\n--------------------------------------------------- "
            );
            c1.buy_book(userEmail, user_isbn);
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
