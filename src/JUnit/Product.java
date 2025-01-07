package JUnit;

public class Product {
    private double price;
    private int stock;

    public Product(double price, int stock) {
        this.price = price;
        this.stock = stock;
    }

    public double calculateDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }
        return price - (price * (discountPercentage / 100));
    }

    public int updateStock(int quantitySold) {
        if (quantitySold > stock) {
            throw new IllegalArgumentException("Not enough stock available.");
        }
        stock -= quantitySold;
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}