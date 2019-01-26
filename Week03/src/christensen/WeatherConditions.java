package christensen;

import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class WeatherConditions {

    // Setup
    private int id;
    private String name;

    @SerializedName("main")
    private Map<String, Float> measurements;

    @SerializedName("wind")
    private Map<String, Float> windDescription;

    // Getters
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public Map<String, Float> getMeasurements() {
        return this.measurements;
    }
    public Map<String, Float> getWindDescription() {
        return this.windDescription;
    }

    // Setters
    public void setId(int newID) {
        this.id = newID;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setMeasurements(Map<String, Float> newMeasurements) {
        this.measurements = newMeasurements;
    }
    public void setWindDescription(Map<String, Float> newWindDescript) {
        this.windDescription = newWindDescript;
    }
}
