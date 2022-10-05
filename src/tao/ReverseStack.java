package tao;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int under = getUnder(stack);
        reverseStack(stack);
        stack.push(under);
    }

    private static int getUnder(Stack<Integer> stack) {
        int up = stack.pop();
        if (stack.isEmpty()) {
            return up;
        }
        int down = getUnder(stack);
        stack.push(up);
        return down;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        reverseStack(stack);
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }


}
