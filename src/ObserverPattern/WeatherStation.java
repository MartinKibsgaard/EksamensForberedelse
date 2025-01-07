package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<Observer> observers = new ArrayList<>(); // Liste af observere
    private String weatherData; // Data, som observere vil følge

    // Tilføj en observer
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    // Fjern en observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notificer alle observere om ændringer
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(weatherData); // Kalder update på hver observer
        }
    }

    // Opdater vejrudsigten og notificer observere
    public void setWeatherData(String weatherData) {
        this.weatherData = weatherData;
        notifyObservers(); // Automatisk notifikation
    }
}
