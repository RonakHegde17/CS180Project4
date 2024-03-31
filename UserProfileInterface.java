import java.util.ArrayList;

public interface UserProfileInterface {
    public String getUsername();
    public void setUsername(String username);
    public String getEmail();
    public void setEmail(String email);
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
