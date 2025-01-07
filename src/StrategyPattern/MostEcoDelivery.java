package StrategyPattern;

public class MostEcoDelivery implements DeliveryStrategy {
    @Override
    public double calculateDelivery(double distance, double weight) {
        return (distance * 1.2 + weight) * 0.9; // Eksempelberegning
    }
}
