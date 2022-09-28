package tao;

import java.util.LinkedList;

public class IsCBT {
    public static boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                if (root.left == null) {
                    return false;
                }
                queue.add(root.left);
                queue.add(root.right);
            } else if (root.left == null) {
                while (!queue.isEmpty()) {
                    root = queue.pop();
                    if (root.left != null || root.right != null) {
                        return false;
                    }
                }
            } else {
                queue.add(root.left);
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
        n5.left = n6;
        n6.left = n9;
        n6.right = n10;
        n5.right = n8;
        n8.left = n11;
//        n8.right = n12;
        TreeOperation.show(n5);
        System.out.println(isCBT(n5));
    }
}
