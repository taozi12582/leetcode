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
        if (root.value <= preValue) {
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

    public static boolean isBSTMorris(TreeNode root) {
        if (root == null) {
            return true;
        }
        int pre = Integer.MIN_VALUE;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode mr = cur.left;
                while (mr.right != null && mr.right != cur) {
                    mr = mr.right;
                }
                if (mr.right == null) {
                    mr.right = cur;
                    cur = cur.left;
                } else {
                    mr.right = null;
                    if (pre >= cur.value) {
                        return false;
                    }
                    pre = cur.value;
                    cur = cur.right;
                }
            } else {
                if (pre >= cur.value) {
                    return false;
                }
                pre = cur.value;
                cur = cur.right;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        n9.left = n6;
        n6.left = n5;
        n6.right = n8;
        n9.right = n12;
        n12.left = n10;
        n12.right = n11;
//        n10.right = n11;
        n12.right = n13;
        TreeOperation.show(n9);
        System.out.println(isBSTMorris(n9));
    }
}
