package tao;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = findMax(arr);
        int[] bucket = new int[max + 1];
        for (int i : arr) {
            bucket[i]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = RandomArray.generateZhengRandomArray(40, 40);
        System.out.println(Arrays.toString(ints));
        countingSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
