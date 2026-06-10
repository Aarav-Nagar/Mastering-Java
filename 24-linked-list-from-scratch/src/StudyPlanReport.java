public class StudyPlanReport {
    private final int checkpointCount;
    private final int totalMinutes;
    private final int handsOnCount;
    private final LearningCheckpoint firstCheckpoint;
    private final LearningCheckpoint lastCheckpoint;

    public StudyPlanReport(
        int checkpointCount,
        int totalMinutes,
        int handsOnCount,
        LearningCheckpoint firstCheckpoint,
        LearningCheckpoint lastCheckpoint
    ) {
        this.checkpointCount = checkpointCount;
        this.totalMinutes = totalMinutes;
        this.handsOnCount = handsOnCount;
        this.firstCheckpoint = firstCheckpoint;
        this.lastCheckpoint = lastCheckpoint;
    }

    public int getCheckpointCount() {
        return checkpointCount;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public int getHandsOnCount() {
        return handsOnCount;
    }

    public LearningCheckpoint getFirstCheckpoint() {
        return firstCheckpoint;
    }

    public LearningCheckpoint getLastCheckpoint() {
        return lastCheckpoint;
    }
}
