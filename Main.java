import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * NotFacebook Main
 *
 * This class contains the main method that allows users to go through the process 
 * of signing up, logging in, searching for users, and deleting accounts.
 * It implements the control flow of the program and is how users will 
 * interact with the Database and UserProfile classes in Phase 1.
 *
 * @author Team 5, 19
 *
 * @version April 1, 2024
 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String email;
        String username = "";
        String password = "";
        int logChoice;
        boolean validUsername;
        boolean validPassword;
        int mainMenuChoice;
        int deleteChoice;
        String searchUser;

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

            switch (logChoice) { //CHOOSING TO SIGN UP
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
                    while (!validUsername) { //CHOOSING TO LOG IN
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

        while (loggedIn) { //ACCOUNT OPTIONS AFTER SUCCESSFUL LOGIN
            System.out.println("1: View Account");
            System.out.println("2: Search Users");
            System.out.println("3: View Friends");
            System.out.println("4: Logout");
            System.out.println("5: Delete Account");
            mainMenuChoice = scanner.nextInt();
            scanner.nextLine();
            switch (mainMenuChoice) {
                case 1:
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter a Username:");
                    searchUser = scanner.nextLine();
                    if (database.searchFile(searchUser)) {
                        System.out.println();
                    } else {
                        System.out.println("User not found");
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("No Friends Added");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Logging Out...");
                    loggedIn = false;
                    break;
                case 5:
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
