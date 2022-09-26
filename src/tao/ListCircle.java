package tao;

public class ListCircle {
    public static ListNode listCircle(ListNode head) {
        ListNode fp = head, sp = head;
        while (fp.next != null && fp.next.next != null) {
            fp = fp.next.next;
            sp = sp.next;
            if (fp == sp) {
                break;
            }
        }
        if (fp.next == null || fp.next.next == null) {
            return null;
        }
        fp = head;
        while (fp != sp) {
            fp = fp.next;
            sp = sp.next;
        }
        return fp;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l4;
        ListNode node = listCircle(l1);
        System.out.println(node == null ? "链表无环" : node.value);
    }
}
