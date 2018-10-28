public class Q147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mock = new ListNode(0), cur = head, tmp, cur2;
        mock.next = head;
        while (cur.next != null) {
            if (cur.next.val < cur.val) {
                tmp = cur.next;
                cur.next = tmp.next;
                cur2 = mock;
                while (cur2.next != null) {
                    if (tmp.val < cur2.next.val) {
                        tmp.next = cur2.next;
                        cur2.next = tmp;
                        break;
                    }
                    cur2 = cur2.next;
                }
            } else {
                cur = cur.next;
            }
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
