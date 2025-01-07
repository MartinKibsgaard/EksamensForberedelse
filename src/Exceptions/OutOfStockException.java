package Exceptions;

// Custom exception for out-of-stock errors
public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}
