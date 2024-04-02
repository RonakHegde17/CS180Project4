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
    public void createFile();
    public boolean readFile();
    public boolean readFile1(String username);
    public boolean readFile2(String username);
    public boolean readFile3(String username, String password);
    public boolean deleteUser(String username);
    public boolean writeFile();
    public boolean writeFile1(String username, String password);
    public ArrayList<UserProfile> searchUsers(String userSearch);
    public String viewUser(UserProfile user);
    public boolean addUser(UserProfile user);
    public boolean removeUser(UserProfile user);

}
