package tao;

public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = RandomList.generateRandomList(10, 20);
        RandomList.printList(head, 10);
        ListNode newHead = reverseShuangxiangList(head);
        RandomList.printList(newHead, 10);
        RandomList.printRList(head,10);
    }

    public static ListNode reverseShuangxiangList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            cur.pre = temp;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
