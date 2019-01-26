package christensen;

/**
 * Simple driver program
 */

public class Main {

    public static void main(String[] args) {

        // Setup
        System.out.println("\tSingle City Forecast:");
        new SingleCity().singleCity();

        System.out.println("\n\n\tMulti-City Forecast:\tEnter 5 cities");
        new MultiCity().multiCity();
    }
}
