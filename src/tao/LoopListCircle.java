package tao;

public class LoopListCircle {
    public static ListNode findNode(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode loop1 = findLoopNode(l1);
        ListNode loop2 = findLoopNode(l2);
        if (loop1 == null && loop2 == null) {
            return findNodeWithoutLoop(l1, l2);
        }
        if (loop1 == null || loop2 == null) {
            return null;
        }
        if (loop1 == loop2) {
            return loop1;
        }
        ListNode ct = loop1.next;
        while (ct != loop1) {
            if (ct == loop2) {
                return ct;
            }
            ct = ct.next;
        }
        return null;
    }

    private static ListNode findLoopNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
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

    private static ListNode findNodeWithoutLoop(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        int len1 = 1, len2 = 1;
        while (p1.next != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2.next != null) {
            len2++;
            p2 = p2.next;
        }
        if (p1 != p2) {
            return null;
        }
        int diff = len1 - len2;
        p1 = l1;
        p2 = l2;
        if (diff > 0) {
            //l1比l2长
            for (int i = 0; i < diff; i++) {
                p1 = p1.next;
            }
        } else if (diff < 0) {
            for (int i = 0; i < -diff; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        //两无环 不相交
//        l1.next = l2;
//        l2.next = l3;
//        l4.next = l5;
//        l5.next = l6;
        //两无环 相交
//        l1.next = l3;
//        l3.next = l5;
//        l5.next = l6;
//        l2.next = l4;
//        l4.next = l5;
        //一有环一无环
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l2;
//        l5.next = l6;
        //两有环不相交
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l2;
//        l5.next = l6;
//        l6.next = l5;
        //两有环入环相同
//        l1.next = l3;
//        l3.next = l5;
//        l5.next = l6;
//        l6.next = l5;
//        l2.next = l4;
//        l4.next = l5;
        //两链表有环入环不同
        l1.next = l6;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l4;
        ListNode node = findNode(l1, l2);
        System.out.println(node == null ? "链表无环" : node.value);
    }
}
