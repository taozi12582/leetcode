package tao;

import java.util.HashMap;
import java.util.LinkedList;

public class TreeMaxWidth {
    public static int getTreeMaxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        queue.add(root);
        int curLevel = 1, curLevelNodes = 0;
        while (!queue.isEmpty()) {
            root = queue.poll();
            int level = map.get(root);
            if (level == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            if (root.left != null) {
                queue.add(root.left);
                map.put(root.left, level + 1);
            }
            if (root.right != null) {
                queue.add(root.right);
                map.put(root.right, level + 1);
            }
        }
        return max;
    }

    public static int getMaxWidthWithoutHash(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int max = 0;
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        int curLevelNodes = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                queue.add(root.left);
                nextEnd = root.left;
            }
            if (root.right != null) {
                queue.add(root.right);
                nextEnd = root.right;
            }
            curLevelNodes++;
            if (curEnd == root) {
                max = Math.max(max, curLevelNodes);
                curEnd = nextEnd;
                curLevelNodes = 0;
            }
        }
        return max;
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
        n10.right = n12;
        TreeOperation.show(n5);
        System.out.println(getTreeMaxWidth(n5));
        System.out.println(getMaxWidthWithoutHash(n5));
    }
}
