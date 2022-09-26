package tao;


public class RandomList {
    public static ListNode generateRandomList(int length, int maxValue) {
//        int length = (int) (Math.random() * (maxLength + 1));
        if (length <= 0) {
            return null;
        }
        ListNode head = new ListNode(getRandomValue(maxValue));
        ListNode pre = head;
        for (int i = 1; i < length; i++) {
            ListNode temp = new ListNode(getRandomValue(maxValue));
            pre.next = temp;
            temp.pre = pre;
            pre = temp;
        }
        return head;
    }

    public static ListNode generateSortedRandomList(int length, int maxValue) {
//        int length = (int) (Math.random() * (maxLength + 1));
        if (length <= 0) {
            return null;
        }
        ListNode head = new ListNode(getRandomValue(maxValue));
        ListNode pre = head;
        for (int i = 1; i < length; i++) {
            ListNode temp = new ListNode(getRandomValue(maxValue));
            pre.next = temp;
            temp.pre = pre;
            pre = temp;
        }

        return sortList(head);
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        ListNode curr = head.next;
        ListNode temp = null;
        while (curr != null) {
            temp = tail;
            while (temp != null && curr.value < temp.value) {
                swapListValue(temp, curr);
                curr = temp;
                temp = temp.pre;
            }
            tail = tail.next;
            curr = tail.next;
        }
        return head;
    }

    private static void swapListValue(ListNode temp, ListNode curr) {
        if (temp == curr) {
            return;
        }
        temp.value = temp.value ^ curr.value;
        curr.value = temp.value ^ curr.value;
        temp.value = temp.value ^ curr.value;
    }

    public static void printList(ListNode head, int length) {
        ListNode temp = head;
        for (int i = 0; i < length; i++) {
            System.out.printf("%3d\t", temp.value);
            temp = temp.next;
        }
        System.out.println("");
    }

    public static void printRList(ListNode head, int length) {
        ListNode temp = head;
        for (int i = 0; i < length; i++) {
            System.out.printf("%3d\t", temp.value);
            temp = temp.pre;
        }
        System.out.println("");
    }

    private static int getRandomValue(int maxValue) {
        return (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
    }

    public static void main(String[] args) {
        ListNode head = generateRandomList(10, 40);
        printList(head, 10);
        ListNode sortedNode = sortList(head);
        printList(sortedNode, 10);
    }
}
