public class SessionSummary {
    private final int loadedCount;
    private final int skippedCount;
    private final int totalMinutes;
    private final int focusedMinutes;

    public SessionSummary(int loadedCount, int skippedCount, int totalMinutes, int focusedMinutes) {
        this.loadedCount = loadedCount;
        this.skippedCount = skippedCount;
        this.totalMinutes = totalMinutes;
        this.focusedMinutes = focusedMinutes;
    }

    public int getLoadedCount() {
        return loadedCount;
    }

    public int getSkippedCount() {
        return skippedCount;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public int getFocusedMinutes() {
        return focusedMinutes;
    }
}
