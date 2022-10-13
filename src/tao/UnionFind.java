package tao;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    public static class Element<V> {
        private V value;

        public Element(V v) {
            this.value = v;
        }
    }

    public static class UnionSet<V> {
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionSet(List<V> list) {
            this.elementMap = new HashMap<>();
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> stack = new Stack<>();
            while (fatherMap.get(element) != element) {
                stack.push(element);
                element = fatherMap.get(element);
            }
            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> e1 = elementMap.get(a);
                Element<V> e2 = elementMap.get(b);
                Element<V> head1 = findHead(e1);
                Element<V> head2 = findHead(e2);
                if (head1 != head2) {
                    Element<V> bigHead = sizeMap.get(head1) > sizeMap.get(head2) ? head1 : head2;
                    Element<V> smallHead = bigHead == head1 ? head2 : head1;
                    fatherMap.put(smallHead, bigHead);
                    sizeMap.put(bigHead, sizeMap.get(bigHead) + sizeMap.get(smallHead));
                    sizeMap.remove(smallHead);
                }
            }
        }
    }
}
