public final class RegistrationRequest {
    private final String attendeeName;
    private final String emailAddress;
    private final String trackName;
    private final int seatCount;
    private final double teamBudget;

    public RegistrationRequest(
        String attendeeName,
        String emailAddress,
        String trackName,
        int seatCount,
        double teamBudget
    ) {
        this.attendeeName = attendeeName;
        this.emailAddress = emailAddress;
        this.trackName = trackName;
        this.seatCount = seatCount;
        this.teamBudget = teamBudget;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTrackName() {
        return trackName;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public double getTeamBudget() {
        return teamBudget;
    }

    public String getDisplayName() {
        if (attendeeName == null || attendeeName.trim().isEmpty()) {
            return "<missing attendee>";
        }
        return attendeeName.trim();
    }
}
