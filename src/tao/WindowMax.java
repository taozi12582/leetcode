package tao;

import java.util.Arrays;
import java.util.LinkedList;

public class WindowMax {
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || arr.length == 0 || w <= 1 || w > arr.length) {
            return arr;
        }
        int[] res = new int[arr.length - (w - 1)];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
                list.pollLast();
            }
            list.addLast(i);
        }
        int index = 0;
        res[index] = arr[list.peekFirst()];
        for (int R = w, L = 0; R < arr.length; R++, L++) {
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[R]) {
                list.pollLast();
            }
            list.addLast(R);
            if (list.peekFirst() == L) {
                list.pollFirst();
            }
            res[++index] = arr[list.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 6, 3, 7, 5, 3, 5};
        int[] res = getMaxWindow(arr, 3);
        System.out.println(Arrays.toString(res));
    }
}
