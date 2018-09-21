public class Q83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        int tmp = head.val;
        ListNode cur = head;
        while (cur != null && cur.val == tmp) {
            cur = cur.next;
        }
        head.next = deleteDuplicates(cur);
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
