package ComparableOgComparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c1.getAge(), c2.getAge());
    }
}
