package christensen;

import java.io.IOException;
import java.util.*;

public class MultiCity {

    public void multiCity() {

        // Setup
        List<String> locations = new ArrayList<>();
        List<WeatherCompare> comparison = new ArrayList<>();

        // Fill list
        for (int x = 0; x < 5; x++) {
            PromptCity city = new PromptCity();
            locations.add(city.getCity());
        }

        // Gather data
        for (String location : locations) {
            try {
                WeatherCompare dataCompare = new WeatherCompare();
                comparison.add(dataCompare.compareData(location));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // Sorting by MAX TEMP
        comparison.sort(new Comparator<WeatherCompare>() {
            @Override
            public int compare(WeatherCompare o1, WeatherCompare o2) {
                return Float.compare(o2.getMaxTemp(), o1.getMaxTemp());
            }
        });

        // Display order
        System.out.println("\n\tCities sorted by MAX TEMPERATURE:");
        for (WeatherCompare compare: comparison) {
            System.out.println(compare.getLocation() + "\t" + compare.getMaxTemp());
        }

        // Sort by MAX WIND
        comparison.sort(new Comparator<WeatherCompare>() {
            @Override
            public int compare(WeatherCompare o1, WeatherCompare o2) {
                return Float.compare(o2.getMaxWindSpeed(), o1.getMaxWindSpeed());
            }
        });

        // Display order
        System.out.println("\n\tCities sorted by MAX WIND:");
        for (WeatherCompare compare: comparison) {
            System.out.println(compare.getLocation() + "\t" + compare.getMaxWindSpeed());
        }
    }
}
