package tao;

public class IsBalancedTree {
    public static class ReturnType {
        public int depth;
        public boolean isBalanced;

        public ReturnType(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }

    public static boolean isBalancedTree(TreeNode root) {
        ReturnType res = process(root);
        return res.isBalanced;
    }

    private static ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, true);
        }
        ReturnType left = process(root.left);
        ReturnType right = process(root.right);

        boolean flag = left.isBalanced && right.isBalanced
                && Math.abs(left.depth - right.depth) < 2;
        int depth = Math.max(left.depth + 1, right.depth + 1);
        return new ReturnType(depth, flag);
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
        n12.left = n13;
        TreeOperation.show(n5);
        System.out.println(isBalancedTree(n5));
    }
}
