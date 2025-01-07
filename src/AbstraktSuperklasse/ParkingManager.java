package AbstraktSuperklasse;

import java.util.ArrayList;
import java.util.Scanner;

// Klasse til at administrere parkeringspladsen
public class ParkingManager {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }


    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nParkeringsplads Menu:");
            System.out.println("1. Tilføj bil");
            System.out.println("2. Tilføj motorcykel");
            System.out.println("3. Vis alle køretøjer");
            System.out.println("4. Afslut");
            System.out.print("Vælg en mulighed: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addVehicle();
                    case 2 -> addMotorcycle();
                    case 3 -> printAllVehicles();
                    case 4 -> running = false;
                    default -> System.out.println("Ugyldigt valg. Prøv igen.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt input. Indtast et tal.");
            }
        }
    }

    private static void addVehicle() {
        System.out.print("Indtast nummerplade: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Indtast mærke: ");
        String brand = scanner.nextLine();
        System.out.print("Er bilen elektrisk? (true/false): ");
        boolean isElectric = scanner.nextBoolean();

        try {
            addVehicle(new Car(licensePlate, brand, isElectric));
        } catch (IllegalArgumentException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }

    private static void addMotorcycle() {
        System.out.print("Indtast nummerplade: ");
        String licensePlate = scanner.nextLine();
        System.out.print("Indtast mærke: ");
        String brand = scanner.nextLine();
        System.out.print("Er motorcyklen en crosser? (true/false): ");
        boolean isOffroad = scanner.nextBoolean();

        try {
            addVehicle(new Motorcycle(licensePlate, brand, isOffroad));
        } catch (IllegalArgumentException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }

    public static void printAllVehicles() {
        System.out.println("Parkerede køretøjer:");
        if (vehicles.isEmpty()) {
            System.out.println("Ingen køretøjer parkeret.");
        }
        for (Vehicle v : vehicles) {
            System.out.println("Nummerplade: " + v.getLicensePlate() +
                    ", Mærke: " + v.getBrand() +
                    ", Gebyr: " + v.calculateParkingFee() + " kr.");
        }
    }
}