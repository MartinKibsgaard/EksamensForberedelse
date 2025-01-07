package ComparableOgComparator;


public class Customer implements Comparable<Customer> {
    private String name;
    private int age;

    public Customer(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Navn må ikke være tomt.");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Alder må ikke være negativ.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Implementer compareTo (naturlig rækkefølge baseret på navn)
    @Override
    public int compareTo(Customer other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', age=" + age + "}";
    }
}
