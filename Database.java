import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Database {
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
                    users.add(new UserProfile(userProfileStuff[0], userProfileStuff[1], userProfileStuff[2]));
                } catch (Exception e) {
                    users.add(new UserProfile());
                }
            }
            bfr.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
