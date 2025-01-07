package Arrays;

public class Product {
    private final String name;
    private int quantity;

    public Product(String name, int quantity) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Navnet må ikke være tomt");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Antal skal være >= 0");
        }
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Antal skal være >= 0");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product:" +
                "navn: '" + name + '\'' +
                ", antal: " + quantity + "\"";
    }
}
