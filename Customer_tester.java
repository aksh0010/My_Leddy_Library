/**
 * @author Aksh Patel
 * @author Liam Richter Gorey
 */
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer_tester {

  public static void main(String[] args) throws ParseException {
    Inventory sInventory = new Inventory();

    Customer_Account c1 = new Customer_Account(
      "Aksh",
      "Patel",
      "10/08/2001",
      "aksh@gmail.com",
      12345678
    );
    // !! Printing List of a ll items for user

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
          "\n1) View my Account \n2) View Books avaibale in the Store \n3) Update my account \n4) Quit"
        );
        user_choice = main_menu_input.nextInt();

        switch (user_choice) {
          case 1:
            c1.View_account();
            break;
          case 2:
            sInventory.view_books();
            break;
          case 3:
            c1.update_account();
            break;
          case 4:
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
