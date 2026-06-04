public class IncidentRecord {
    private final IncidentSeverity severity;
    private final String title;
    private final int ackMinutes;
    private final int engineerCount;

    public IncidentRecord(IncidentSeverity severity, String title, int ackMinutes, int engineerCount) {
        this.severity = severity;
        this.title = title;
        this.ackMinutes = ackMinutes;
        this.engineerCount = engineerCount;
    }

    public IncidentSeverity getSeverity() {
        return severity;
    }

    public String getTitle() {
        return title;
    }

    public int getAckMinutes() {
        return ackMinutes;
    }

    public int getEngineerCount() {
        return engineerCount;
    }
}
