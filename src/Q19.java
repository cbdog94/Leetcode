public class Q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, behind = head;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        while (front.next != null) {
            behind = behind.next;
            front = front.next;
        }
        behind.next = behind.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
