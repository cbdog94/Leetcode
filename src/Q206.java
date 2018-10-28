public class Q206 {

    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

//    public ListNode reverseList(ListNode head) {
//        ListNode prev = head, next, tmp;
//        if (prev == null) {
//            return head;
//        }
//        next = prev.next;
//        prev.next = null;
//        while (next != null) {
//            tmp = next.next;
//            next.next = prev;
//            prev = next;
//            next = tmp;
//        }
//        return prev;
//    }

    private ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
