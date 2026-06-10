public class PairProgrammingMatch implements RankedItem {
    private final String partnerName;
    private final String sharedGoal;
    private final int priorityScore;
    private final int overlapHours;

    public PairProgrammingMatch(String partnerName, String sharedGoal, int priorityScore, int overlapHours) {
        if (partnerName == null || partnerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Partner name must not be blank.");
        }
        if (sharedGoal == null || sharedGoal.trim().isEmpty()) {
            throw new IllegalArgumentException("Shared goal must not be blank.");
        }
        if (priorityScore < 1 || priorityScore > 10) {
            throw new IllegalArgumentException("Priority score must be between 1 and 10.");
        }
        if (overlapHours < 0) {
            throw new IllegalArgumentException("Overlap hours cannot be negative.");
        }
        this.partnerName = partnerName;
        this.sharedGoal = sharedGoal;
        this.priorityScore = priorityScore;
        this.overlapHours = overlapHours;
    }

    public String getSharedGoal() {
        return sharedGoal;
    }

    public int getOverlapHours() {
        return overlapHours;
    }

    @Override
    public String getLabel() {
        return partnerName;
    }

    @Override
    public int getPriorityScore() {
        return priorityScore;
    }

    @Override
    public String toString() {
        return partnerName + " (goal=" + sharedGoal + ", overlap=" + overlapHours
            + "h, priority " + priorityScore + ")";
    }
}
