public class StudyModule implements RankedItem {
    private final String topic;
    private final int estimatedMinutes;
    private final int priorityScore;
    private final boolean projectHeavy;

    public StudyModule(String topic, int estimatedMinutes, int priorityScore, boolean projectHeavy) {
        if (topic == null || topic.trim().isEmpty()) {
            throw new IllegalArgumentException("Topic must not be blank.");
        }
        if (estimatedMinutes <= 0) {
            throw new IllegalArgumentException("Estimated minutes must be positive.");
        }
        if (priorityScore < 1 || priorityScore > 10) {
            throw new IllegalArgumentException("Priority score must be between 1 and 10.");
        }
        this.topic = topic;
        this.estimatedMinutes = estimatedMinutes;
        this.priorityScore = priorityScore;
        this.projectHeavy = projectHeavy;
    }

    public String getTopic() {
        return topic;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public boolean isProjectHeavy() {
        return projectHeavy;
    }

    @Override
    public String getLabel() {
        return topic;
    }

    @Override
    public int getPriorityScore() {
        return priorityScore;
    }

    @Override
    public String toString() {
        return topic + " (" + estimatedMinutes + " mins, priority " + priorityScore
            + ", project-heavy=" + projectHeavy + ")";
    }
}
