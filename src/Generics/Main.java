package Generics;

import java.util.List;

// Main-metode til at teste funktionaliteten
public class Main {
    public static void main(String[] args) {
        // Elektronik
        ItemContainer<Electronics> electronicsContainer = new ItemContainer<>();
        electronicsContainer.addItem(new Electronics("TV", 3000));
        electronicsContainer.addItem(new Electronics("Laptop", 8000));
        electronicsContainer.addItem(new Electronics("Phone", 5000));

        // Møbler
        ItemContainer<Furniture> furnitureContainer = new ItemContainer<>();
        furnitureContainer.addItem(new Furniture("Chair", "Wood"));
        furnitureContainer.addItem(new Furniture("Table", "Metal"));
        furnitureContainer.addItem(new Furniture("Sofa", "Fabric"));
        furnitureContainer.addItem(new Furniture("Bed", "Wood"));
        furnitureContainer.addItem(new Furniture("Desk", "Metal"));
        furnitureContainer.addItem(new Furniture("Cabinet", "Wood"));
        furnitureContainer.addItem(new Furniture("Shelf", "Metal"));
        furnitureContainer.addItem(new Furniture("Dresser", "Wood"));
        furnitureContainer.addItem(new Furniture("Wardrobe", "Metal"));
        furnitureContainer.addItem(new Furniture("Bookcase", "Wood"));
        furnitureContainer.addItem(new Furniture("Bench", "Metal"));
        furnitureContainer.addItem(new Furniture("Stool", "Wood"));

        // Filtrer og vis elektronik med pris under 6000
        System.out.println("Elektronik under 6000:");
        List<Electronics> cheapElectronics = electronicsContainer.findItems(e -> e.getPrice() < 6000);
        cheapElectronics.forEach(System.out::println);

        // Vi alle møbler
        System.out.println("\nAlle møbler:");
        furnitureContainer.displayItems();

        // Filtrer og vis møbler lavet af træ
        System.out.println();
        List<Furniture> woodFurniture = furnitureContainer.findItems(f -> f.getMaterial().equalsIgnoreCase("Wood"));
        woodFurniture.forEach(System.out::println);

        // Fjern møbler lavet af træ
        System.out.println("\nFjerner møbler lavet af træ:");
        furnitureContainer.removeItems(f -> f.getMaterial().equalsIgnoreCase("Wood"));
        furnitureContainer.displayItems();
    }
}