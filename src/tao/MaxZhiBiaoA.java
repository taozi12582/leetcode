package tao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxZhiBiaoA {
    public static int getMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> pop = stack.pop();
                pop.remove(0);
                int lmIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                res = Math.max(arr[i] * getSum(arr, lmIndex + 1, i - 1), res);
                if (!pop.isEmpty()) {
                    stack.push(pop);
                }
            }
            if (stack.isEmpty() || arr[i] > arr[stack.peek().get(0)]) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                stack.push(temp);
            } else if (arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            int index = pop.remove(0);
            int lmIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            if (!pop.isEmpty()) {
                stack.push(pop);
            }
            res = Math.max(res, arr[index] * getSum(arr, lmIndex + 1, index));
        }
        return res;
    }

    private static int getSum(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int res = 0;
        for (int i = l; i <= r; i++) {
            res += arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 6, 7, 8, 4};
        System.out.println(getMax(arr));
    }
}
