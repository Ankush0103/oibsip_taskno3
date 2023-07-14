import java.util.ArrayList;
public class User {

    private String userID;
    private String userPIN;
    private String Name;
    private double accountBalance;
    private ArrayList<String> transactionHistory;
    public User(String userID, String userPIN, String Name, double initialBalance) {
        this.userID = userID;
        this.userPIN = userPIN;
        this.Name = Name;
        this.accountBalance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }
    public boolean authenticate(String userPIN) {
        return this.userPIN.equals(userPIN);
    }
    public boolean withdraw(double amount) {
        if (amount > accountBalance) {
            return false;
        } else {
            accountBalance -= amount;
            String transaction = "Withdrawal: Rupees " + amount + " , New balance: Rupees " + accountBalance;
            transactionHistory.add(transaction);
            return true;
        }
    }
    public void deposit(double amount) {
        accountBalance += amount;
        String transaction = "Deposit: Rupees " + amount + " , New balance: Rupees " + accountBalance;
        transactionHistory.add(transaction);
    }
    public boolean transfer(double amount, User recipient) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            recipient.deposit(amount);
            transactionHistory.add("Transfer of rupees " + amount + " to " + recipient.getUserID() + " New Account Balance: Rupees " + accountBalance);
            return true;
        } else {
            return false;
        }
    }
    public String getUserID() {
        return userID;
    }

    public String getName() {
        return Name;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }
    public String getFullName() {
        return Name + " " ;
    }
}

