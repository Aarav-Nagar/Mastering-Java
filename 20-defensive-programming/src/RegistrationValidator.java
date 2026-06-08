import java.util.Set;

public class RegistrationValidator {
    private static final int MIN_SEATS = 1;
    private static final int MAX_SEATS = 3;
    private static final double MIN_BUDGET = 100.0;
    private static final double MAX_BUDGET = 5000.0;

    private final Set<String> supportedTracks;

    public RegistrationValidator(Set<String> supportedTracks) {
        if (supportedTracks == null || supportedTracks.isEmpty()) {
            throw new IllegalArgumentException("supportedTracks must not be empty");
        }
        this.supportedTracks = Set.copyOf(supportedTracks);
    }

    public RegistrationRequest validate(RegistrationRequest request) throws ValidationException {
        if (request == null) {
            throw new MissingFieldException("Registration request must be present.");
        }

        String attendeeName = requireText(request.getAttendeeName(), "Attendee name");
        String emailAddress = requireText(request.getEmailAddress(), "Email address");
        String trackName = requireText(request.getTrackName(), "Track name");

        if (!emailAddress.contains("@") || emailAddress.startsWith("@") || emailAddress.endsWith("@")) {
            throw new MissingFieldException("Email address must contain a local part and domain.");
        }

        if (!supportedTracks.contains(trackName)) {
            throw new UnsupportedTrackException(trackName, supportedTracks);
        }

        if (request.getSeatCount() < MIN_SEATS || request.getSeatCount() > MAX_SEATS) {
            throw new RangeValidationException(
                "Seat count",
                request.getSeatCount(),
                MIN_SEATS,
                MAX_SEATS
            );
        }

        if (request.getTeamBudget() < MIN_BUDGET || request.getTeamBudget() > MAX_BUDGET) {
            throw new RangeValidationException(
                "Team budget",
                request.getTeamBudget(),
                MIN_BUDGET,
                MAX_BUDGET
            );
        }

        return new RegistrationRequest(
            attendeeName,
            emailAddress,
            trackName,
            request.getSeatCount(),
            request.getTeamBudget()
        );
    }

    private String requireText(String value, String fieldName) throws MissingFieldException {
        if (value == null || value.trim().isEmpty()) {
            throw new MissingFieldException(fieldName + " is required.");
        }
        return value.trim();
    }
}
