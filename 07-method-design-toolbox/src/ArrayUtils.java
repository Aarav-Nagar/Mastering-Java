import java.util.Arrays;

public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static int[] reversedCopy(int[] values) {
        if (values == null) {
            return new int[0];
        }
        int[] out = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            out[i] = values[values.length - 1 - i];
        }
        return out;
    }

    public static int[] rotateRightCopy(int[] values, int k) {
        if (values == null || values.length == 0) {
            return new int[0];
        }
        int[] out = Arrays.copyOf(values, values.length);
        rotateRightInPlace(out, k);
        return out;
    }

    public static void rotateRightInPlace(int[] values, int k) {
        if (values == null || values.length == 0) {
            return;
        }
        int shift = k % values.length;
        if (shift < 0) {
            shift += values.length;
        }
        reverse(values, 0, values.length - 1);
        reverse(values, 0, shift - 1);
        reverse(values, shift, values.length - 1);
    }

    private static void reverse(int[] values, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            int tmp = values[i];
            values[i] = values[j];
            values[j] = tmp;
            i++;
            j--;
        }
    }
}

