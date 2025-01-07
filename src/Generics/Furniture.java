package Generics;

public class Furniture {
    private String name;
    private String material;

    public Furniture(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Furniture{name='" + name + "', material='" + material + "'}";
    }
}