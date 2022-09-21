package tao;

public class QuickSort {
    public static void quickSort(int[] arr, int l, int r) {
        if (arr == null || arr.length < 2) {
            return;
        }
        if (l < r) {
            swap(arr, r, l + (int) (Math.random() * (r - l + 1)));
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int p1 = l - 1, i = l, p2 = r;
        int flag = arr[r];
        while (i < p2) {
            if (arr[i] < flag) {
                swap(arr, i++, ++p1);
            } else if (arr[i] > flag) {
                swap(arr, i, --p2);
            } else {
                i++;
            }
        }
        swap(arr, p2, r);
        return new int[]{p1 + 1, p2 - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
