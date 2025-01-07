package KædedeStrukturer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList contactList = new SingleLinkedList();
        DoubleLinkedList history = new DoubleLinkedList();

        // Udleveret menu
        while (true) {
            System.out.println("1. Tilføj kontakt");
            System.out.println("2. Fjern kontakt");
            System.out.println("3. Søg kontakt");
            System.out.println("4. Se historik");
            System.out.println("5. Afslut");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Ryd scannerbufferen

            switch (choice) {
                case 1 -> addContact(contactList, history);

                case 2 -> removeContact(contactList, history);

                case 3 -> searchContact(contactList, history);

                case 4 -> printHistory(history);

                case 5 -> {
                    System.out.println("Farvel!");
                    return;
                }
                default -> System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    public static void addContact(SingleLinkedList contactList, DoubleLinkedList history) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast navn:");
        String name = scanner.nextLine();
        System.out.println("Indtast telefonnummer:");
        String phone;
        while (true) {
            phone = scanner.nextLine();
            if (isValidPhoneNumber(phone)) {
                break;
            } else {
                System.out.println("Ugyldigt telefonnummer. Det skal være 8 cifre. Prøv igen:");
            }
        }
        System.out.println("Indtast e-mail:");
        String email;
        while (true) {
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Ugyldig e-mail. Prøv igen:");
            }
        }
        Contact contact = new Contact(name, phone, email);
        contactList.add(contact);
        history.addHistory("Tilføjede kontakt: " + contact.getName());
    }

    public static void removeContact(SingleLinkedList contactList, DoubleLinkedList history) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast navn på kontakt der skal fjernes:");
        String name = scanner.nextLine();
        if (contactList.remove(name)) {
            history.addHistory("Fjernede kontakt: " + name);
        } else {
            System.out.println("Kontakten findes ikke.");
        }
    }

    public static void searchContact(SingleLinkedList contactList, DoubleLinkedList history) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast navn på kontakt der skal søges efter:");
        String name = scanner.nextLine();
        Contact contact = contactList.search(name);
        if (contact != null) {
            System.out.println(contact);
            history.addHistory("Søgte efter kontakt: " + name);
        } else {
            System.out.println("Kontakten findes ikke.");
        }
    }

    public static void printHistory(DoubleLinkedList history) {
        history.printHistory();
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public static boolean isValidPhoneNumber(String phone) {
        String phoneRegex = "^[0-9]{8}$";
        return phone.matches(phoneRegex);
    }


}