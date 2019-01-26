package christensen;

import com.google.gson.Gson;

import java.io.*;

import java.net.URL;
import java.net.URLConnection;

import java.nio.charset.StandardCharsets;

public class WeatherData {

    // Setup
    private String singleDayForecast = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String multiDayForecast = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private String apiKey = "&apiKey=267eccf143a3d673aa5086b3643a654b&units=imperial";
    private String charset = StandardCharsets.UTF_8.name();
    private String location;

    // Build URL
    private String getWeatherData(String url) throws IOException {

       URLConnection connect = new URL(url).openConnection();
       InputStream dataStream = connect.getInputStream();
       BufferedReader readData = new BufferedReader(new InputStreamReader(dataStream));
       StringBuilder buildString = new StringBuilder();

       String data;
       while ((data = readData.readLine()) != null) {
           buildString.append(data);
       }

       return buildString.toString();
    }

    // Gather Single Day JSON
    private String getSingleForecastJson() throws IOException {
        String single = getSingleDayForecast();
        String city = getLocation();
        String api = getApiKey();
        String url = single + city + api;

        return getWeatherData(url);
    }

    // Gather Multi Day JSON
    private String getMultiForecastJson() throws IOException {
        String single = getMultiDayForecast();
        String city = getLocation();
        String api = getApiKey();
        String url = single + city + api;

        return getWeatherData(url);
    }

    // Default Constructor
    public WeatherData() {

    }

    // Single Day Forecast
    public WeatherConditions getWeather() throws IOException {
        String dataConditions = getSingleForecastJson();
        WeatherConditions conditionsData;

        Gson gson = new Gson();
        conditionsData = gson.fromJson(dataConditions, WeatherConditions.class);

        return conditionsData;
    }

    // Multi-Day Forecast
    public WeatherForecast getForecast() throws IOException {
        String dataConditions = getMultiForecastJson();

        Gson gson = new Gson();
        WeatherForecast conditionsData = gson.fromJson(dataConditions, WeatherForecast.class);

        return conditionsData;
    }

    // Weather Compare
    public WeatherCompare getCompare() throws IOException {
        String dataCompare = getSingleForecastJson();
        WeatherCompare compareData;

        Gson gson = new Gson();
        compareData = gson.fromJson(dataCompare, WeatherCompare.class);

        return compareData;
    }

    // GETTERS
    public String getApiKey() {
        return this.apiKey;
    }
    public String getCharset() {
        return this.charset;
    }
    public String getSingleDayForecast() {
        return this.singleDayForecast;
    }
    public String getMultiDayForecast() {
        return this.multiDayForecast;
    }
    public String getLocation() {
        return this.location;
    }

    // SETTERS
    public void setLocation(String location) {
        this.location = location;
    }
}

