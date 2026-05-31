package lab.util;

public final class ArrayVerifier {
    private ArrayVerifier() {}

    public static boolean isSortedNonDecreasing(int[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1] > data[i]) {
                return false;
            }
        }
        return true;
    }
}

