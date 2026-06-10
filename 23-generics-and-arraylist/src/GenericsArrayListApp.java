import java.util.ArrayList;

public class GenericsArrayListApp {
    public static void main(String[] args) {
        ReviewBucket<StudyModule> studyBucket = new ReviewBucket<StudyModule>("Study backlog");
        studyBucket.add(new StudyModule("Generics wildcard review", 45, 9, false));
        studyBucket.add(new StudyModule("Practice ArrayList insert/remove", 35, 8, false));
        studyBucket.add(new StudyModule("Build reusable queue exercise", 70, 10, true));
        studyBucket.add(new StudyModule("Refactor collection helpers", 55, 7, true));

        ReviewBucket<PairProgrammingMatch> collaborationBucket = new ReviewBucket<PairProgrammingMatch>("Pairing backlog");
        collaborationBucket.add(new PairProgrammingMatch("Mia", "debug generic bounds", 8, 2));
        collaborationBucket.add(new PairProgrammingMatch("Leo", "practice test data builders", 6, 1));
        collaborationBucket.add(new PairProgrammingMatch("Sana", "ship collection utility demo", 9, 3));

        System.out.println(studyBucket.getName() + ":");
        printBucket(studyBucket);

        System.out.println();
        System.out.println(collaborationBucket.getName() + ":");
        printBucket(collaborationBucket);

        ArrayList<String> repeatedTags = new ArrayList<String>();
        repeatedTags.add("generics");
        repeatedTags.add("arraylist");
        repeatedTags.add("generics");
        repeatedTags.add("practice");
        repeatedTags.add("arraylist");

        System.out.println();
        System.out.println("Reusable helper examples:");
        System.out.println("- unique tags: " + ArrayListWorkbench.uniquePreservingOrder(repeatedTags));
        System.out.println("- rotated study labels: "
            + ArrayListWorkbench.rotateLeft(studyBucket.labels(), 1));
    }

    private static <T extends RankedItem> void printBucket(ReviewBucket<T> bucket) {
        System.out.println("- average priority: " + String.format("%.2f", bucket.averagePriority()));
        System.out.println("- highest priority: " + bucket.highestPriority());
        System.out.println("- full prioritized view:");
        for (T item : bucket.prioritizedView()) {
            System.out.println("  * " + item);
        }
    }
}
