package tao;

public class MaxTreeDistance {
    public static class ReturnType {
        public int maxDistance;
        public int length;

        public ReturnType(int maxDistance, int length) {
            this.maxDistance = maxDistance;
            this.length = length;
        }
    }

    public static int getMaxDistance(TreeNode root) {
        return process(root).maxDistance;
    }

    public static ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, 0);
        }
        ReturnType left = process(root.left);
        ReturnType right = process(root.right);
        int length = Math.max(left.length, right.length) + 1;
        int maxDistance = Math.max(left.maxDistance, Math.max(right.maxDistance, left.length + right.length + 1));
        return new ReturnType(maxDistance, length);
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
        TreeOperation.show(n5);
        System.out.println(getMaxDistance(n5));
    }
}
