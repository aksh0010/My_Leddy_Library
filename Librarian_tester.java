/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Librarian_tester {

  public static void main(String[] args) {
    Inventory sInventory = new Inventory();
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
        System.out.println("Choose an option to perform ? ");
        System.out.println(
          "1) View Inventory \n2) Add new books \n3) Remove books \n4) Update information for exisiting book\n5) Add User Account \n7) Quit"
        );
        user_choice = main_menu_input.nextInt();

        switch (user_choice) {
          case 1: // !! __________________________________View Inventory __________________________________
            sInventory.view_books1();
            break;
          case 2: // !! __________________________________ Add new books__________________________________
            sInventory.add_book();
            break;
          case 3: // !! __________________________________Remove books __________________________________
            sInventory.remove_book1();
            break;
          case 4: // !! __________________________________ Update information of a book__________________________________
            sInventory.update_details1();
            break;
          case 5: // !! __________________________________ Add user __________________________________
            c1.add_user();
            break;
            /* 
          case 6: // !! __________________________________ Delete user __________________________________
            c1.delete_user();
            break;*/
          case 7: // !! __________________________________ quit __________________________________
            loop_Condition = false;
            break;
          default:
            System.out.println("No such option \n\n");
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
