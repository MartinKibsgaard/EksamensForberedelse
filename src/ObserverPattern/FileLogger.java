package ObserverPattern;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Observer {
    @Override
    public void update(String weatherData) {
        try (FileWriter writer = new FileWriter("weather_log.txt", true)) {
            writer.write("Wheather Data Logged: " + weatherData + "\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
