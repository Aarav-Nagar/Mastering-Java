import java.util.Arrays;

public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static int[] reversedCopy(int[] a) {
        int[] out = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = a[a.length - 1 - i];
        }
        return out;
    }

    public static int[] rotatedCopy(int[] a, int k) {
        int n = a.length;
        if (n == 0) {
            return new int[0];
        }

        int shift = k % n;
        if (shift < 0) {
            shift += n;
        }

        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            int j = (i + shift) % n;
            out[j] = a[i];
        }
        return out;
    }

    public static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] sortedCopy(int[] a) {
        int[] out = Arrays.copyOf(a, a.length);
        Arrays.sort(out);
        return out;
    }

    public static int binarySearch(int[] sorted, int target) {
        int lo = 0;
        int hi = sorted.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int value = sorted[mid];
            if (value == target) {
                return mid;
            }
            if (value < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static int[] clampedCopy(int[] a, int lo, int hi) {
        int[] out = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int v = a[i];
            if (v < lo) {
                v = lo;
            } else if (v > hi) {
                v = hi;
            }
            out[i] = v;
        }
        return out;
    }
}

