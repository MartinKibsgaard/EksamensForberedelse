package StrategyPattern;

public class DeliveryContext {
    private DeliveryStrategy strategy;

    public void setStrategy(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double distance, double weight) {
        if (strategy == null) {
            throw new IllegalStateException("Delivery strategy not set!");
        }
        return strategy.calculateDelivery(distance, weight);
    }
}
