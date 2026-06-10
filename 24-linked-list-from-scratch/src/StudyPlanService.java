public class StudyPlanService {
    private final StudyPlanLinkedList checkpoints;

    public StudyPlanService() {
        this.checkpoints = new StudyPlanLinkedList();
    }

    public void seedPlan() {
        checkpoints.addLast(new LearningCheckpoint("Warm up with node diagrams", "concept review", 20, false));
        checkpoints.addLast(new LearningCheckpoint("Trace pointer updates on paper", "dry run", 25, false));
        checkpoints.addLast(new LearningCheckpoint("Implement addLast and addFirst", "coding", 45, true));
        checkpoints.addLast(new LearningCheckpoint("Test indexed insertion", "coding", 35, true));
    }

    public void reprioritize() {
        checkpoints.addFirst(new LearningCheckpoint("Review linked-list tradeoffs", "strategy", 15, false));
        checkpoints.insertAt(3, new LearningCheckpoint("Walk through removeAt edge cases", "debugging", 30, true));
    }

    public LearningCheckpoint removeCheckpoint(int index) {
        return checkpoints.removeAt(index);
    }

    public int findCheckpoint(String title) {
        return checkpoints.indexOf(title);
    }

    public StudyPlanReport buildReport() {
        LearningCheckpoint first = checkpoints.size() == 0 ? null : checkpoints.get(0);
        LearningCheckpoint last = checkpoints.size() == 0 ? null : checkpoints.get(checkpoints.size() - 1);
        return new StudyPlanReport(
            checkpoints.size(),
            checkpoints.totalMinutes(),
            checkpoints.handsOnCount(),
            first,
            last
        );
    }

    public StudyPlanLinkedList getCheckpoints() {
        return checkpoints;
    }
}
