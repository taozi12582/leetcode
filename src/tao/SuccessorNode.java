package tao;

public class SuccessorNode {
    private static class Node {
        Node parent;
        Node left;
        ;
        Node right;
        int value;

        public Node(Node parent, Node left, Node right, int value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public static Node findSuccessor(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (node.parent != null && node.parent.left != node) {
                node = node.parent;
            }
            return node.parent;
        }
    }
}
