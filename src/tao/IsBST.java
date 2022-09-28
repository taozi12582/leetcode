package tao;

import java.util.Stack;

public class IsBST {

    private static int preValue = Integer.MIN_VALUE;

    public static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean flag = isBST(root.left);
        if (!flag) {
            return false;
        }
        if (root.value >= preValue) {
            return false;
        }
        preValue = root.value;
        return isBST(root.right);
    }

    public static boolean isBSTUnCur(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int preValue = Integer.MIN_VALUE;
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.value <= preValue) {
                    return false;
                }
                preValue = root.value;
                root = root.right;
            }
        }
        return true;
    }

    public static class ReturnData {
        public int max;
        public int min;
        public boolean isBST;

        public ReturnData(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public static boolean isBST2(TreeNode root) {
        return process2(root).isBST;
    }

    public static ReturnData process2(TreeNode root) {
        if (root == null) {
            return null;
        }
        ReturnData left = process2(root.left);
        ReturnData right = process2(root.right);
        int min = root.value;
        int max = root.value;
        if (left != null) {
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right != null) {
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }
        boolean isBST = true;
        if (left != null && (root.value <= left.max || !left.isBST)) {
            isBST = false;
        }
        if (right != null && (root.value >= right.min || !right.isBST)) {
            isBST = false;
        }
        return new ReturnData(max, min, isBST);
    }
}
