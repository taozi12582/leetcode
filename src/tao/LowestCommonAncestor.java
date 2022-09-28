package tao;

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
        TreeNode node = findNode(n5, n10, n8);
        System.out.println(node.value);
    }
}
