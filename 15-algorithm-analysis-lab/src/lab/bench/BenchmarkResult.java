package lab.bench;

import java.util.Arrays;

public final class BenchmarkResult {
    private final String name;
    private final double[] millis;

    private BenchmarkResult(String name, double[] millis) {
        this.name = name;
        this.millis = millis;
    }

    public static BenchmarkResult fromMillis(String name, double[] millis) {
        return new BenchmarkResult(name, Arrays.copyOf(millis, millis.length));
    }

    public String name() {
        return name;
    }

    public double medianMillis() {
        double[] copy = Arrays.copyOf(millis, millis.length);
        Arrays.sort(copy);
        int mid = copy.length / 2;
        if (copy.length % 2 == 1) {
            return copy[mid];
        }
        return (copy[mid - 1] + copy[mid]) / 2.0;
    }

    public String medianMillisFormatted() {
        return String.format("%.3fms", medianMillis());
    }
}

