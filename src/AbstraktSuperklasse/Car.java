package AbstraktSuperklasse;

// Subklasse for biler
public class Car extends Vehicle {
    private boolean isElectric;

    public Car(String licensePlate, String brand, boolean isElectric) {
        super(licensePlate, brand);
        this.isElectric = isElectric;
    }

    @Override
    public double calculateParkingFee() {
        return isElectric ? 10.0 : 20.0;
    }
}