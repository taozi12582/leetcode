package tao;

import java.util.Arrays;

public class CardsInLine {
    public static int firstHand(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(arr[L] + lastHand(arr, L + 1, R), arr[R] + lastHand(arr, L, R - 1));
    }

    private static int lastHand(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        return Math.min(firstHand(arr, L + 1, R), firstHand(arr, L, R - 1));
    }

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(
                firstHand(arr, 0, arr.length - 1),
                lastHand(arr, 0, arr.length - 1)
        );
    }

    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] fArr = new int[arr.length][arr.length];
        int[][] lArr = new int[arr.length][arr.length];
        for (int j = 0; j < fArr.length; j++) {
            fArr[j][j] = arr[j];
        }
        for (int col = 1; col < arr.length; col++) {
            for (int j = col, i = 0; j < arr.length; i++, j++) {
                fArr[i][j] = Math.max(arr[i] + lArr[i + 1][j], arr[j] + lArr[i][j - 1]);
                lArr[i][j] = Math.min(fArr[i + 1][j], fArr[i][j - 1]);
            }
        }
        return Math.max(fArr[0][arr.length - 1], lArr[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] ints = {
                1, 2, 3, 4, 5, 100, 3
        };
        System.out.println(firstHand(ints, 0, ints.length - 1));
        System.out.println(lastHand(ints, 0, ints.length - 1));
        System.out.println(win2(ints));
    }

    public static void printArr(int[][] arr) {
        for (int[] arr1 : arr) {
            System.out.println(Arrays.toString(arr1));
        }
        System.out.println("------------------------------------");
    }
}
