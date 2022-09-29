package tao;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {
    public static class ReturnData {
        public boolean hasN1;
        public boolean hasN2;
        public TreeNode node;

        public ReturnData(boolean hasN1, boolean hasN2, TreeNode treeNode) {
            this.hasN1 = hasN1;
            this.hasN2 = hasN2;
            this.node = treeNode;
        }
    }

    public static TreeNode findNode(TreeNode root, TreeNode node1, TreeNode node2) {
        return process(root, node1, node2).node;
    }

    public static ReturnData process(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) {
            return new ReturnData(false, false, null);
        }
        ReturnData left = process(root.left, n1, n2);
        ReturnData right = process(root.right, n1, n2);
        boolean hasN1 = left.hasN1 || right.hasN1;
        boolean hasN2 = left.hasN2 || right.hasN2;
        TreeNode node = null;
        if ((left.hasN1 && !left.hasN2 && right.hasN2 && !right.hasN1) ||
                (!left.hasN1 && left.hasN2 && right.hasN1 && !right.hasN2) ||
                (root == n1 && (right.hasN2 || left.hasN2)) ||
                (root == n2 && (left.hasN1 || right.hasN1))
        ) {
            node = root;
        }
        if (left.node != null || right.node != null) {
            node = left.node != null ? left.node : right.node;
        }
        if (root == n1 && right.hasN2) {
            node = root;
        }
        return new ReturnData(hasN1 || root == n1, hasN2 || root == n2, node);
    }

    public static TreeNode findNode2(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null || root == n1 || root == n2) {
            return root;
        }
        TreeNode left = findNode2(root.left, n1, n2);
        TreeNode right = findNode2(root.right, n1, n2);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
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
        n8.right = n12;
        TreeOperation.show(n5);
//        TreeNode node = findNode(n5, n10, n8);
        TreeNode node = findLowestA2(n5, n10, n9);
        System.out.println(node.value);
    }

    public static void doHashMap(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        while (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        doHashMap(root.left, map);
        doHashMap(root.right, map);
    }

    public static TreeNode findLowestA2(TreeNode root, TreeNode n1, TreeNode n2) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, root);
        doHashMap(root, map);
        HashSet<TreeNode> set = new HashSet<>();
        TreeNode cur = n1;
        while (map.get(cur) != cur) {
            set.add(cur);
            cur = map.get(cur);
        }
        cur = n2;
        while (!set.contains(cur)) {
            cur = map.get(cur);
        }
        return cur;
    }


}
