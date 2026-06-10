public class LinkedListPlannerApp {
    public static void main(String[] args) {
        StudyPlanService service = new StudyPlanService();
        service.seedPlan();
        service.reprioritize();

        System.out.println("Study checkpoints after inserts:");
        printCheckpoints(service.getCheckpoints());

        int debugIndex = service.findCheckpoint("Walk through removeAt edge cases");
        System.out.println();
        System.out.println("Debugging checkpoint index: " + debugIndex);

        LearningCheckpoint removed = service.removeCheckpoint(2);
        System.out.println("Removed checkpoint: " + removed);

        System.out.println();
        System.out.println("Study checkpoints after removal:");
        printCheckpoints(service.getCheckpoints());

        StudyPlanReport report = service.buildReport();
        System.out.println();
        System.out.println("Plan report:");
        System.out.println("- checkpoint count: " + report.getCheckpointCount());
        System.out.println("- total minutes: " + report.getTotalMinutes());
        System.out.println("- hands-on checkpoints: " + report.getHandsOnCount());
        System.out.println("- first checkpoint: " + report.getFirstCheckpoint());
        System.out.println("- last checkpoint: " + report.getLastCheckpoint());
    }

    private static void printCheckpoints(StudyPlanLinkedList checkpoints) {
        for (int index = 0; index < checkpoints.size(); index++) {
            System.out.println(index + ": " + checkpoints.get(index));
        }
    }
}
