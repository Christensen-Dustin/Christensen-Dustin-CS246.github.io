package christensen;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class WeatherForecast {

    // Setup
    @SerializedName("list")
    private List<WeatherForecastItems> items;

    // GETTER
    public List<WeatherForecastItems> getItems() {
        return this.items;
    }

    // SETTER
    public void setItems(List<WeatherForecastItems> newItems) {
        this.items = newItems;
    }
}
