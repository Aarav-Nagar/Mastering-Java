package lab;

import java.util.Arrays;
import java.util.Locale;

import lab.algorithms.BinarySearch;
import lab.algorithms.InsertionSort;
import lab.algorithms.LinearSearch;
import lab.algorithms.MergeSort;
import lab.algorithms.SelectionSort;
import lab.util.ArrayGenerator;
import lab.util.ArrayVerifier;
import lab.util.Stopwatch;

public final class App {
    private static final int DEFAULT_SIZE = 50;
    private static final int DEFAULT_TRIALS = 3;

    public static void main(String[] args) {
        Options options = Options.parse(args);

        int[] base = ArrayGenerator.generate(options.size, options.pattern, options.seed);
        System.out.println("Pattern: " + options.pattern);
        System.out.println("Size: " + options.size);
        System.out.println("Seed: " + options.seed);
        System.out.println();

        for (int trial = 1; trial <= options.trials; trial++) {
            int[] data = Arrays.copyOf(base, base.length);
            Stopwatch stopwatch = Stopwatch.startNew();

            switch (options.mode) {
                case "selectionsort":
                    SelectionSort.sort(data);
                    break;
                case "insertionsort":
                    InsertionSort.sort(data);
                    break;
                case "mergesort":
                    data = MergeSort.sortedCopy(data);
                    break;
                case "linearsearch": {
                    int idx = LinearSearch.search(data, options.searchTarget);
                    stopwatch.stop();
                    System.out.printf("Trial %d: linearSearch(target=%d) -> %d (%s)%n",
                            trial, options.searchTarget, idx, stopwatch);
                    continue;
                }
                case "binarysearch": {
                    int[] sorted = MergeSort.sortedCopy(data);
                    int idx = BinarySearch.search(sorted, options.searchTarget);
                    stopwatch.stop();
                    System.out.printf("Trial %d: binarySearch(target=%d) -> %d (%s)%n",
                            trial, options.searchTarget, idx, stopwatch);
                    continue;
                }
                default:
                    throw new IllegalStateException("Unknown mode: " + options.mode);
            }

            stopwatch.stop();
            boolean sorted = ArrayVerifier.isSortedNonDecreasing(data);
            System.out.printf("Trial %d: %s -> sorted=%s (%s)%n", trial, options.mode, sorted, stopwatch);

            if (options.print && options.size <= 200) {
                System.out.println(Arrays.toString(data));
            }
        }
    }

    private static final class Options {
        private final String mode;
        private final int size;
        private final int trials;
        private final long seed;
        private final ArrayGenerator.Pattern pattern;
        private final int searchTarget;
        private final boolean print;

        private Options(String mode, int size, int trials, long seed, ArrayGenerator.Pattern pattern, int searchTarget,
                boolean print) {
            this.mode = mode;
            this.size = size;
            this.trials = trials;
            this.seed = seed;
            this.pattern = pattern;
            this.searchTarget = searchTarget;
            this.print = print;
        }

        private static Options parse(String[] args) {
            String mode = "mergesort";
            int size = DEFAULT_SIZE;
            int trials = DEFAULT_TRIALS;
            long seed = 1337L;
            ArrayGenerator.Pattern pattern = ArrayGenerator.Pattern.RANDOM;
            int target = 0;
            boolean print = false;

            for (int i = 0; i < args.length; i++) {
                String arg = args[i].toLowerCase(Locale.ROOT);
                switch (arg) {
                    case "--mode":
                        mode = requireValue(args, ++i, "--mode");
                        break;
                    case "--size":
                        size = Integer.parseInt(requireValue(args, ++i, "--size"));
                        break;
                    case "--trials":
                        trials = Integer.parseInt(requireValue(args, ++i, "--trials"));
                        break;
                    case "--seed":
                        seed = Long.parseLong(requireValue(args, ++i, "--seed"));
                        break;
                    case "--pattern":
                        pattern = ArrayGenerator.Pattern.parse(requireValue(args, ++i, "--pattern"));
                        break;
                    case "--target":
                        target = Integer.parseInt(requireValue(args, ++i, "--target"));
                        break;
                    case "--print":
                        print = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown arg: " + args[i]);
                }
            }

            String normalizedMode = mode.toLowerCase(Locale.ROOT).replaceAll("[^a-z]", "");
            return new Options(normalizedMode, size, trials, seed, pattern, target, print);
        }

        private static String requireValue(String[] args, int idx, String flag) {
            if (idx < 0 || idx >= args.length) {
                throw new IllegalArgumentException("Missing value for " + flag);
            }
            return args[idx];
        }
    }
}
