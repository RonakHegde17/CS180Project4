import java.util.ArrayList;

/**
 * NotFacebook DatabaseInterface
 *
 * This program is the interface
 * for the database class.
 *
 * @author Team 5, 19
 *
 * @version April 1, 2024
 *
 */

public interface DatabaseInterface {
    public void createFile();
    public boolean readFile();
    public boolean readFile1();
    public boolean readFile2();
    public boolean readFile3();
    public boolean writeFile();
    public boolean writeFile1();
    public ArrayList<UserProfile> searchUsers(String userSearch);
    public String viewUser(UserProfile user);
    public boolean addUser(UserProfile user);
    public boolean removeUser(UserProfile user);

}
