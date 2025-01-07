package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Generisk klasse til at administrere varer
public class ItemContainer<T> {
    private List<T> items;

    public ItemContainer() {
        items = new ArrayList<>();
    }

    // Tilføjer et element
    public void addItem(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    // Fjerner elementer baseret på et kriterium
    public void removeItems(Predicate<T> condition) {
        items.removeIf(condition);
    }

    // Finder elementer baseret på et kriterium
    public List<T> findItems(Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // Viser alle elementer
    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}