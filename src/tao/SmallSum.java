package tao;

public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (r == l) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid)
                + process(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        if (l == r) {
            return 0;
        }
        int[] help = new int[r - l + 1];
        int p1 = l, p2 = mid + 1, i = 0, res = 0;
        while (p1 <= mid & p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + 1] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = RandomArray.generateRandomArray(9999 , 100);
        int i = smallSum(ints);
        System.out.println(i);
    }
}
