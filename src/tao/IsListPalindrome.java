package tao;

import java.util.Stack;

public class IsListPalindrome {
    public static boolean isListPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fp = head, sp = head;
        ListNode mid = null;
        while (fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
        }
        mid = sp;
        ListNode tail = reserveList(mid);
        ListNode l1 = head, l2 = tail;
        boolean flag = true;
        while (l1 != null && l2 != null) {
            if (l1.value != l2.value) {
                flag = false;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        reserveList(tail);
        return flag;
    }

    private static ListNode reserveList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static boolean isListPalindrome_stack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (!stack.empty()) {
            if (stack.pop().value != temp.value) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
//        ListNode l6 = new ListNode(0);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
        RandomList.printList(l1, 1);
        boolean flag = isListPalindrome(l1);
//        boolean flag = isListPalindrome_stack(l1);
        System.out.println(flag);
        RandomList.printList(l1, 1);
    }
}

