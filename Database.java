import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Database implements DatabaseInterface{
    private ArrayList<UserProfile> users;
    private String userIn;

    public Database(String userIn) {
        this.userIn = userIn;
        this.users = null;
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
                    users.add(new UserProfile(userProfileStuff[0], userProfileStuff[1], userProfileStuff[2]));
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
