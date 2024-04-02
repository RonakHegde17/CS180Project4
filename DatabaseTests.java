import java.io.*;
import java.util.ArrayList;

/**
 * NotFacebook DatabaseTests
 * This program contains tests to verify the functionality of the database methods.
 * It contains 5 tests, checking the ability to recognize existing usernames, correct login info, and addition of new users into the database
 * @author Team 5, 19
 *
 * @version April 1, 2024
 *
 */


public class Database implements DatabaseInterface{
    private ArrayList<UserProfile> users;
    private String outputFile;

    public Database(String outputFile) {
        this.outputFile = outputFile;
        this.users = new ArrayList<>();
    }

    public void createFile() { //THIS METHOD IS USED TO CREATE THE DATABASE.txt FILE WHEN IT DOESN'T EXIST
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, true)));
            pw.flush();
            pw.close();
        } catch (Exception e) {e.printStackTrace();
        }
    }

    public boolean writeFile1(String username, String password) { //THIS METHOD IS USED TO APPEND USER INFORMATION TO THE DATABASE FILE
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


    public boolean readFile1(String username) { //THIS METHOD IS USED TO VERIFY DURING SIGNUP WHETHER THE INPUTTED USERNAME ALREADY EXISTS
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

    public boolean readFile2(String username) { //THIS METHOD IS USED DURING THE LOGIN PROCESS TO VERIFY IF THE INPUTTED USERNAME EXISTS
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

    public boolean readFile3(String username, String password) { //THIS METHOD IS USED DURING THE LOGIN PROCESS TO FIRST FIND THE USERNAME IN THE DATABASE,
        //FIND THE PASSWORD ASSOCIATED WITH IT, AND VERIFY IF IT IS CORRECT OR NOT
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

    public boolean searchFile(String searchUser) {
        try (BufferedReader br = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Username: " + searchUser + " ")) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean deleteUser(String username) { //THIS METHOD DELETES A USER FROM THE DATABASE BY REWRITING THE OLD FILE TO A NEW ONE, THEN RENAMING IT.
        File inputFile = new File(outputFile);
        File tempFile = new File("temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(outputFile));
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(tempFile)))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Username: " + username + " ")) {
                    for (int i = 0; i < 3; i++) {
                        br.readLine();
                    }
                } else {
                    pw.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!inputFile.delete()) {
            System.out.println("Failed to delete the old file");
            return false;
        }

        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Failed to rename the temporary file");
            return false;
        }

        return true;
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
