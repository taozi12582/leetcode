package tao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSerialization {
    public static String serialByPre(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String res = root.value + "_";
        res += serialByPre(root.left);
        res += serialByPre(root.right);
        return res;
    }

    public static TreeNode reConByPreString(String str) {
        String[] strings = str.split("_");
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(strings));
        return makeTree1(queue);
    }

    private static TreeNode makeTree1(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = makeTree1(queue);
        root.right = makeTree1(queue);
        return root;
    }

    public static String serializeBtInOrder(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String res = serializeBtInOrder(root.left);
        res += root.value + "_";
        res += serializeBtInOrder(root.right);
        return res;
    }

    public static TreeNode reConByInOrder(String str) {
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(str.split("_")));
        return makeTree2(queue);
    }

    private static TreeNode makeTree2(LinkedList<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        TreeNode root = makeTree2(queue);
        TreeNode right = makeTree2(queue);
        root.left = new TreeNode(Integer.parseInt(value));
        root.right = right;
        return root;
    }

    public static String serializeByPos(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String res = serializeByPos(root.left);
        res += serializeByPos(root.right);
        res += root.value + "_";
        return res;
    }

    private static TreeNode reConByPos(String str) {
        String[] strings = str.split("_");
        Stack<String> stack = new Stack<>();
        for (String s : strings) {
            stack.push(s);
        }
        return makeTree3(stack);
    }

    private static TreeNode makeTree3(Stack<String> stack) {
        String value = stack.pop();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.right = makeTree3(stack);
        root.left = makeTree3(stack);
        return root;
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
        System.out.print("原树：");
        TreeOperation.show(n5);
        System.out.println("--------------------------------------");
        System.out.print("先序序列化：");
        String byPre = serialByPre(n5);
        System.out.println(byPre);
        System.out.print("先序反序列化：");
        TreeNode root = reConByPreString(byPre);
        TreeOperation.show(root);
        System.out.println("--------------------------------------");
//        System.out.print("中序序列化：");
//        String byIn = serializeBtInOrder(n5);
//        System.out.println(byIn);
//        System.out.print("中序反序列化：");
//        root = reConByInOrder(byIn);
//        TreeOperation.show(root);
//        System.out.println("--------------------------------------");
        System.out.print("后序序列化：");
        String byPos = serializeByPos(n5);
        System.out.println(byPos);
        System.out.print("后序反序列化：");
        root = reConByPos(byPos);
        TreeOperation.show(root);
        System.out.println("--------------------------------------");
    }
}
