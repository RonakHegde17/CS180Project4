import org.junit.Test;
import static org.junit.Assert.*;
/**
 * NotFacebook DatabaseTests
 * This program contains tests to verify the functionality of the database methods.
 * It contains 5 tests, checking the ability to recognize existing usernames, 
 * correct login info, and addition of new users into the database
 * @author Team 5, 19
 *
 * @version April 1, 2024
 *
 */

public class DatabaseTests {
    Database database = new Database("TestDatabase.txt");

    @Test
    public void writeFileTest() { //THIS TEST WILL CREATE A NEW USER WITH THE INPUTTED INFORMATION. 
        // PASSING MEANS DATABASE CLASS CAN SUCESSFULLY ADD USERS TO THE DATABASE
        database.createFile();
        String username = "testUsername";
        String password = "testPassword";
        boolean signUpResult = database.writeFile1(username, password);
        assertTrue(signUpResult);
    }

    @Test
    public void existingUsernameTest() { //THIS TEST WILL ATTEMPT TO DETECT IF THE INPUTTED USERNAME 
        //ALREADY EXISTS. PASSING MEANS DATABASE WILL PREVENT SIGNING UP WITH DUPLICATE NAME
        database.createFile();
        String username = "testUsername";
        boolean signUpResult = database.readFile1(username);
        assertFalse(signUpResult);
    }

    @Test
    public void readFileTest() { //THIS TEST WILL VERIFY THAT THE INPUTTED LOGIN MATCHES 
        //THE USER INFO IN THE DATABASE. PASSING MEANS LOGIN INFORMATION WAS CORRECT
        database.createFile();
        String username = "testUsername";
        String password = "testPassword";
        boolean loginResult = database.readFile3(username, password);
        assertTrue(loginResult);
    }
    @Test
    public void incorrectPassTest() { //THIS TEST WILL ATTEMPT TO LOG IN WITH AN 
        //INCORRECT PASSWORD. PASSING MEANS THE DATABASE CLASS SUCCESSFULLY PREVENTS LOGIN
        database.createFile();
        String username = "testUsername";
        String password = "yabadabadoo";
        boolean loginResult = database.readFile3(username, password);
        assertFalse(loginResult);
    }

    @Test
    public void incorrectUsernameTest() { //THIS TEST WILL ATTEMPT TO LOG IN WITH A USERNAME 
        //THAT DOESN'T EXIST. PASSING MEANS THE DATABASE CLASS SUCCESSFULLY PREVENTS LOGIN
        database.createFile();
        String username = "yabadabadoo";
        String password = "testPassword";
        boolean loginResult = database.readFile2(username);
        assertFalse(loginResult);
    }

}
