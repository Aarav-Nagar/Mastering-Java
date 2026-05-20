public final class IntStats {
    private final int min;
    private final int max;
    private final long sum;
    private final double average;

    private IntStats(int min, int max, long sum, double average) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.average = average;
    }

    public int min() {
        return min;
    }

    public int max() {
        return max;
    }

    public long sum() {
        return sum;
    }

    public double average() {
        return average;
    }

    public static IntStats from(int[] a) {
        if (a.length == 0) {
            throw new IllegalArgumentException("Array must be non-empty.");
        }

        int min = a[0];
        int max = a[0];
        long sum = 0L;

        for (int v : a) {
            if (v < min) {
                min = v;
            }
            if (v > max) {
                max = v;
            }
            sum += v;
        }

        double avg = (double) sum / a.length;
        return new IntStats(min, max, sum, avg);
    }
}
