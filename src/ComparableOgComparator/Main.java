package ComparableOgComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Alice", 30));
        customers.add(new Customer("Bob", 45));
        customers.add(new Customer("Charlie", 35));

        // Sortér med naturlig rækkefølge (navn)
        System.out.println("Sorteret efter navn (naturlig rækkefølge):");
        Collections.sort(customers);
        customers.forEach(System.out::println);

        // Sortér efter alder ved hjælp af Comparator
        System.out.println("\nSorteret efter alder:");
        Collections.sort(customers, new AgeComparator());
        customers.forEach(System.out::println);

        // Andet eksempe. Sortér efter alder ved hjælp af Comparator
        System.out.println("\nSorteret efter alder (andet eksempel):");
        Collections.sort(customers, Comparator.comparing(Customer::getAge));
        customers.forEach(System.out::println);

        // Tredje eksempel. Sortér efter alder ved hjælp af Comparator
        System.out.println("\nSorteret efter alder (tredje eksempel):");
        Collections.sort(customers, (c1, c2) -> c1.getAge() - c2.getAge());
        customers.forEach(System.out::println);

        // Sortér efter længde af navn ved hjælp af Comparator
        System.out.println("\nSorteret efter længde af navn:");
        Collections.sort(customers, new LengthComparator());
        customers.forEach(System.out::println);

    }
}
