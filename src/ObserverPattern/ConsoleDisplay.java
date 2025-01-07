package ObserverPattern;

public class ConsoleDisplay implements Observer {

    @Override
    public void update(String weatherData) {
        System.out.println("ConsoleDisplay: " + weatherData);
    }
}
