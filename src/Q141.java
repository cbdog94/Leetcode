public class Q141 {

    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (slow != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
