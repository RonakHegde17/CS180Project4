import java.util.ArrayList;

public class UserProfile {
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

}
