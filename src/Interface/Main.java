package Interface;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new CarParkingSpot());
        parkingSpots.add(new MotorcycleParkingSpot());
        parkingSpots.add(new ElectricCarParking());

        try {
            for (ParkingSpot parkingSpot : parkingSpots) {
                System.out.println("Type: " + parkingSpot.getSpotType());
                System.out.println("Enter the number of hours parked:");
                Scanner scanner = new Scanner(System.in);
                double hours = scanner.nextDouble();
                System.out.println("Fee: " + parkingSpot.calculateFee((int) hours));
                System.out.println();
            }
        } catch (CarParkingSpot.InvalidParkingTimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
