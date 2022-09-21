package tao;

import java.util.Arrays;

public class HeLanGuoQi {
    public static void process(int[] arr, int flag) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int p1 = -1, p3 = arr.length, i = 0;
        while (i < p3) {
            if (arr[i] < flag) {
                swap(arr, i++, ++p1);
            } else if (arr[i] > flag) {
                swap(arr, i, --p3);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void main(String[] args) {
        int[] ints = RandomArray.generateRandomArray(10, 10);
        System.out.println(Arrays.toString(ints));
        System.out.println("--------------");
        process(ints, 6);
        System.out.println(Arrays.toString(ints));
    }

}
