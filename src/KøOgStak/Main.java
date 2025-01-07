package KøOgStak;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<String> customerQueue = new LinkedList<>();
        Stack<String> specialRequests = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Tilføj kunde til kø");
            System.out.println("2. Betjen kunde fra kø");
            System.out.println("3. Tilføj specialforespørgsel");
            System.out.println("4. Behandl specialforespørgsel");
            System.out.println("5. Afslut program");
            System.out.print("Vælg en handling: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // For at fange newline efter input

            switch (choice) {
                case 1:
                    System.out.print("Indtast kundens navn: ");
                    String customer = scanner.nextLine();
                    customerQueue.add(customer);
                    System.out.println(customer + " er tilføjet til køen.");
                    break;
                case 2:
                    if (customerQueue.isEmpty()) {
                        System.out.println("Køen er tom.");
                    } else {
                        System.out.println(customerQueue.poll() + " er blevet betjent.");
                    }
                    break;
                case 3:
                    System.out.print("Indtast specialforespørgsel: ");
                    String request = scanner.nextLine();
                    specialRequests.push(request);
                    System.out.println("Specialforespørgslen \"" + request + "\" er tilføjet.");
                    break;
                case 4:
                    if (specialRequests.isEmpty()) {
                        System.out.println("Der er ingen specialforespørgsler.");
                    } else {
                        System.out.println("Behandler specialforespørgsel: " + specialRequests.pop());
                    }
                    break;
                case 5:
                    System.out.println("Program afsluttes.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }
}
