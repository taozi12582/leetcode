package tao;

public class ListPartition {
    public static ListNode listPartition(ListNode head, int flag) {
        ListNode SH = null, ST = null;
        ListNode EH = null, ET = null;
        ListNode BH = null, BT = null;
        ListNode temp = head;
        while (temp != null) {
            //节点值小于flag
            if (temp.value < flag) {
                if (SH == null) {
                    SH = temp;
                    ST = temp;
                } else {
                    ST.next = temp;
                    ST = ST.next;
                }
            } else if (temp.value == flag) {
                //节点值等于flag
                if (EH == null) {
                    EH = temp;
                    ET = temp;
                } else {
                    ET.next = temp;
                    ET = ET.next;
                }
            } else {
                if (BH == null) {
                    BH = temp;
                    BT = temp;
                } else {
                    BT.next = temp;
                    BT = BT.next;
                }
            }
            temp = temp.next;
        }
        if (SH != null) {
            if (EH != null) {
                ST.next = EH;
                ET.next = BH;
            } else {
                ST.next = BH;
            }
            return SH;
        } else if (EH != null) {
            ET.next = BH;
            return EH;
        }
        return BH;
    }

    public static void main(String[] args) {
        ListNode head = RandomList.generateRandomList(20, 20);
        RandomList.printList(head, 20);
        head = listPartition(head, 6);
        RandomList.printList(head, 20);
    }
}
