package TwoDimensionelleArrays;

import java.util.Scanner;

public class SalesAnalysis {
    public static void main(String[] args) {
        // 2D array med salgsdata (rækker = dage, kolonner = produkter)
        int[][] sales = {
                {150, 200, 250, 300, 100}, // Mandag
                {120, 180, 220, 310, 90},  // Tirsdag
                {140, 160, 200, 320, 110}, // Onsdag
                {130, 210, 240, 330, 120}, // Torsdag
                {160, 190, 210, 340, 140}, // Fredag
                {170, 200, 230, 350, 150}, // Lørdag
                {180, 220, 260, 360, 160}  // Søndag
        };

        // Menu til at vælge funktion
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nVælg en funktion:");
            System.out.println("1. Udskriv salgsdata");
            System.out.println("2. Beregn samlet salg");
            System.out.println("3. Find dagens topsælger");
            System.out.println("4. Find ugens topsælger");
            System.out.println("5. Afslut");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> printSalesData(sales);
                case 2 -> calculateTotalSales(sales);
                case 3 -> findDayTopSeller(sales, scanner);
                case 4 -> findWeekTopSeller(sales);
                case 5 -> {
                    System.out.println("Program afsluttet.");
                    return;
                }
                default -> System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    // Udskrivning af salgsdata
    public static void printSalesData(int[][] sales) {
        String[] days = {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag"};
        for (int i = 0; i < sales.length; i++) {
            System.out.print("Dag: " + days[i] + " - Salg: ");
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Beregning af samlet salg
    public static void calculateTotalSales(int[][] sales) {
        int total = 0;
        for (int[] daySales : sales) {
            for (int sale : daySales) {
                total += sale;
            }
        }
        System.out.println("Samlet salg for hele ugen: " + total);
    }

    // Finder dagens topsælger
    public static void findDayTopSeller(int[][] sales, Scanner scanner) {
        String[] days = {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag"};
        System.out.print("Indtast dagen (0 = Mandag, 6 = Søndag): ");
        int day = scanner.nextInt();

        if (day < 0 || day >= sales.length) {
            System.out.println("Ugyldig dag. Prøv igen.");
            return;
        }

        int maxSale = 0;
        int productIndex = 0;
        for (int i = 0; i < sales[day].length; i++) {
            if (sales[day][i] > maxSale) {
                maxSale = sales[day][i];
                productIndex = i;
            }
        }

        System.out.println("Dagens topsælger: Produkt " + (productIndex + 1) + " med salg på " + maxSale);
    }

    // Finder ugens topsælger
    public static void findWeekTopSeller(int[][] sales) {
        int[] productTotals = new int[sales[0].length];
        for (int[] daySales : sales) {
            for (int i = 0; i < daySales.length; i++) {
                productTotals[i] += daySales[i];
            }
        }

        int maxSale = 0;
        int productIndex = 0;
        for (int i = 0; i < productTotals.length; i++) {
            if (productTotals[i] > maxSale) {
                maxSale = productTotals[i];
                productIndex = i;
            }
        }

        System.out.println("Ugens topsælger: Produkt " + (productIndex + 1) + " med samlet salg på " + maxSale);
    }
}
