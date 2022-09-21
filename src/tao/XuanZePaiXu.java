package tao;

import java.util.Arrays;

public class XuanZePaiXu {
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(arr[min], arr[j]) == arr[min] ? min : j;
            }
            swap(arr, min, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] ints = RandomArray.generateRandomArray(20, 20);
        System.out.println(Arrays.toString(ints));
        selectSort(ints);
        System.out.println(Arrays.toString(ints));
    }

}
