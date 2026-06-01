import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InterfaceDesignApp {
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(Ticket.create("101", "Login button is unresponsive", Priority.HIGH, "ui"));
        tickets.add(Ticket.create("7", "Refactor parsing pipeline", Priority.MEDIUM, "backend"));
        tickets.add(Ticket.create("44", "Add onboarding copy", Priority.LOW, "docs"));

        System.out.println("Tickets (as created):");
        for (Ticket t : tickets) {
            System.out.println("  " + t.format());
        }

        System.out.println();
        System.out.println("Tickets (sorted by priority, then title):");
        tickets.sort(Comparator.comparing(Ticket::priority).reversed().thenComparing(Ticket::title));
        for (Ticket t : tickets) {
            System.out.println("  " + PrettyPrintable.box(t));
        }

        System.out.println();
        System.out.println("Quick validation examples:");
        System.out.println("  HasId.isValidRawId(\"  123 \") = " + HasId.isValidRawId("  123 "));
        System.out.println("  HasId.normalizeToId(\"  123 \") = " + HasId.normalizeToId("  123 "));
        System.out.println("  HasId.normalizeToId(\"T-999\") = " + HasId.normalizeToId("T-999"));
    }
}

