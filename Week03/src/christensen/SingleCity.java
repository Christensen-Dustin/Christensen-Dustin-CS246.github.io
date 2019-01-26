package christensen;

import java.io.IOException;

public class SingleCity {

    public void singleCity() {

        // Setup
        WeatherData weatherData = new WeatherData();
        PromptCity city = new PromptCity();
        weatherData.setLocation(city.getCity());

        try {
            WeatherConditions singleConditions = weatherData.getWeather();

            System.out.println("Name: " + singleConditions.getName());
            System.out.println("Measurements: " + singleConditions.getMeasurements().toString());

            WeatherForecast multiForecast = weatherData.getForecast();
            displayForecast(multiForecast);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void displayForecast(WeatherForecast multiForecast) {

        System.out.println("\tForecast Information:");

        for (WeatherForecastItems item: multiForecast.getItems()) {
            String time = item.getDate();
            float temp = item.getMeasurements().get("temp");

            String weatherConditions = " ";

            if (item.getDescriptions().size() > 0) {
                weatherConditions = item.getDescriptions().get(0).getDescription();
            }

            float wind = item.getWind().get("speed");

            System.out.println("Time: " + time);
            System.out.println("Temperature: " + temp + "Farenheit");
            System.out.println("Condition: " + weatherConditions);
            System.out.println("Wind Speed: " + wind + "mph");
        }
    }
}
