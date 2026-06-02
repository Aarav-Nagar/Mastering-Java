public enum WorkPriority {
    LOW,
    MEDIUM,
    HIGH,
    CRITICAL;

    public WorkPriority escalate() {
        if (this == LOW) {
            return MEDIUM;
        }
        if (this == MEDIUM) {
            return HIGH;
        }
        if (this == HIGH) {
            return CRITICAL;
        }
        return CRITICAL;
    }
}
