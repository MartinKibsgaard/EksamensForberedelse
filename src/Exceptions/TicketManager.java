package Exceptions;

public class TicketManager {
    private int availableTickets = 10; // Start med 10 billetter

    public void købBilletter(int antal) throws OutOfStockException {
        if (antal <= 0) {
            throw new IllegalArgumentException("Antal billetter skal være større end nul.");
        }
        if (antal > availableTickets) {
            throw new OutOfStockException("Der er ikke nok billetter på lager. Kun " + availableTickets + " tilgængelige.");
        }
        availableTickets -= antal;
        System.out.println("Du har købt " + antal + " billet(ter).");
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}
