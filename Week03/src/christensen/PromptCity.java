package christensen;

import java.util.Scanner;

public class PromptCity {

    // Setup
    private String city;
    private static Scanner scanner = new Scanner(System.in);

    public PromptCity() {
        System.out.print("Enter a City: ");
        setCity(scanner.nextLine());
    }

    // Getters and Setters
    public String getCity() {
        return this.city;
    }
    public void setCity(String newCity) {
        this.city = newCity;
    }
}
