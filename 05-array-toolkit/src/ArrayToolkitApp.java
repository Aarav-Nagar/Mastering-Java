import java.util.Arrays;
import java.util.Scanner;

public class ArrayToolkitApp {
    private static final int[] EMPTY = new int[0];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] working = EMPTY;

        while (true) {
            printHeader(working);
            printMenu();

            int choice = ConsoleIO.readIntInRange(scanner, "Choose an option: ", 0, 7);
            if (choice == 0) {
                System.out.println("Goodbye.");
                return;
            }

            switch (choice) {
                case 1:
                    working = ConsoleIO.readIntArray(scanner, "Enter integers separated by spaces: ");
                    break;
                case 2:
                    runStats(working);
                    break;
                case 3:
                    working = ensureNonEmptyThenTransform(scanner, working, "Reverse", ArrayUtils::reversedCopy);
                    break;
                case 4:
                    working = ensureNonEmptyThenRotate(scanner, working);
                    break;
                case 5:
                    runLinearSearch(scanner, working);
                    break;
                case 6:
                    runBinarySearch(scanner, working);
                    break;
                case 7:
                    working = ensureNonEmptyThenClamp(scanner, working);
                    break;
                default:
                    System.out.println("Unexpected option.");
            }

            System.out.println();
        }
    }

    private static void printHeader(int[] working) {
        System.out.println("=== Array Toolkit (Day 05) ===");
        System.out.println("Working array: " + Arrays.toString(working));
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("1) Build/replace array");
        System.out.println("2) Stats (min/max/sum/avg)");
        System.out.println("3) Reverse (copy)");
        System.out.println("4) Rotate left/right by k (copy)");
        System.out.println("5) Linear search");
        System.out.println("6) Sort copy + binary search");
        System.out.println("7) Clamp into [lo, hi] (copy)");
        System.out.println("0) Exit");
        System.out.println();
    }

    private static void runStats(int[] a) {
        if (a.length == 0) {
            System.out.println("No data yet. Build an array first (option 1).");
            return;
        }

        IntStats stats = IntStats.from(a);
        System.out.println("Count: " + a.length);
        System.out.println("Min:   " + stats.min());
        System.out.println("Max:   " + stats.max());
        System.out.println("Sum:   " + stats.sum());
        System.out.printf("Avg:   %.3f%n", stats.average());
    }

    private static void runLinearSearch(Scanner scanner, int[] a) {
        if (a.length == 0) {
            System.out.println("No data yet. Build an array first (option 1).");
            return;
        }

        int target = ConsoleIO.readInt(scanner, "Value to search for: ");
        int index = ArrayUtils.linearSearch(a, target);
        if (index < 0) {
            System.out.println("Not found.");
        } else {
            System.out.println("Found at index " + index + ".");
        }
    }

    private static void runBinarySearch(Scanner scanner, int[] a) {
        if (a.length == 0) {
            System.out.println("No data yet. Build an array first (option 1).");
            return;
        }

        int target = ConsoleIO.readInt(scanner, "Value to binary-search for: ");
        int[] sorted = ArrayUtils.sortedCopy(a);
        int index = ArrayUtils.binarySearch(sorted, target);
        System.out.println("Sorted copy: " + Arrays.toString(sorted));
        if (index < 0) {
            System.out.println("Not found in sorted copy.");
        } else {
            System.out.println("Found in sorted copy at index " + index + ".");
        }
    }

    private static int[] ensureNonEmptyThenRotate(Scanner scanner, int[] a) {
        if (a.length == 0) {
            System.out.println("No data yet. Build an array first (option 1).");
            return a;
        }

        int k = ConsoleIO.readInt(scanner, "Rotate by k (can be negative): ");
        return ArrayUtils.rotatedCopy(a, k);
    }

    private static int[] ensureNonEmptyThenClamp(Scanner scanner, int[] a) {
        if (a.length == 0) {
            System.out.println("No data yet. Build an array first (option 1).");
            return a;
        }

        int lo = ConsoleIO.readInt(scanner, "Lower bound lo: ");
        int hi = ConsoleIO.readInt(scanner, "Upper bound hi: ");
        if (lo > hi) {
            System.out.println("lo > hi; swapping them.");
            int tmp = lo;
            lo = hi;
            hi = tmp;
        }
        return ArrayUtils.clampedCopy(a, lo, hi);
    }

    private static int[] ensureNonEmptyThenTransform(
            Scanner scanner,
            int[] a,
            String label,
            IntArrayTransform transform
    ) {
        if (a.length == 0) {
            System.out.println("No data yet. Build an array first (option 1).");
            return a;
        }

        int[] out = transform.apply(a);
        System.out.println(label + " result: " + Arrays.toString(out));
        return out;
    }
}

