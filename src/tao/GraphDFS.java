package tao;

import java.util.HashSet;
import java.util.Stack;

public class GraphDFS {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.empty()) {
            node = stack.pop();
            for (Node next : node.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    System.out.println(next.value);
                    stack.push(node);
                    stack.push(next);
                    break;//*
                }
            }
        }
    }
}
