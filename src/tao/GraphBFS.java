package tao;

import java.util.HashSet;
import java.util.LinkedList;

public class GraphBFS {
    public static void BFS(Node node) {
        if (node == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.println(node.value);
            for (Node n : node.nexts) {
                if(!set.contains(n)){
                    queue.add(n);
                    set.add(n);
                }
            }
        }
    }
}
