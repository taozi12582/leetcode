package tao;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        //只有key就是treeSet结构，既有key又有value就是treeMap结构
        //treeMap中格局key来有序组织，有序表必须要求我们的key是可以比较的
        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(7, "我是7");
        treeMap1.put(5, "我是5");
        treeMap1.put(4, "我是4");
        treeMap1.put(3, "我是3");
        treeMap1.put(9, "我是9");
        treeMap1.put(2, "我是2");
        System.out.println("是否包含key为5的内容：" + treeMap1.containsKey(5));
        System.out.println("获得key为5的值：" + treeMap1.get(5));
        System.out.println("最小的key：" + treeMap1.firstKey());
        System.out.println("最大的key：" + treeMap1.lastKey());
        System.out.println("大于等于8里面，离8最近的key：" + treeMap1.ceilingKey(8));
        System.out.println("小于等于7里面，离7最近的key：" + treeMap1.floorKey(7));
        System.out.println("大于等于7里面，离7最近的key：" + treeMap1.ceilingKey(8));
        //删除key为5对应的节点
        treeMap1.remove(5);

        TreeMap<ListNode, String> treeMap2 = new TreeMap<>((a, b) -> a.value - b.value);
    }
}
