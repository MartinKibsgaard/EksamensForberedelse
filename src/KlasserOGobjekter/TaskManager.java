package KlasserOGobjekter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TaskManager {
    static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTask Manager Menu:");
            System.out.println("1. Tilføj opgave");
            System.out.println("2. Fjern opgave");
            System.out.println("3. Vis opgaver");
            System.out.println("4. Afslut");

            System.out.print("Vælg en mulighed: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Ryd scanner-bufferen

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    running = false;
                    System.out.println("Program afsluttet.");
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
        scanner.close();
    }

    static void addTask(Scanner scanner) {
        try {
            System.out.println("Indtast opgavenanv: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Opgavenavn må ikke være tomt.");
                return;
            }

            System.out.println("Indtast deadline (yyyy-MM-dd");
            String deadlineInput = scanner.nextLine().trim();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            Date deadline = sdf.parse(deadlineInput);

            tasks.add(new Task(name, deadline));
            System.out.println("Opgave tilføjet");
        } catch (ParseException e) {
            System.out.println("Ugyldigt datoformat. Brug formatet yyyy-MM-dd.");
        } catch (IllegalArgumentException e) {
            System.out.println("Fejl" + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static void removeTask(Scanner scanner) {
        System.out.println("Indtast navnet på opgaven som skal fjernes: ");
        String name = scanner.nextLine().trim();

        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(name)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Opgave fjernet.");
        } else {
            System.out.println("Opgaven blev ikke fundet.");

        }
    }

    static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Ingen opgaver at vise.");
            return;
        }

//        tasks.sort(Comparator.comparing(Task::getDeadline));
        System.out.println("\nListe over opgaver:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}