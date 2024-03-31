import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to NotFacebook!");
        System.out.println("1: Sign Up");
        System.out.println("2: Login");

        boolean loggedIn = false;
        int logChoice = scanner.nextInt();
        scanner.nextLine();

        while (!loggedIn) {

            switch (logChoice) {
                case 1:
                    System.out.println("Enter your email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter your password:");
                    String password = scanner.nextLine();

                    break;


                case 2:
                    System.out.println("Enter your username:");
                    System.out.println("Enter your password:");
                    break;
            }


        }
    }
}
