package tao;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(j, j + 1, arr);
            }
        }

    }

    private static void swap(int j, int i, int[] arr) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] ints = RandomArray.generateRandomArray(20, 20);
        System.out.println(Arrays.toString(ints));
        remember(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void remember(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1 && arr[j] < arr[j - 1]; j--) {
                swap(j, j - 1, arr);
            }
        }
    }
}
