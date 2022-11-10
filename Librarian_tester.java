/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Librarian_tester {

  public static void main(String[] args) {
    Inventory sInventory = new Inventory();

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
          "1) View Inventory \n2) Add new books \n3) Remove books \n4) Update information for exisiting book\n5) Quit"
        );
        user_choice = main_menu_input.nextInt();

        switch (user_choice) {
          case 1:
            sInventory.view_books();
            break;
          case 2:
            sInventory.add_book();
            break;
          case 3:
            sInventory.remove_book();
            break;
          case 4:
            sInventory.update_details();
            break;
          case 5:
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
