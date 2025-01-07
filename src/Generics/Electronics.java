package Generics;

public class Electronics {
    private String name;
    private double price;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Electronics{name='" + name + "', price=" + price + "}";
    }
}
