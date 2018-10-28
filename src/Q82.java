public class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode mock = new ListNode(head.val - 1), cur = head.next, lastNode = head;
        int count = 1;
        while (cur != null) {
            if (cur.val != lastNode.val) {
                if (count == 1) {
                    mock.next = lastNode;
                    mock = mock.next;
                }
                count = 1;
            } else {
                count++;
            }
            lastNode = cur;
            cur = cur.next;
        }
        if (count == 1) {
            mock.next = lastNode;
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
