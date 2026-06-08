import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DefensiveProgrammingApp {
    public static void main(String[] args) {
        Map<String, Integer> trackCapacity = new LinkedHashMap<String, Integer>();
        trackCapacity.put("Backend Foundations", 3);
        trackCapacity.put("Data Pipelines", 2);
        trackCapacity.put("Platform Reliability", 2);

        WorkshopRegistry registry = new WorkshopRegistry(trackCapacity);
        RegistrationValidator validator = new RegistrationValidator(registry.getSupportedTracks());

        List<RegistrationRequest> requests = Arrays.asList(
            new RegistrationRequest("Mia Chen", "mia.chen@example.com", "Backend Foundations", 2, 900.0),
            new RegistrationRequest("", "samir@example.com", "Data Pipelines", 1, 500.0),
            new RegistrationRequest("Jordan Patel", "jordan@example.com", "Platform Reliability", 0, 300.0),
            new RegistrationRequest("Nina Lopez", "nina@example.com", "Security Labs", 1, 800.0),
            new RegistrationRequest("Evan Brooks", "evan@example.com", "Backend Foundations", 2, 1200.0),
            new RegistrationRequest("Tara Singh", "tara@example.com", "Backend Foundations", 1, 450.0)
        );

        System.out.println("== Workshop intake review ==");
        System.out.println();

        for (RegistrationRequest request : requests) {
            reviewRequest(request, validator, registry);
        }

        System.out.println();
        System.out.println("== Accepted seat usage ==");
        for (String track : registry.getSupportedTracks()) {
            System.out.println(track + ": " + registry.getReservedSeats(track) + "/" + registry.getCapacity(track));
        }
    }

    private static void reviewRequest(
        RegistrationRequest request,
        RegistrationValidator validator,
        WorkshopRegistry registry
    ) {
        System.out.println("Reviewing " + request.getDisplayName() + " for " + request.getTrackName());
        try {
            RegistrationRequest safeRequest = validator.validate(request);
            registry.register(safeRequest);
            System.out.println("  Accepted for " + safeRequest.getSeatCount() + " seat(s).");
        } catch (ValidationException e) {
            System.out.println("  Rejected: " + e.getMessage());
        }
    }
}
