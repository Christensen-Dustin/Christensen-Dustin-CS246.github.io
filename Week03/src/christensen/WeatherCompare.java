package christensen;

import java.io.IOException;

public class WeatherCompare {

    // Setup
    private String location;
    private float maxTemp;
    private float maxWindSpeed;

    public WeatherCompare() throws IOException {

    }

    // Compare the data
    public WeatherCompare compareData(String location) throws IOException {

        // Setup
        WeatherData data = new WeatherData();
        data.setLocation(location);

        WeatherConditions cond = data.getWeather();

        WeatherCompare compare = data.getCompare();
        compare.setLocation(data.getLocation());
        compare.setMaxTemp(cond.getMeasurements().get("temp_max"));
        compare.setMaxWindSpeed(cond.getWindDescription().get("speed"));

        return compare;
    }

    // GETTERS
    public String getLocation() {
        return this.location;
    }
    public float getMaxTemp() {
        return this.maxTemp;
    }
    public float getMaxWindSpeed() {
        return this.maxWindSpeed;
    }

    // SETTER
    public void setLocation(String newLocation) {
        this.location = newLocation;
    }
    public void setMaxTemp(float newMaxTemp) {
        this.maxTemp = newMaxTemp;
    }
    public void setMaxWindSpeed(float newMaxWindSpeed) {
        this.maxWindSpeed = newMaxWindSpeed;
    }
}
