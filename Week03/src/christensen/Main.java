package christensen;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class Measurements {

    public static void main(String[] args) {

        // Setup
        Gson gsonWeather = new Gson();
        String apiKey = "267eccf143a3d673aa5086b3643a654b";
        String location = "Cypress";
        String urlBuilt = "https://api.openweathermap.org/data/2.5/weather?q="
                    + location + "apiKey=" + apiKey;

        String charset = "UTF-8";
        String param1 = "value1";
        String param2 = "value2";

        String query = String.format("param1=%s&param2=%s",
                URLEncoder.encode(param1, charset),
                URLEncoder.encode(param2, charset));

        try {
            InputStream data = new URL(urlBuilt + "?" + query).openStream();
            // connection.setRequestProperty("Accept-Charset", charset);
            // InputStream data = connection.getInputStream();
            String weatherData = data.toString();
        } catch (IOException e) {
            System.out.println("Error: No Data Retrieve from Site");
        }

        try {
            Scanner scanner = new Scanner();
            String weatherBody = scanner.useDelimiter("\\A").next();
            System.out.println(weatherBody);
        } catch (Exception e) {
            System.out.println("Error: No Data Retrieved from String");
        }
    }
}
