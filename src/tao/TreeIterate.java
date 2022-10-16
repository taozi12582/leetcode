package tao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeIterate {

    public static void preOrderIterate(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + "\t");
        preOrderIterate(root.left);
        preOrderIterate(root.right);
    }

    public static void inOrderIterate(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderIterate(root.left);
        System.out.print(root.value + "\t");
        inOrderIterate(root.right);
    }

    public static void posOrderIterate(TreeNode root) {
        if (root == null) {
            return;
        }
        posOrderIterate(root.left);
        posOrderIterate(root.right);
        System.out.print(root.value + "\t");
    }

    public static void preOrderUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + "\t");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }

    public static void posOrderUnRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.empty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }
        while (!s2.empty()) {
            System.out.print(s2.pop().value + "\t");
        }
        System.out.println();
    }

    public static void inOrderUnCur(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.value + "\t");
                root = root.right;
            }
        }
        System.out.println();
    }

    private static void pushLeftInStack(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    private static void widthIterate(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print("\t" + root.value);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
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
        //        preOrderIterate(root);
//        System.out.println();
//        preOrderUnRecur(root);
//        System.out.println("---------------------------");
//        inOrderIterate(root);
//        System.out.println();
//        inOrderUnCur(root);
//        System.out.println("---------------------------");
//        posOrderIterate(root);
//        System.out.println();
//        posOrderUnRecur(root);
        TreeOperation.show(n5);
//        widthIterate(n5);
        inTree(n5);
    }

    public static void inTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = root;
        while (temp.left != null) {
            stack.push(temp.left);
            temp = temp.left;
        }
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.println(temp.value);
            if (temp.right != null) {
                temp = temp.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
    }
}
