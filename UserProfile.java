import java.util.ArrayList;

/**
 * NotFacebook UserProfile
 *
 * brief description of the program
 *
 * @author your name, section number
 *
 * @version date of completion
 *
 */
public class UserProfile implements UserProfileInterface {
    private String username;

    private String email;

    private String password;

    private ArrayList<UserProfile> friends;

    private ArrayList<UserProfile> blocked;

    public UserProfile(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.friends = new ArrayList<UserProfile>();
        this.blocked = new ArrayList<UserProfile>();
    }

    public UserProfile() {
        this.username = "";
        this.email = "";
        this.password = "";
        this.friends = null;
        this.blocked = null;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<UserProfile> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<UserProfile> friends) {
        this.friends = friends;
    }

    public ArrayList<UserProfile> getBlocked() {
        return blocked;
    }

    public void setBlocked(ArrayList<UserProfile> blocked) {
        this.blocked = blocked;
    }
    public void addFriend(UserProfile friend) {
        if (!friends.contains(friend)) {
            friends.add(friend);
        }
    }

    public void removeFriend(UserProfile friend) {
        friends.remove(friend);
    }

    public void addBlocked(UserProfile user) {
        if (!blocked.contains(user)) {
            blocked.add(user);
        }
    }

    public void unblock(UserProfile user) {
        blocked.remove(user);
    }

    public String toString() {
        return "Username: " + username + "\n" + "Email: " + email + "\n" + "Password: " + password + "\n" + "Friends: " + friends.size() + "\n" + "---------------" + "\n";
    }


}
