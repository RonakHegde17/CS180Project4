import java.util.ArrayList;

/**
 * NotFacebook UserProfileInterface
 *
 * This program is the interface for
 * the UserProfile class.
 *
 * @author Team 5, 19
 *
 * @version April 1, 2024
 *
 */

public interface UserProfileInterface {
    public String getUsername();
    public void setUsername(String username);
    public String getPassword();
    public void setPassword(String password);
    public ArrayList<UserProfile> getFriends();
    public void setFriends(ArrayList<UserProfile> friends);
    public void addFriend(UserProfile friend);
    public void removeFriend(UserProfile friend);
    public ArrayList<UserProfile> getBlocked();
    public void setBlocked(ArrayList<UserProfile> blocked);
    public void addBlocked(UserProfile user);
    public void unblock(UserProfile user);
}
