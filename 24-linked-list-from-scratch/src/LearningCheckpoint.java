public class LearningCheckpoint {
    private final String title;
    private final String category;
    private final int estimatedMinutes;
    private final boolean handsOn;

    public LearningCheckpoint(String title, String category, int estimatedMinutes, boolean handsOn) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be blank.");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category must not be blank.");
        }
        if (estimatedMinutes <= 0) {
            throw new IllegalArgumentException("Estimated minutes must be positive.");
        }
        this.title = title;
        this.category = category;
        this.estimatedMinutes = estimatedMinutes;
        this.handsOn = handsOn;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public boolean isHandsOn() {
        return handsOn;
    }

    @Override
    public String toString() {
        return title + " [" + category + ", " + estimatedMinutes + " mins, hands-on=" + handsOn + "]";
    }
}
