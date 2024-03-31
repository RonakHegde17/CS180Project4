import java.util.ArrayList;

public interface DatabaseInterface {
    public boolean readFile();
    public ArrayList<UserProfile> searchUsers(String userSearch);
    public String viewUser(UserProfile user);
    
}
