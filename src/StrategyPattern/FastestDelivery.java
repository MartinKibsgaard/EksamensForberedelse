package StrategyPattern;

public class FastestDelivery implements DeliveryStrategy {
    @Override
    public double calculateDelivery(double distance, double weight) {
        return distance * 1.5 * 2;
    }
}