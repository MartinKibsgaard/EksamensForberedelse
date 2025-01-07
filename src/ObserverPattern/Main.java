package ObserverPattern;


public class Main {
    public static void main(String[] args) {
        // Opret en WeatherStation (Subject)
        WeatherStation station = new WeatherStation();

        // Opret observere
        ConsoleDisplay consoleDisplay = new ConsoleDisplay();
        MobileDisplay mobileDisplay = new MobileDisplay();
        FileLogger fileLogger = new FileLogger();

        // Registrer observere hos WeatherStation
        station.registerObserver(consoleDisplay);
        station.registerObserver(mobileDisplay);
        station.registerObserver(fileLogger);

        // Opdater vejrudsigten (notifikation sendes automatisk)
        station.setWeatherData("Solrigt, 25°C");
        System.out.println();
        station.setWeatherData("Overskyet, 20°C");
        System.out.println();
        station.setWeatherData("Regnvejr, 15°C");
        System.out.println();

        // Fjern observere
        System.out.println("Fjerner observeren 'MobileDisplay'");
        station.removeObserver(mobileDisplay);

        // Opdater vejrudsigten (notifikation sendes automatisk)
        System.out.println();
        station.setWeatherData("Skyfrit, 30°C");

    }
}
