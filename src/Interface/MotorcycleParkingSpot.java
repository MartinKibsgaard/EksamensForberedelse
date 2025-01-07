package Interface;

public class MotorcycleParkingSpot implements ParkingSpot{
    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(int hours) {
        if (hours < 0) {
            throw new CarParkingSpot.InvalidParkingTimeException("Hours cannot be negative");
        }
        return RATE_PER_HOUR * hours;
    }

    @Override
    public String getSpotType() {
        return "Motorcycle";
    }
}
