import java.util.ArrayList;
import java.util.List;

public class TicketSystem {
    private final List<Concert> concerts;
    private final List<Booking> bookings;
    private final BookingIdGenerator bookingIdGenerator;

    public TicketSystem() {
        this.concerts = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.bookingIdGenerator = new BookingIdGenerator(1);
    }

    public void addConcert(Concert concert) {
        concerts.add(concert);
    }

    public int getConcertCount() {
        return concerts.size();
    }

    public Concert getConcert(int index) {
        return concerts.get(index);
    }

    public Booking bookSeat(Concert concert, String customerName, Seat seat) {
        String id = bookingIdGenerator.nextId();
        Booking booking = concert.reserve(id, customerName, seat);
        bookings.add(booking);
        return booking;
    }

    public Booking cancelBooking(String bookingId) {
        Booking cancelled = null;
        for (Concert concert : concerts) {
            cancelled = concert.cancelByBookingId(bookingId);
            if (cancelled != null) {
                break;
            }
        }
        if (cancelled == null) {
            return null;
        }
        bookings.removeIf(b -> b.getId().equalsIgnoreCase(bookingId));
        return cancelled;
    }

    public List<Booking> findBookingsForCustomer(String customerName) {
        List<Booking> matches = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getCustomerName().equalsIgnoreCase(customerName)) {
                matches.add(booking);
            }
        }
        return matches;
    }

    public static TicketSystem sampleData() {
        TicketSystem system = new TicketSystem();
        system.addConcert(new Concert("Yellowjacket Nights", "2026-09-04", "Tech Green Amphitheater", 6, 12, 18.00));
        system.addConcert(new Concert("Midtown Synthwave", "2026-10-16", "Atlanta Loop Arena", 8, 14, 22.00));
        system.addConcert(new Concert("Peachtree Jazz Hour", "2026-11-08", "Peachtree Theatre", 5, 10, 16.00));
        return system;
    }
}

