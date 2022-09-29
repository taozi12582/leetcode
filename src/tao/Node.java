package tao;

import java.util.ArrayList;

public class Node {
    //节点的值
    public int value;
    //入度
    public int in;
    //出度
    public int out;
    //从该节点发散出去的点集合，即从该点指向的别的点
    public ArrayList<Node> nexts;
    //哪些边属于自己，即哪些边的屁股对着自己
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
