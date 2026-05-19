# Concert Ticket Booking System

Small console app that models concerts, seats, and bookings.

This is practice for:
- classes + composition (Concert has Seats, Booking ties everything together)
- collections (`ArrayList`, `HashMap`)
- input validation + simple command menus

## How to Run

From this project folder:

```bash
javac -d out src/*.java
java -cp out ConcertTicketBookingApp
```

## Notes

- Seats are labeled like `A1`, `B12`, etc.
- Bookings receive an id like `B0001` so you can cancel later.

