import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to NotFacebook!");
        System.out.println("1: Sign Up");
        System.out.println("2: Login");

        boolean loggingIn = false;
        boolean signingUp = false;
        int logChoice = scanner.nextInt();
        scanner.nextLine();

        switch (logChoice) {
            case 1 -> System.out.println("Enter your");
            case 2 -> System.out.println("bye");

        }







    }
}
