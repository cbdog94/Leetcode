public class Q143 {

    public void reorderList(ListNode head) {
        ListNode cur = head, next = head;
        while (next != null && next.next != null) {
            cur = cur.next;
            next = next.next.next;
        }
        ListNode half = new ListNode(0), tmp;
        half.next = cur;
        while (cur != null) {
            tmp = half.next;
            half.next = cur;
            cur = cur.next;
            half.next.next = tmp;
        }
        cur = head;
        next = half.next;
        while (cur != null) {
            tmp = cur.next;
            cur.next = next;
            next = next.next;
            if (tmp != null) {
                cur.next.next = tmp;
            }
            cur = tmp;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
