package IterationForOgWhile;

import java.util.*;

public class ShoeStoreSales {
    public static void main(String[] args) {
        ArrayList<Integer> sales = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Velkommen til skobutikken salgsstyring!");
        registerSales(sales, scanner); // Registrer salgsdata
        int totalSales = calculateTotalSales(sales); // Beregn samlet salg
        int bestDay = findMaxSalesDay(sales); // Find bedste salgsdag

        // Vis resultaterne
        System.out.println("Samlet salg for ugen: " + totalSales);
        System.out.println("Dagen med det højeste salg: Dag " + (bestDay + 1) + " med " + sales.get(bestDay) + " solgte sko.");
    }

    // Registrerer salgsdata fra brugeren
    public static void registerSales(ArrayList<Integer> sales, Scanner scanner) {
        System.out.println("Indtast antallet af solgte sko for hver dag i ugen (7 dage):");
        for (int i = 0; i < 7; i++) {
            while (true) {
                System.out.print("Dag " + (i + 1) + ": ");
                try {
                    int sale = Integer.parseInt(scanner.nextLine());
                    if (sale < 0) {
                        System.out.println("Fejl: Salget kan ikke være negativt. Prøv igen.");
                    } else {
                        sales.add(sale);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Fejl: Indtast kun heltal. Prøv igen.");
                }
            }
        }
    }

    // Beregner det samlede antal solgte sko
    public static int calculateTotalSales(ArrayList<Integer> sales) {
        int total = 0;
        for (int sale : sales) {
            total += sale;
        }
        return total;
    }

    // Finder dagen med det højeste salg
    public static int findMaxSalesDay(ArrayList<Integer> sales) {
        int maxIndex = 0; // Indeks for dagen med højeste salg
        int i = 1; // Start på anden dag
        while (i < sales.size()) {
            if (sales.get(i) > sales.get(maxIndex)) {
                maxIndex = i;
            }
            i++;
        }
        return maxIndex;
    }
}