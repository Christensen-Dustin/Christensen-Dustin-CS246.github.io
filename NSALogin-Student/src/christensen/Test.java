package christensen;

// Import files
import static christensen.NSALoginController.*;

// Import class to receive user input
import java.util.Scanner;

public class Test{

    // Set up to take USER input
    private static final Scanner _scanner = new Scanner( System.in );

    // MAIN FUNCTION
    public static void main(String[] args) throws WeakPasswordException {
        // Prompt user to enter a password and accept input
        System.out.print("Please provided a password: ");
        String firstPassword = _scanner.nextLine();

        // Instance of the USER class with provided PASSWORD
        User user = new User(firstPassword);

        // Display variables before hashing
        System.out.println("Here are the variables before the HASHing:");
        user.displayVariables();

        try {
            hashUserPassword(user);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Display variables after hashing
        System.out.println("Here are the variables after the HASHing:");
        user.displayVariables();

        // Prompt user to enter a PASSWORD to verify
        System.out.print("Please provided a password to verify: ");
        String secondPassword = _scanner.nextLine();

        // Set the user password
        user.setPassword(secondPassword);

        // Verify the PASSWORD
        try {
            if (verifyPassword(user)) {
                System.out.println("The PASSWORDs match!!!");
            } else {
                System.out.println("The PASSWORDs do not match!!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
