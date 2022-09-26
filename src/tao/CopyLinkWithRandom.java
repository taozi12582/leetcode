package tao;

import java.util.HashMap;

public class CopyLinkWithRandom {
    public static ListNode copyListWithRandom_1(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            map.put(cur, new ListNode(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).pre = map.get(cur.pre);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static ListNode copyListWithRandom_2(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = new ListNode(curr.value);
            curr.next.next = next;
            curr = next;
        }
        curr = head;
        ListNode curCopy = null;
        //只关心random指针
        while (curr != null) {
            next = curr.next.next;
            curCopy = curr.next;
            curCopy.pre = curr.pre == null ? null : curr.pre.next;
            curr = next;
        }
        ListNode res = head.next;
        curr = head;
        while (curr != null) {
            next = curr.next.next;
            curCopy = curr.next;
            curCopy.next = next == null ? null : next.next;
            curr.next = next;
            curr = next;
        }
        return res;
    }

    public static void main(String[] args) {
        RandomList.generateRandomList(10, 10);
    }
}
