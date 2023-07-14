import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM");

        ATM atm = new ATM();
        while (true) {
            if (atm.login()) {
                while (true) {
                    System.out.println("Choose an option:");
                    System.out.println("1. View transaction history");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");
                    System.out.print("Enter your Choice: ");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            atm.showTransactionHistory();
                            break;
                        case 2:
                            atm.Withdraw();
                            break;
                        case 3:
                            atm.Deposit();
                            break;
                        case 4:
                            atm.Transfer();
                            break;
                        case 5:
                            System.out.println("Thank You for Using ATM. Have a Good Day!");
                            return;
                        default:
                            System.out.println("Enter correct choice");
                            break;
                    }
                }
            }
            else {
                System.out.println("Invalid user ID or PIN, please try again");
            }

        }
    }
}

