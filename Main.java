import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        boolean exit = false;
        String email;
        String username = "";
        String password = "";
        int logChoice;
        boolean validUsername;
        boolean validPassword;
        int mainMenuChoice;
        int deleteChoice;

        Database database = new Database("database.txt");
        database.createFile();





        System.out.println("Welcome to NotFacebook!");

        while (!loggedIn) {
            validUsername = false;
            validPassword = false;
            System.out.println("1: Sign Up");
            System.out.println("2: Login");
            logChoice = scanner.nextInt();
            scanner.nextLine();

            switch (logChoice) {
                case 1:
                    while (!validUsername) {
                        System.out.println("Enter a username:");
                        username = scanner.nextLine();
                        if (database.readFile1(username)) {
                            System.out.println("Enter a password:");
                            password = scanner.nextLine();
                            System.out.println("Successfully Signed Up!");
                            validUsername = true;
                            database.writeFile1(username, password);
                            UserProfile user = new UserProfile(username, password);
                            database.addUser(user);


                        }
                    }

                    break;

                case 2:
                    while (!validUsername) {
                        System.out.println("Enter your username:");
                        username = scanner.nextLine();
                        if (database.readFile2(username)) {
                            validUsername = true;
                        } else {
                            System.out.println("User does not exist!");
                        }
                    }
                    while (!validPassword) {
                        System.out.println("Enter your password:");
                        password = scanner.nextLine();
                        if (database.readFile3(username, password)) {
                            validPassword = true;
                            System.out.println("Login Successful!");
                            loggedIn = true;
                        } else {
                            System.out.println("Invalid Password!");
                        }
                    }
                    break;



            }

        }

        while (loggedIn) {
            System.out.println("1: View Account");
            System.out.println("2: View Friends");
            System.out.println("3: Logout");
            System.out.println("4: Delete Account");
            mainMenuChoice = scanner.nextInt();
            scanner.nextLine();
            switch (mainMenuChoice) {
                case 1:
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                    break;
                case 2:
                    System.out.println("No Friends Added");
                    break;

                case 3:
                    System.out.println("Logging Out...");
                    loggedIn = false;
                case 4:
                    System.out.println("Are you sure you want to delete your account?");
                    System.out.println("1: No");
                    System.out.println("2: Yes");
                    deleteChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (deleteChoice == 2) {
                        System.out.println("Deleting...");
                        database.deleteUser(username);
                        loggedIn = false;
                    }
            }
        }
    }
}
