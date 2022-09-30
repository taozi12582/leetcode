package tao;

import java.util.*;

public class Kruskal {
    public static class MySets {
        //每一个点所在的集合，所以是node对应node的List
        public HashMap<Node, List<Node>> setMap;

        public MySets(List<Node> nodes) {
            for (Node cur : nodes) {
                ArrayList<Node> list = new ArrayList<>();
                list.add(cur);
                setMap.put(cur, list);
            }
        }

        //内存地址相同就是一个集合，否则就不是
        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode,fromSet);//这里的意思是to节点对应的list就不要了，把自己加到fromList里面后，把自己的集合指向fromList
            }
        }
    }

    public static Set<Edge> kruskalMST(Graph graph){
        MySets mySets = new MySets((List<Node>) graph.nodes.values());
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>((a, b) -> a.weight - b.weight);
        ArrayList<Node> res = new ArrayList<>();

    }


}
