import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concert {
    private final String title;
    private final String date;
    private final String venueName;
    private final int rows;
    private final int seatsPerRow;
    private final double basePrice;
    private final Map<Seat, Booking> bookingsBySeat;

    public Concert(String title, String date, String venueName, int rows, int seatsPerRow, double basePrice) {
        if (rows < 1 || seatsPerRow < 1) {
            throw new IllegalArgumentException("rows and seatsPerRow must be >= 1");
        }
        this.title = title;
        this.date = date;
        this.venueName = venueName;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.basePrice = basePrice;
        this.bookingsBySeat = new HashMap<>();
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getRows() {
        return rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public double priceFor(Seat seat) {
        double rowBonus = 2.0 * (rows - seat.getRowIndex());
        return Math.max(5.0, basePrice + rowBonus);
    }

    public boolean isValidSeat(Seat seat) {
        return seat.getRowIndex() >= 1 && seat.getRowIndex() <= rows
                && seat.getNumber() >= 1 && seat.getNumber() <= seatsPerRow;
    }

    public boolean isAvailable(Seat seat) {
        return isValidSeat(seat) && !bookingsBySeat.containsKey(seat);
    }

    public Booking reserve(String bookingId, String customerName, Seat seat) {
        if (!isValidSeat(seat)) {
            throw new IllegalArgumentException("Seat " + seat + " is out of range for this concert.");
        }
        if (!isAvailable(seat)) {
            throw new IllegalStateException("Seat " + seat + " is already booked.");
        }
        Booking booking = new Booking(bookingId, customerName, this, seat, priceFor(seat));
        bookingsBySeat.put(seat, booking);
        return booking;
    }

    public Booking cancelByBookingId(String bookingId) {
        Seat seatToRemove = null;
        Booking bookingToRemove = null;
        for (Map.Entry<Seat, Booking> entry : bookingsBySeat.entrySet()) {
            if (entry.getValue().getId().equalsIgnoreCase(bookingId)) {
                seatToRemove = entry.getKey();
                bookingToRemove = entry.getValue();
                break;
            }
        }
        if (seatToRemove == null) {
            return null;
        }
        bookingsBySeat.remove(seatToRemove);
        return bookingToRemove;
    }

    public List<Seat> listAvailableSeatsInRow(int rowIndex) {
        List<Seat> available = new ArrayList<>();
        for (int seatNumber = 1; seatNumber <= seatsPerRow; seatNumber++) {
            Seat seat = new Seat(rowIndex, seatNumber);
            if (isAvailable(seat)) {
                available.add(seat);
            }
        }
        return available;
    }

    public int countAvailableSeats() {
        return (rows * seatsPerRow) - bookingsBySeat.size();
    }

    @Override
    public String toString() {
        return title + " (" + date + ") @ " + venueName + " | Available: " + countAvailableSeats();
    }
}
