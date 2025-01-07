package Exceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketManager manager = new TicketManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Velkommen til billetkøbssystemet!");

        while (true) {
            System.out.print("\nIndtast antal billetter du ønsker at købe (eller skriv 'exit' for at afslutte): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Tak for besøget! Farvel.");
                break;
            }

            try {
                int antalBilletter = Integer.parseInt(input);
                manager.købBilletter(antalBilletter);
                System.out.println("Billetter tilbage: " + manager.getAvailableTickets());
            } catch (NumberFormatException e) {
                String message = "Fejl: Indtast venligst et gyldigt tal.";
                System.out.println(message);
                LogHelper.logError(message);
            } catch (IllegalArgumentException e) {
                System.out.println("Fejl: " + e.getMessage());
                LogHelper.logError(e.getMessage());
            } catch (OutOfStockException e) {
                System.out.println("Fejl: " + e.getMessage());
                LogHelper.logError(e.getMessage());
            } catch (Exception e) {
                String message = "Der opstod en uventet fejl: " + e.getMessage();
                System.out.println(message);
                LogHelper.logError(message);
            }
        }

        scanner.close();
    }
}