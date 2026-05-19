import java.util.List;
import java.util.Scanner;

public class ConcertTicketBookingApp {
    public static void main(String[] args) {
        TicketSystem system = TicketSystem.sampleData();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Concert Ticket Booking System");
        System.out.println("-----------------------------");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
            case "1":
                listConcerts(system);
                break;
            case "2":
                showAvailability(system, scanner);
                break;
            case "3":
                createBooking(system, scanner);
                break;
            case "4":
                cancelBooking(system, scanner);
                break;
            case "5":
                listBookingsForCustomer(system, scanner);
                break;
            case "0":
                running = false;
                break;
            default:
                System.out.println("Please enter a valid option.");
            }

            System.out.println();
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Menu");
        System.out.println("1) List concerts");
        System.out.println("2) View available seats in a row");
        System.out.println("3) Book a seat");
        System.out.println("4) Cancel a booking");
        System.out.println("5) List bookings for a customer");
        System.out.println("0) Exit");
        System.out.print("> ");
    }

    private static void listConcerts(TicketSystem system) {
        System.out.println("Concerts:");
        for (int i = 0; i < system.getConcertCount(); i++) {
            System.out.println((i + 1) + ") " + system.getConcert(i));
        }
    }

    private static void showAvailability(TicketSystem system, Scanner scanner) {
        Concert concert = promptConcert(system, scanner);
        if (concert == null) {
            return;
        }

        int rowIndex = promptInt(scanner, "Row number (1-" + concert.getRows() + "): ", 1, concert.getRows());
        List<Seat> seats = concert.listAvailableSeatsInRow(rowIndex);
        if (seats.isEmpty()) {
            System.out.println("No seats available in that row.");
            return;
        }

        System.out.println("Available seats in row " + rowIndex + ":");
        for (Seat seat : seats) {
            System.out.println("- " + seat + " ($" + String.format("%.2f", concert.priceFor(seat)) + ")");
        }
    }

    private static void createBooking(TicketSystem system, Scanner scanner) {
        Concert concert = promptConcert(system, scanner);
        if (concert == null) {
            return;
        }

        System.out.print("Customer name: ");
        String customer = scanner.nextLine().trim();
        if (customer.isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        System.out.print("Seat (ex: A1, B12): ");
        String seatText = scanner.nextLine().trim();

        Seat seat = Seat.parse(seatText);
        if (seat == null || !concert.isValidSeat(seat)) {
            System.out.println("That seat is not valid for this concert.");
            return;
        }

        try {
            Booking booking = system.bookSeat(concert, customer, seat);
            System.out.println("Booked!");
            System.out.println(booking);
        } catch (RuntimeException e) {
            System.out.println("Could not book: " + e.getMessage());
        }
    }

    private static void cancelBooking(TicketSystem system, Scanner scanner) {
        System.out.print("Booking id to cancel (ex: B0001): ");
        String bookingId = scanner.nextLine().trim();
        if (bookingId.isEmpty()) {
            System.out.println("Booking id cannot be empty.");
            return;
        }

        Booking cancelled = system.cancelBooking(bookingId);
        if (cancelled == null) {
            System.out.println("No booking found with id " + bookingId + ".");
        } else {
            System.out.println("Cancelled:");
            System.out.println(cancelled);
        }
    }

    private static void listBookingsForCustomer(TicketSystem system, Scanner scanner) {
        System.out.print("Customer name: ");
        String customer = scanner.nextLine().trim();
        if (customer.isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        List<Booking> bookings = system.findBookingsForCustomer(customer);
        if (bookings.isEmpty()) {
            System.out.println("No bookings found for " + customer + ".");
            return;
        }

        System.out.println("Bookings for " + customer + ":");
        for (Booking booking : bookings) {
            System.out.println("- " + booking);
        }
    }

    private static Concert promptConcert(TicketSystem system, Scanner scanner) {
        if (system.getConcertCount() == 0) {
            System.out.println("No concerts are loaded.");
            return null;
        }

        listConcerts(system);
        int pick = promptInt(scanner, "Choose a concert (1-" + system.getConcertCount() + "): ", 1, system.getConcertCount());
        return system.getConcert(pick - 1);
    }

    private static int promptInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String text = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(text);
                if (value < min || value > max) {
                    System.out.println("Enter a number from " + min + " to " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Enter a whole number.");
            }
        }
    }
}

