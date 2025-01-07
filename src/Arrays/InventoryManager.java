package Arrays;

import java.util.Scanner;

public class InventoryManager {
    private static final int MAX_PRODUCTS = 10;
    private static Product[] inventory = new Product[MAX_PRODUCTS];
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tilføj produkt");
            System.out.println("2. Vis produkter");
            System.out.println("3. Slet produkt");
            System.out.println("4. Opdater antal");
            System.out.println("5. Afslut");
            System.out.print("Vælg en mulighed: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Ryd scannerbufferen

            switch (choice) {
                case 1:
                    addProducts(scanner);
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    deleteProduct(scanner);
                    break;
                case 4:
                    updateQuantity(scanner);
                    break;
                case 5:
                    System.out.println("Program afsluttes.");
                    return;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    public static void addProducts(Scanner scanner) {
        if (count >= 10) {
            System.out.println("Lagret er fyldt, kan ikke tilføje flere produkter.");
            return;
        }
        System.out.println("Indtast produktnavn: ");
        String name = scanner.nextLine();
        System.out.println("Indtast antal: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        try {
            inventory[count] = new Product(name, quantity);
            count++;
            System.out.println("Produkt tilføjet");
        } catch (IllegalArgumentException e) {
            System.out.println("Fejl" + e.getMessage());
        }
    }

    public static void displayProducts() {
        if (count == 0) {
            System.out.println("Lagret er tomt.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(inventory[i]);
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.println("Indtast navnet på produktet der skal slettes: ");
        String name = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (inventory[i].getName().equalsIgnoreCase(name)) {
                inventory[i] = inventory[count - 1];
                inventory[count - 1] = null;
                count--;
                System.out.println("Produkt slettet.");
                return;
            }
        }
        System.out.println("Produkt ikke fundet i lagret.");
    }

    public static void updateQuantity(Scanner scanner) {
        System.out.println("Indtast navnet på produktet: ");
        String name = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (inventory[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Indtast nyt antal: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                try {
                    inventory[i].setQuantity(quantity);
                    System.out.println("Antal opdateret.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Fejl" + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Produkt ikke fundet i lagret.");
    }
}