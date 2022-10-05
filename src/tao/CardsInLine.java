package tao;

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

    public static void main(String[] args) {
        int[] ints = {
                1, 2, 3, 4, 5, 100, 3
        };
        System.out.println(firstHand(ints, 0, ints.length - 1));
        System.out.println(lastHand(ints, 0, ints.length - 1));
    }
}
