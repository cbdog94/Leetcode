public class Q445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1, null);
        l2 = reverse(l2, null);
        int c = 0;
        ListNode mock = new ListNode(0), cur = mock;
        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + c) % 10);
            c = (l1.val + l2.val + c) / 10;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            cur.next = new ListNode((l1.val + c) % 10);
            c = (l1.val + c) / 10;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = new ListNode((l2.val + c) % 10);
            c = (l2.val + c) / 10;
            cur = cur.next;
            l2 = l2.next;
        }
        if (c != 0) {
            cur.next = new ListNode(c);
        }
        return reverse(mock.next, null);
    }

    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
