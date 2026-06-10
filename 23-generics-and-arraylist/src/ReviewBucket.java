import java.util.ArrayList;

public class ReviewBucket<T extends RankedItem> {
    private final String name;
    private final ArrayList<T> items;

    public ReviewBucket(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Bucket name must not be blank.");
        }
        this.name = name;
        this.items = new ArrayList<T>();
    }

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Bucket items must not be null.");
        }
        items.add(item);
    }

    public ArrayList<T> snapshot() {
        return ArrayListWorkbench.copy(items);
    }

    public ArrayList<T> prioritizedView() {
        return ArrayListWorkbench.sortByPriorityDescending(items);
    }

    public ArrayList<String> labels() {
        ArrayList<String> labels = new ArrayList<String>();
        for (T item : items) {
            labels.add(item.getLabel());
        }
        return labels;
    }

    public double averagePriority() {
        if (items.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (T item : items) {
            total += item.getPriorityScore();
        }
        return (double) total / items.size();
    }

    public T highestPriority() {
        return ArrayListWorkbench.highestPriority(items);
    }

    public String getName() {
        return name;
    }
}
