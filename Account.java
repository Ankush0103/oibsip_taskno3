import java.util.ArrayList;
public class Account {
    private ArrayList<User> users;
    private User currentUser;
    public Account() {
        this.users = new ArrayList<>();
        this.currentUser = null;
        users.add(new User("user1", "1234", "Account1",  1000.0));
        users.add(new User("user2", "5678", "Account2",  500.0));
    }

    public boolean authenticateUser(String userID, String userPIN) {
        for (User user : users) {
            if (user.getUserID().equals(userID) && user.authenticate(userPIN)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getUserByID(String userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }
}
