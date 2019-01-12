package christensen;

public class User {

    // Variables for the USER class
    private String password = null;        // Stores the user's initial PASSWORD
    private String salt = null;            // Stores the SALT, additional random input
    private String hash = null;            // Stores the HASH, the result of the PASSWORD and SALT

    //public static void main(String[] args) {
	// write your code here
    //}
    // NON-Default Constructor
    public User(String password) {
        // Prepare PASSWORD store user input
        setPassword(password);
    }

    // Getter and Setter for the PASSWORD variable
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String setPass) {
        this.password = setPass;
    }

    // Getter and Setter for the SALT variable
    public String getSalt() {
        return this.salt;
    }
    public void setSalt(String setSalt) {
        this.salt = setSalt;
    }

    // Getter and Setter for the HASH variable
    public String getHashedPassword() {
        return this.hash;
    }
    public void  setHashedPassword(String setHash) {
        this.hash = setHash;
    }

    // Display the variables
    public void displayVariables() {

        // System out the content
        System.out.println("PASSWORD: " + getPassword());
        System.out.println("SALT: " + getSalt());
        System.out.println("HASHEDPASSWORD: " + getHashedPassword());
    }
}
