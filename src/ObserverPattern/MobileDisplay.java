package ObserverPattern;

public class MobileDisplay implements Observer {

    @Override
    public void update(String weatherData) {
        System.out.println("MobileDisplay: " + weatherData);
    }
}
