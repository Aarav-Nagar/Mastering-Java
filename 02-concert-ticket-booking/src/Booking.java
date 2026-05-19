import java.time.LocalDateTime;

public class Booking {
    private final String id;
    private final String customerName;
    private final Concert concert;
    private final Seat seat;
    private final double totalPrice;
    private final LocalDateTime createdAt;

    public Booking(String id, String customerName, Concert concert, Seat seat, double totalPrice) {
        this.id = id;
        this.customerName = customerName;
        this.concert = concert;
        this.seat = seat;
        this.totalPrice = totalPrice;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Concert getConcert() {
        return concert;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return id + " | " + customerName + " | " + concert.getTitle() + " @ " + concert.getVenueName()
                + " | Seat " + seat + " | $" + String.format("%.2f", totalPrice);
    }
}

