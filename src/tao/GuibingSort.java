package tao;

import java.util.Arrays;

public class GuibingSort {
    public static void process(int[] arr, int L, int R) {
        //空数组的时候，l为0，r为-1
        if (arr == null || L <= R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) {
//        int[] ints = RandomArray.generateRandomArray(20, 20);
        int[] ints = new int[]{};
        System.out.println(Arrays.toString(ints));
//        System.out.println(ints.length - 1);
        mergeSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    private static void mergeSort(int[] arr, int L, int R) {
        //空数组的时候，l为0，r为-1
        if (arr == null || L >= R) {
            return;
        }
        //防止R+L整数越界，而且位运算更快
        //这里注意加括号，因为算数运算的优先级要高于移位运算，移位运算高于位运算
        int mid = L + ((R - L) >> 1);
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge_r(arr, L, mid, R);
    }

    private static void merge_r(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l, p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= r) {
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        for (int i = l, j = 0; j < help.length; i++, j++) {
            arr[i] = help[j];
        }
    }

}
