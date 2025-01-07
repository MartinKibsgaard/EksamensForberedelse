package AbstraktSuperklasse;

// Abstrakt superklasse
public abstract class Vehicle {
    private String licensePlate;
    private String brand;

    public Vehicle(String licensePlate, String brand) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("Nummerpladen må ikke være tom.");
        }
        this.licensePlate = licensePlate;
        this.brand = brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public abstract double calculateParkingFee();
}