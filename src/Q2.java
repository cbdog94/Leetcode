public class Q2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, tmp = null;
        int c = 0;
        while (l1 != null || l2 != null || c != 0) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            if (result == null) {
                result = new ListNode((a + b + c) % 10);
                tmp = result;
            } else {
                tmp.next = new ListNode((a + b + c) % 10);
                tmp = tmp.next;
            }
            c = (a + b + c) / 10;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
