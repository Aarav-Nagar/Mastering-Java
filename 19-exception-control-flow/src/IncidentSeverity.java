public enum IncidentSeverity {
    P1("P1", "critical"),
    P2("P2", "high"),
    P3("P3", "moderate"),
    P4("P4", "low");

    private final String code;
    private final String label;

    IncidentSeverity(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static IncidentSeverity fromCode(String code) {
        IncidentSeverity[] values = values();
        for (int index = 0; index < values.length; index++) {
            IncidentSeverity severity = values[index];
            if (severity.code.equalsIgnoreCase(code)) {
                return severity;
            }
        }
        throw new IllegalArgumentException("Unknown severity code: " + code);
    }
}
