package tao;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) {
            int[] counts = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                counts[j]++;
            }
            for (i = 1; i < counts.length; i++) {
                counts[i] += counts[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[counts[j] - 1] = arr[i];
                counts[j]--;
            }
            for (i = 0; i < help.length; i++) {
                arr[i + L] = help[i];
            }
        }
    }

    private static int getDigit(int num, int digit) {
        return (num / (int) Math.pow(10, digit - 1)) % 10;
    }

    private static int getMaxDigit(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = RandomArray.generateZhengRandomArray(20, 2000);
        System.out.println(Arrays.toString(ints));
        radixSort(ints, 0, ints.length - 1, getMaxDigit(ints));
        System.out.println(Arrays.toString(ints));
    }
}
