package lab.bench;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lab.util.ArrayGenerator;
import lab.util.Stopwatch;

public final class Benchmark {
    public static final class IntArrayAlgorithm {
        private final String name;
        private final IntArrayFn fn;

        public IntArrayAlgorithm(String name, IntArrayFn fn) {
            this.name = name;
            this.fn = fn;
        }
    }

    @FunctionalInterface
    public interface IntArrayFn {
        int[] run(int[] input);
    }

    private final List<IntArrayAlgorithm> algorithms;
    private final ArrayGenerator.Pattern pattern;
    private final int trials;
    private final long seed;

    public Benchmark(List<IntArrayAlgorithm> algorithms, ArrayGenerator.Pattern pattern, int trials, long seed) {
        this.algorithms = new ArrayList<IntArrayAlgorithm>(algorithms);
        this.pattern = pattern;
        this.trials = trials;
        this.seed = seed;
    }

    public List<BenchmarkResult> run(int size) {
        int[] base = ArrayGenerator.generate(size, pattern, seed ^ size);

        List<BenchmarkResult> results = new ArrayList<BenchmarkResult>();
        for (IntArrayAlgorithm algorithm : algorithms) {
            double[] millis = new double[trials];
            for (int t = 0; t < trials; t++) {
                int[] input = Arrays.copyOf(base, base.length);
                Stopwatch stopwatch = Stopwatch.startNew();
                int[] out = algorithm.fn.run(input);
                stopwatch.stop();
                if (!ArrayGenerator.isNonDecreasing(out)) {
                    throw new IllegalStateException("Algorithm did not sort: " + algorithm.name);
                }
                millis[t] = stopwatch.elapsedMillis();
            }
            results.add(BenchmarkResult.fromMillis(algorithm.name, millis));
        }
        return results;
    }
}
