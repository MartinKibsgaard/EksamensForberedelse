package Interface;

public class CarParkingSpot implements ParkingSpot{
    private static final double RATE_PER_HOUR = 20.0;

    @Override
    public double calculateFee(int hours) {
        if (hours < 0) {
            throw new InvalidParkingTimeException("Hours cannot be negative");
        }
        return RATE_PER_HOUR * hours;
    }

    @Override
    public String getSpotType() {
        return "Car";
    }

    static class InvalidParkingTimeException extends RuntimeException {
        public InvalidParkingTimeException(String message) {
            super(message);
        }
    }
}
