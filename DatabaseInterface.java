import java.util.ArrayList;

public interface DatabaseInterface {
    public boolean readFile();
    public boolean writeFile();
    public ArrayList<UserProfile> searchUsers(String userSearch);
    public String viewUser(UserProfile user);
    public boolean addUser(UserProfile user);
    public boolean removeUser(UserProfile user);

}
