package tao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
    public static Map<Node, Integer> dijkstra(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> touchedSet = new HashSet<>();
        Node minNode = head;
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                if (!distanceMap.containsKey(edge.to)) {
                    distanceMap.put(edge.to, distance + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(edge.to), distance + edge.weight));
                }
            }
            touchedSet.add(minNode);
            minNode = findMinNode(distanceMap, touchedSet);
        }
        return distanceMap;
    }

    private static Node findMinNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedSet) {
        int minDistance = Integer.MAX_VALUE;
        Node minNode = null;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            if (entry.getValue() < minDistance && !touchedSet.contains(entry.getKey())) {
                minDistance = entry.getValue();
                minNode = entry.getKey();
            }
        }
        return minNode;
    }
}
