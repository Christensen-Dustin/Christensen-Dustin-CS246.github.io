package christensen;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class WeatherForecastItems {

    // Setup
    @SerializedName("dt")
    private String date;

    @SerializedName("main")
    private Map<String, Float> measurements;

    @SerializedName("weather")
    private List<WeatherDescription> descriptions;

    @SerializedName("wind")
    private Map<String, Float> wind;

    // GETTERS
    public String getDate() {
        return this.date;
    }
    public Map<String, Float> getMeasurements() {
        return this.measurements;
    }
    public List<WeatherDescription> getDescriptions() {
        return this.descriptions;
    }
    public Map<String, Float> getWind() {
        return this.wind;
    }

    // SETTER
    public void setDate(String newDate) {
        this.date = newDate;
    }
    public void setMeasurements(Map<String, Float> newMeasurments) {
        this.measurements = newMeasurments;
    }
    public void setDescriptions(List<WeatherDescription> newDescript) {
        this.descriptions = newDescript;
    }
    public void setWind(Map<String, Float> newWind) {
        this.wind = newWind;
    }
}
