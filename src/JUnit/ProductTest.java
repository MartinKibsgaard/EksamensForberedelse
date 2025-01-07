package JUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        // Initialiserer et produkt med pris 100 og lager 10
        product = new Product(100.0, 10);
    }

    @Test
    void testCalculateDiscount_NormalCase() {
        // Test for en rabat på 20%
        double discountedPrice = product.calculateDiscount(20.0);
        assertEquals(80.0, discountedPrice, "Rabatberegning er forkert");
    }

    @Test
    void testCalculateDiscount_ZeroPercent() {
        // Test for 0% rabat
        double discountedPrice = product.calculateDiscount(0.0);
        assertEquals(100.0, discountedPrice, "Rabatberegning for 0% fejlede");
    }

    @Test
    void testCalculateDiscount_ThrowsException() {
        // Test for negativ rabat
        assertThrows(IllegalArgumentException.class, () -> {
            product.calculateDiscount(-10.0);
        }, "Forventede IllegalArgumentException for negativ rabat");

        // Test for rabat over 100%
        assertThrows(IllegalArgumentException.class, () -> {
            product.calculateDiscount(110.0);
        }, "Forventede IllegalArgumentException for rabat over 100%");
    }

    @Test
    void testUpdateStock_NormalCase() {
        // Test for normalt salg
        int remainingStock = product.updateStock(5);
        assertEquals(5, remainingStock, "Lageropdatering fejlede");
    }

    @Test
    void testUpdateStock_ThrowsException() {
        // Test for salg større end lagerbeholdning
        assertThrows(IllegalArgumentException.class, () -> {
            product.updateStock(15);
        }, "Forventede IllegalArgumentException for salg større end lager");
    }
}
