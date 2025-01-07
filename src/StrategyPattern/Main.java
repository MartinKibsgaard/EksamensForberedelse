package StrategyPattern;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DeliveryContext context = new DeliveryContext();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Vælg leveringsstrategi:");
            System.out.println("1: Hurtigst levering");
            System.out.println("2: Billigst levering");
            System.out.println("3: Mest miljøvenlig levering");
            System.out.println("4: Afslut");
            System.out.print("Vælg en mulighed: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Ryd scannerbufferen

            switch (choice) {
                case 1 -> context.setStrategy(new FastestDelivery());
                case 2 -> context.setStrategy(new CheapestDelivery());
                case 3 -> context.setStrategy(new MostEcoDelivery());
                case 4 -> {
                    System.out.println("Programmet afsluttes.");
                    return;
                }
                default -> {
                    System.out.println("Ugyldigt valg. Prøv igen.");
                    continue;
                }
            }

            System.out.print("Indtast afstand i km: ");
            double distance = scanner.nextDouble();
            System.out.print("Indtast vægt i kg: ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Ryd scannerbufferen

            double price = context.executeStrategy(distance, weight);
            System.out.println("Pris for levering: " + price + " kr.");

        }
    }
}