public class IncidentBatch {
    private final String name;
    private final String[] rawEntries;

    public IncidentBatch(String name, String[] rawEntries) {
        this.name = name;
        this.rawEntries = rawEntries;
    }

    public String getName() {
        return name;
    }

    public String[] getRawEntries() {
        return rawEntries;
    }
}
