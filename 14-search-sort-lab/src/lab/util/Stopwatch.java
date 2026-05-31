package lab.util;

public final class Stopwatch {
    private final long startNanos;
    private long endNanos;
    private boolean stopped;

    private Stopwatch() {
        this.startNanos = System.nanoTime();
    }

    public static Stopwatch startNew() {
        return new Stopwatch();
    }

    public void stop() {
        if (stopped) {
            return;
        }
        stopped = true;
        endNanos = System.nanoTime();
    }

    public long elapsedNanos() {
        long end = stopped ? endNanos : System.nanoTime();
        return end - startNanos;
    }

    @Override
    public String toString() {
        double ms = elapsedNanos() / 1_000_000.0;
        return String.format("%.3f ms", ms);
    }
}

