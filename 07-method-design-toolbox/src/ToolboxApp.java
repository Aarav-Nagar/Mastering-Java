import java.util.Arrays;

public class ToolboxApp {
    public static void main(String[] args) {
        System.out.println("=== Day 07: Method Design Toolbox ===");
        while (true) {
            printMenu();
            int choice = ConsoleIO.readInt("Choose an option: ");
            System.out.println();

            switch (choice) {
                case 0:
                    System.out.println("Goodbye.");
                    return;
                case 1:
                    demoClampAndRound();
                    break;
                case 2:
                    demoGcdLcm();
                    break;
                case 3:
                    demoMeanMedian();
                    break;
                case 4:
                    demoStringCounts();
                    break;
                case 5:
                    demoArrayRotation();
                    break;
                default:
                    System.out.println("Unknown option.");
            }

            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("0) Exit");
        System.out.println("1) Clamp + round demos");
        System.out.println("2) GCD / LCM");
        System.out.println("3) Mean / median");
        System.out.println("4) String normalize + count occurrences + palindrome");
        System.out.println("5) Array reverse + rotate");
    }

    private static void demoClampAndRound() {
        double value = ConsoleIO.readDouble("Value: ");
        double min = ConsoleIO.readDouble("Min: ");
        double max = ConsoleIO.readDouble("Max: ");
        int decimals = ConsoleIO.readInt("Round to decimals (0+): ");

        double clamped = NumericUtils.clamp(value, min, max);
        double rounded = NumericUtils.roundTo(clamped, decimals);

        System.out.println("Clamped: " + clamped);
        System.out.println("Rounded: " + rounded);
    }

    private static void demoGcdLcm() {
        long a = ConsoleIO.readInt("a: ");
        long b = ConsoleIO.readInt("b: ");
        System.out.println("gcd(a, b) = " + NumericUtils.gcd(a, b));
        System.out.println("lcm(a, b) = " + NumericUtils.lcm(a, b));
    }

    private static void demoMeanMedian() {
        int n = ConsoleIO.readInt("How many numbers? ");
        if (n <= 0) {
            System.out.println("Need at least 1 number.");
            return;
        }
        double[] values = new double[n];
        for (int i = 0; i < n; i++) {
            values[i] = ConsoleIO.readDouble("Value " + (i + 1) + ": ");
        }

        System.out.println("Values: " + Arrays.toString(values));
        System.out.println("Mean:   " + NumericUtils.mean(values));
        System.out.println("Median: " + NumericUtils.median(values));
    }

    private static void demoStringCounts() {
        String text = ConsoleIO.readLine("Text: ");
        String needle = ConsoleIO.readLine("Search term: ");
        boolean ignoreCase = ConsoleIO.readYesNo("Ignore case? (y/n): ");

        String normalized = StringUtils.normalizeSpaces(text);
        int count = StringUtils.countOccurrences(normalized, needle, ignoreCase);
        boolean palindrome = StringUtils.isPalindromeLettersOnly(normalized);

        System.out.println("Normalized: " + normalized);
        System.out.println("Occurrences: " + count);
        System.out.println("Palindrome (letters/digits only): " + palindrome);
    }

    private static void demoArrayRotation() {
        int n = ConsoleIO.readInt("Array length: ");
        if (n < 0) {
            System.out.println("Length must be >= 0.");
            return;
        }
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = ConsoleIO.readInt("Value " + (i + 1) + ": ");
        }
        int k = ConsoleIO.readInt("Rotate right by k: ");

        int[] reversed = ArrayUtils.reversedCopy(values);
        int[] rotated = ArrayUtils.rotateRightCopy(values, k);

        System.out.println("Original: " + Arrays.toString(values));
        System.out.println("Reversed: " + Arrays.toString(reversed));
        System.out.println("Rotated:  " + Arrays.toString(rotated));
    }
}
