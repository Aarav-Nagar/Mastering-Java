import java.util.ArrayList;

public final class ArrayListWorkbench {
    private ArrayListWorkbench() {
    }

    public static <T> ArrayList<T> copy(ArrayList<T> items) {
        ArrayList<T> result = new ArrayList<T>();
        for (T item : items) {
            result.add(item);
        }
        return result;
    }

    public static <T> ArrayList<T> uniquePreservingOrder(ArrayList<T> items) {
        ArrayList<T> uniqueItems = new ArrayList<T>();
        for (T item : items) {
            if (!uniqueItems.contains(item)) {
                uniqueItems.add(item);
            }
        }
        return uniqueItems;
    }

    public static <T> ArrayList<T> rotateLeft(ArrayList<T> items, int positions) {
        ArrayList<T> rotated = new ArrayList<T>();
        if (items.isEmpty()) {
            return rotated;
        }

        int normalized = positions % items.size();
        if (normalized < 0) {
            normalized += items.size();
        }

        for (int index = 0; index < items.size(); index++) {
            int sourceIndex = (index + normalized) % items.size();
            rotated.add(items.get(sourceIndex));
        }
        return rotated;
    }

    public static <T extends RankedItem> ArrayList<T> sortByPriorityDescending(ArrayList<T> items) {
        ArrayList<T> sorted = copy(items);
        for (int pass = 0; pass < sorted.size() - 1; pass++) {
            int bestIndex = pass;
            for (int scan = pass + 1; scan < sorted.size(); scan++) {
                if (sorted.get(scan).getPriorityScore() > sorted.get(bestIndex).getPriorityScore()) {
                    bestIndex = scan;
                }
            }
            if (bestIndex != pass) {
                T saved = sorted.get(pass);
                sorted.set(pass, sorted.get(bestIndex));
                sorted.set(bestIndex, saved);
            }
        }
        return sorted;
    }

    public static <T extends RankedItem> T highestPriority(ArrayList<T> items) {
        if (items.isEmpty()) {
            throw new IllegalArgumentException("Cannot choose from an empty list.");
        }
        T best = items.get(0);
        for (int index = 1; index < items.size(); index++) {
            T candidate = items.get(index);
            if (candidate.getPriorityScore() > best.getPriorityScore()) {
                best = candidate;
            }
        }
        return best;
    }
}
