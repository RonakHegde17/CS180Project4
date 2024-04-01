import java.util.ArrayList;

/**
 * NotFacebook DatabaseInterface
 *
 * brief description of the program
 *
 * @author your name, section number
 *
 * @version date of completion
 *
 */

public interface DatabaseInterface {
    public boolean readFile();
    public boolean writeFile();
    public ArrayList<UserProfile> searchUsers(String userSearch);
    public String viewUser(UserProfile user);
    public boolean addUser(UserProfile user);
    public boolean removeUser(UserProfile user);

}
