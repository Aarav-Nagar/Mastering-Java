package lab.algorithms;

public final class SelectionSort {
    private SelectionSort() {}

    public static int[] sortInPlace(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
        return data;
    }

    private static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}

