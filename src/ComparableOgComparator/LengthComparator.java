package ComparableOgComparator;

import java.util.Comparator;

public class LengthComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return Integer.compare(c1.getName().length(), c2.getName().length());
    }
}
