import java.util.ArrayList;

/**
 * NotFacebook UserProfile
 *
 * This program creates user profiles
 * by taking in a username, email, and
 * password. Additionally, this program
 * contains methods that allow a user
 * to add and remove friends and block
 * and unblock users.
 *
 * @author Team 5, 19
 *
 * @version April 1, 2024
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
    //This method checks if the user has that freind if if not adds them to the friend list
    public void addFriend(UserProfile friend) {
        if (!friends.contains(friend)) {
            friends.add(friend);
        }
    }
    //This method removes the friend from the list
    public void removeFriend(UserProfile friend) {
        if (friends.contains(friend) {
            friends.remove(friend);
        }
        
    }
    //This method checks if that user is blocked if not it adds them to the block list
    public void addBlocked(UserProfile user) {
        if (!blocked.contains(user)) {
            blocked.add(user);
        }
    }
    //This method removes the user from the blocked list
    public void unblock(UserProfile user) {
        if (blocked.contains(user) {
            blocked.remove(user);
        }
    }
    //Gives a String representaion of the user info 
    public String toString() {
        return "Username: " + username + "\n" + "Email: " + email + "\n" + "Password: " + password + "\n" + "Friends: " + friends.size() + "\n" + "---------------" + "\n";
    }


}
