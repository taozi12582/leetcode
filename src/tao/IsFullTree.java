package tao;

public class IsFullTree {
    public static class ReturnData {
        public int height;
        public int nodes;

        public ReturnData(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static boolean isFullTree(TreeNode root) {
        ReturnData data = process(root);
        return (1 << data.height) - 1 == data.nodes;
    }

    public static ReturnData process(TreeNode root) {
        if (root == null) {
            return new ReturnData(0, 0);
        }
        ReturnData left = process(root.left);
        ReturnData right = process(root.right);
        int height = Math.max(left.height, right.height) + 1;
        int nodes = left.nodes + right.nodes + 1;
        return new ReturnData(height, nodes);
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
        System.out.println(
                isFullTree(n5)
        );
    }
}
