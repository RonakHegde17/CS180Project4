import java.io.*;
import java.util.ArrayList;

/**
 * NotFacebook Database
 *
 * brief description of the program
 *
 * @author your name, section number
 *
 * @version date of completion
 *
 */

public class Database implements DatabaseInterface{
    private ArrayList<UserProfile> users;
    private String outputFile;

    public Database(String outputFile) {
        this.outputFile = outputFile;
        this.users = new ArrayList<>();
    }

    public void createFile() { //This method is used to create the database.txt file when none exists
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, true)));
            pw.flush();
            pw.close();
        } catch (Exception e) {e.printStackTrace();
        }
    }

    public boolean writeFile1(String username, String password) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, true)));
            pw.write("Username: " + username + " " +  "\n"  + "Password: " + password + " " +  "\n" + "Friends: " + "0" + "\n" + "---------------" + "\n");
            pw.flush();
            pw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean readFile1(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Username: " + username + " ")) {
                    System.out.println("Username is already in use!");;
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;
    }

    public boolean readFile2(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Username: " + username + " ")) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean readFile3(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Username: " + username + " ")) {
                    line = br.readLine();
                    if (line.startsWith("Password: " + password + " ")) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
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
            BufferedReader bfr = new BufferedReader(new FileReader(outputFile));
            String line = "";
            while ((line = bfr.readLine()) != null) {
                try {
                    String[] userProfileStuff = line.split(",", -1);
                    for (int i = 0; i < users.size(); i++) {
                        if ((userProfileStuff[0].equals(users.get(i).getUsername()))) {
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
                    if ((user.getUsername().equals(users.get(i).getUsername()))) {
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
