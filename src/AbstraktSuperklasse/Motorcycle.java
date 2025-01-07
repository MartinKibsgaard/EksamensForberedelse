package AbstraktSuperklasse;

// Subklasse for motorcykler
public class Motorcycle extends Vehicle {
    private boolean isOffroad;

    public Motorcycle(String licensePlate, String brand, boolean isOffroad) {
        super(licensePlate, brand);
        this.isOffroad = isOffroad;
    }

    @Override
    public double calculateParkingFee() {
        return isOffroad ? 5.0 : 10.0;
    }
}