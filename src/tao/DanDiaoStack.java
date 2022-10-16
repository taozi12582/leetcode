package tao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DanDiaoStack {
    public static String[] getLRMax(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return new String[0];
        }
        Stack<List<Integer>> stack = new Stack<>();
        String[] res = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] < arr[i]) {
                List<Integer> pop = stack.pop();
                int index = pop.remove(0);
                int lm = stack.isEmpty() ? -999 : arr[stack.peek().get(stack.peek().size() - 1)];
                int rm = arr[i];
                if (!pop.isEmpty()) {
                    stack.push(pop);
                }
                res[index] = "(" + lm + "," + rm + ")";
            }
            if (stack.isEmpty() || arr[stack.peek().get(0)] > arr[i]) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                stack.push(temp);
            } else if (arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            Integer index = pop.remove(0);
            int rm = -999;
            int lm = stack.isEmpty() ? -999 : arr[stack.peek().get(stack.peek().size() - 1)];
            if (!pop.isEmpty()) {
                stack.push(pop);
            }
            res[index] = res[index] = "(" + lm + "," + rm + ")";
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 4, 5, 2, 5, 6};
        String[] lrMax = getLRMax(arr);
        for (String s : lrMax) {
            System.out.println(s);
        }
    }
}
