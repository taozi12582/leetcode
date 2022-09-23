package tao;

import java.util.Arrays;

public class ShellSort {
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                for (int j = i; j - step >= 0 && arr[j] < arr[j - step]; j -= step) {
                    swap(j, j - step, arr);
                }
            }
        }
    }

    private static void swap(int j, int i, int[] arr) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = RandomArray.generateRandomArray(20, 20);
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
