package tao;

import java.util.*;

public class Prim {
    public static Set<Edge> prim(Graph graph) {
        if (graph == null) {
            return null;
        }
        Set<Edge> res = new HashSet<>();
        HashSet<Node> set = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                queue.addAll(node.edges);
                while (!queue.isEmpty()) {
                    Edge se = queue.poll();
                    if (!set.contains(se.to)) {
                        set.add(se.to);
                        res.add(se);
                        queue.addAll(se.to.edges);
                    }
                }
            }
        }
        return res;
    }
}
