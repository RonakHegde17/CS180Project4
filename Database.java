import java.io.*;
import java.util.ArrayList;

/**
 * NotFacebook Database
 *
 * This program creates a database
 * that contains user profiles by
 * reading a file to create users 
 * and then writing to a file the
 * users in the database. This program
 * contains methods that allow the adding
 * and removing of users and the ability
 * to search and view users.
 *
 * @author Team 5, 19
 *
 * @version April 1, 2024
 *
 */

public class Database implements DatabaseInterface{
    private ArrayList<UserProfile> users;
    private String userIn;
    private String outputFile;

    public Database(String userIn, String outputFile) {
        this.userIn = userIn;
        this.users = null;
        this.outputFile = outputFile;
    }

    public boolean writeFile() {
        try {
            String line = "";
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
            for (int i = 0; i < users.size(); i++) {
                pw.println(users.get(i).toString());
            }
            pw.flush();
            pw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean readFile() {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(userIn));
            String line = "";
            while ((line = bfr.readLine()) != null) {
                try {
                    String[] userProfileStuff = line.split(",", -1);
                    for (int i = 0; i < users.size(); i++) {
                        if ((userProfileStuff[0].equals(users.get(i).getUsername())) ||
                                (userProfileStuff[1].equals(users.get(i).getEmail()))) {
                            throw new Exception();
                        }
                    }
                } catch (Exception e) {
                    users.add(new UserProfile());
                }
            }
            bfr.close();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername() == null || users.get(i).getUsername().isEmpty()) {
                    users.remove(users.get(i));
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<UserProfile> searchUsers(String userSearch) {
        ArrayList<UserProfile> possibleUsers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().contains(userSearch)) {
                possibleUsers.add(users.get(i));
            }
        }
        return possibleUsers;
    }

    public String viewUser(UserProfile user) {
        if (users.contains(user)) {
            return user.toString();
        } else {
            return "User Does Not Exist\n";
        }
    }

    public boolean addUser(UserProfile user) {
        if (!(users.contains(user))) {
            try {
                for (int i = 0; i < users.size(); i++) {
                    if ((user.getUsername().equals(users.get(i).getUsername())) ||
                            (user.getEmail().equals(users.get(i).getEmail()))) {
                        throw new Exception();
                    }
                }
                users.add(user);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean removeUser(UserProfile user) {
        if (users.contains(user)) {
            users.remove(user);
            return true;
        } else {
            return false;
        }
    }
}
