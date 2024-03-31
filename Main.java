import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        String email;
        String username = "";
        String password = "";
        int logChoice;

        System.out.println("Welcome to NotFacebook!");

        while (!loggedIn) {
            System.out.println("1: Sign Up");
            System.out.println("2: Login");


            logChoice = scanner.nextInt();
            scanner.nextLine();


            switch (logChoice) {
                case 1:
                    System.out.println("Enter your email:");
                    email = scanner.nextLine();
                    System.out.println("Enter a username:");
                    username = scanner.nextLine();
                    System.out.println("Enter your password:");
                    password = scanner.nextLine();


                    break;

                case 2:
                    System.out.println("Enter your username:");
                    if (scanner.nextLine().equals(username)) {
                        System.out.println("Enter your password");
                        if (scanner.nextLine().equals(password)) {
                            System.out.println("Login Successful!");
                            loggedIn = true;

                        }
                    }
                    break;
            }
        }
    }
}
