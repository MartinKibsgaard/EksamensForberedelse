package StrategyPattern;

public class CheapestDelivery implements DeliveryStrategy {
    @Override
    public double calculateDelivery(double distance, double weight) {
        return distance * 0.8 + weight;
    }
}
