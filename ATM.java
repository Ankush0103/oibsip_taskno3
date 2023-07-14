import java.util.Scanner;

public class ATM {
    private Account bank;
    private Scanner scanner;

    public ATM() {
        this.bank = new Account();
        this.scanner = new Scanner(System.in);
    }

    public boolean login() {
        System.out.print("User ID: ");
        String userID = scanner.nextLine();
        System.out.print("User PIN: ");
        String userPIN = scanner.nextLine();
        return bank.authenticateUser(userID, userPIN);
    }
    public void showTransactionHistory() {
        User currentUser = bank.getCurrentUser();
        System.out.println("Transaction history for " + currentUser.getFullName() + ":");
        for (String transaction : currentUser.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
    public void Withdraw() {
        User currentUser = bank.getCurrentUser();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (currentUser.withdraw(amount)) {
            System.out.println("Withdrawal successful, new Account balance: Rupees " + currentUser.getAccountBalance());
        } else {
            System.out.println("Insufficient money");
        }
    }
    public void Deposit() {
        User currentUser = bank.getCurrentUser();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        currentUser.deposit(amount);
        System.out.println("Deposit successful, new Account balance: Rupees " + currentUser.getAccountBalance());
    }

    public void Transfer() {
        User currentUser = bank.getCurrentUser();
        System.out.print("Enter recipient user ID: ");
        String recipientID = scanner.next();
        User recipient = bank.getUserByID(recipientID);
        if (recipient == null) {
            System.out.println("Recipient not found.");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (currentUser.transfer(amount, recipient)) {
            System.out.println("Transfer successful, new balance: Rupees " + currentUser.getAccountBalance());
        } else {
            System.out.println("Insufficient money.");
        }
    }
}
