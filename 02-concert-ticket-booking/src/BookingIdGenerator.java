public class BookingIdGenerator {
    private int nextNumber;

    public BookingIdGenerator(int startingNumber) {
        if (startingNumber < 1) {
            throw new IllegalArgumentException("startingNumber must be >= 1");
        }
        this.nextNumber = startingNumber;
    }

    public String nextId() {
        String id = "B" + String.format("%04d", nextNumber);
        nextNumber++;
        return id;
    }
}

