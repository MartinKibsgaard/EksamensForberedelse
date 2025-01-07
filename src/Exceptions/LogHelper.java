package Exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogHelper {
    private static final String LOG_FILE = "error_log.txt";

    public static void logError(String errorMessage) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) { // true for append mode
            String timestamp = LocalDateTime.now().toString();
            writer.write(timestamp + " - " + errorMessage + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Fejl under logning: " + e.getMessage());
        }
    }
}
