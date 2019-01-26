package christensen;

public class WeatherDescription {

    // Setup
    private int id;
    private String main;
    private String description;

    // GETTERS
    public int getId() {
        return this.id;
    }
    public String getMain() {
        return this.main;
    }
    public String getDescription() {
        return this.description;
    }

    // SETTERS
    public void setId(int newId) {
        this.id = newId;
    }
    public void setMain(String newMain) {
        this.main = newMain;
    }
    public void setDescription(String newDescript) {
        this.description = newDescript;
    }
}
