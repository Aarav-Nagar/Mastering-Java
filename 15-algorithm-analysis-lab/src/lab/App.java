package lab;

import java.util.ArrayList;
import java.util.List;

import lab.algorithms.InsertionSort;
import lab.algorithms.MergeSort;
import lab.algorithms.SelectionSort;
import lab.bench.Benchmark;
import lab.bench.BenchmarkResult;
import lab.util.ArrayGenerator;

public final class App {
    public static void main(String[] args) {
        Options options = Options.parse(args);

        List<Benchmark.IntArrayAlgorithm> algorithms = new ArrayList<Benchmark.IntArrayAlgorithm>();
        algorithms.add(new Benchmark.IntArrayAlgorithm("selectionSort", SelectionSort::sortInPlace));
        algorithms.add(new Benchmark.IntArrayAlgorithm("insertionSort", InsertionSort::sortInPlace));
        algorithms.add(new Benchmark.IntArrayAlgorithm("mergeSort", MergeSort::sortedCopy));

        System.out.println("Pattern: " + options.pattern);
        System.out.println("Trials: " + options.trials);
        System.out.println();

        Benchmark benchmark = new Benchmark(algorithms, options.pattern, options.trials, options.seed);

        for (int size = options.minSize; size <= options.maxSize; size += options.step) {
            List<BenchmarkResult> results = benchmark.run(size);
            System.out.printf("n=%d  ", size);
            for (BenchmarkResult result : results) {
                System.out.printf("%s=%s  ", result.name(), result.medianMillisFormatted());
            }
            System.out.println();
        }
    }

    private static final class Options {
        private final int minSize;
        private final int maxSize;
        private final int step;
        private final int trials;
        private final long seed;
        private final ArrayGenerator.Pattern pattern;

        private Options(int minSize, int maxSize, int step, int trials, long seed, ArrayGenerator.Pattern pattern) {
            this.minSize = minSize;
            this.maxSize = maxSize;
            this.step = step;
            this.trials = trials;
            this.seed = seed;
            this.pattern = pattern;
        }

        static Options parse(String[] args) {
            int minSize = 200;
            int maxSize = 4000;
            int step = 400;
            int trials = 5;
            long seed = 1337L;
            ArrayGenerator.Pattern pattern = ArrayGenerator.Pattern.RANDOM;

            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                if ("--minSize".equals(arg)) {
                    minSize = Integer.parseInt(requireValue(args, ++i, "--minSize"));
                } else if ("--maxSize".equals(arg)) {
                    maxSize = Integer.parseInt(requireValue(args, ++i, "--maxSize"));
                } else if ("--step".equals(arg)) {
                    step = Integer.parseInt(requireValue(args, ++i, "--step"));
                } else if ("--trials".equals(arg)) {
                    trials = Integer.parseInt(requireValue(args, ++i, "--trials"));
                } else if ("--seed".equals(arg)) {
                    seed = Long.parseLong(requireValue(args, ++i, "--seed"));
                } else if ("--pattern".equals(arg)) {
                    pattern = ArrayGenerator.Pattern.parse(requireValue(args, ++i, "--pattern"));
                } else {
                    throw new IllegalArgumentException("Unknown arg: " + arg);
                }
            }

            if (minSize <= 0 || maxSize < minSize || step <= 0 || trials <= 0) {
                throw new IllegalArgumentException("Invalid sizes/step/trials configuration");
            }

            return new Options(minSize, maxSize, step, trials, seed, pattern);
        }

        private static String requireValue(String[] args, int idx, String flag) {
            if (idx < 0 || idx >= args.length) {
                throw new IllegalArgumentException("Missing value for " + flag);
            }
            return args[idx];
        }
    }
}

