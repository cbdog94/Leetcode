public class Q92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode mock = new ListNode(0), pre, first, second, third;
        mock.next = head;
        pre = mock;
        int i;
        for (i = 1; i < m; ++i) {
            pre = pre.next;
        }
        first = pre.next;
        second = first.next;
        first.next = null;
        while (i < n) {
            third = second.next;
            first.next = third;
            second.next = pre.next;
            pre.next = second;
            second = third;
            ++i;
        }
        return mock.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
