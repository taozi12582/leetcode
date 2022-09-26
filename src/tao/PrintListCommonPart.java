package tao;

public class PrintListCommonPart {
    public static void printListCommonPart(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.value < c2.value) {
                c1 = c1.next;
            } else if (c1.value > c2.value) {
                c2 = c2.next;
            } else {
                System.out.print(c1.value + "\t");
                c1 = c1.next;
                c2 = c2.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = RandomList.generateSortedRandomList(10, 10);
        ListNode l2 = RandomList.generateSortedRandomList(10, 10);
        RandomList.printList(l1,10);
        RandomList.printList(l2,10);
        System.out.println("----------------");
        printListCommonPart(l1,l2);
    }
}
