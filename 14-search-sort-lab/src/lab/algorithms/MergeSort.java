package lab.algorithms;

import java.util.Arrays;

public final class MergeSort {
    private MergeSort() {}

    public static int[] sortedCopy(int[] data) {
        int[] copy = Arrays.copyOf(data, data.length);
        sort(copy, 0, copy.length);
        return copy;
    }

    private static void sort(int[] data, int startInclusive, int endExclusive) {
        int length = endExclusive - startInclusive;
        if (length <= 1) {
            return;
        }

        int mid = startInclusive + (length / 2);
        sort(data, startInclusive, mid);
        sort(data, mid, endExclusive);
        merge(data, startInclusive, mid, endExclusive);
    }

    private static void merge(int[] data, int startInclusive, int mid, int endExclusive) {
        int[] left = Arrays.copyOfRange(data, startInclusive, mid);
        int[] right = Arrays.copyOfRange(data, mid, endExclusive);

        int i = 0;
        int j = 0;
        int k = startInclusive;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                data[k++] = left[i++];
            } else {
                data[k++] = right[j++];
            }
        }
        while (i < left.length) {
            data[k++] = left[i++];
        }
        while (j < right.length) {
            data[k++] = right[j++];
        }
    }
}

