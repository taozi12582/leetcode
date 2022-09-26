package tao;

public class FindListCrossNode {
    public static ListNode findNode(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        int n1 = 1, n2 = 1;
        ListNode t1 = l1, t2 = l2;
        while (t1.next != null) {
            n1++;
            t1 = t1.next;
        }
        while (t2.next != null) {
            n2++;
            t2 = t2.next;
        }
        if (t1 != t2) {
            return null;
        }
        int diff = n1 - n2;
        t1 = l1;
        t2 = l2;
        if (diff > 0) {//l1长，让l1先遍历
            for (int i = 0; i < diff; i++) {
                t1 = t1.next;
            }
        } else {
            for (int i = 0; i < -diff; i++) {
                t2 = t2.next;
            }
        }
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1;
    }
}
