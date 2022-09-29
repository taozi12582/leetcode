package tao;

import java.util.*;

public class GraphSortedTopology {
    public static List<Node> sortedTopology(Graph graph) {
        LinkedList<Node> zeroInNodes = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        for (Node node : graph.nodes.values()) {
            map.put(node, node.in);
            if (node.in == 0) {
                zeroInNodes.add(node);
            }
        }
        ArrayList<Node> res = new ArrayList<>();
        while (!zeroInNodes.isEmpty()) {
            Node node = zeroInNodes.poll();
            res.add(node);
            for (Node n : node.nexts) {
                int in = map.get(n) - 1;
                map.put(n, in);
                if (in == 0) {
                    zeroInNodes.add(n);
                }
            }
        }
        return res;
    }
}
