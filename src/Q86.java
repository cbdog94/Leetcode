public class Q86 {

    public ListNode partition(ListNode head, int x) {
        ListNode left = null, leftCur = null, right = null, rightCur = null;
        while (head != null) {
            if (head.val < x) {
                if (left == null) {
                    left = leftCur = head;
                } else {
                    leftCur.next = head;
                    leftCur = leftCur.next;
                }
                leftCur.next = null;
            } else {
                if (right == null) {
                    right = rightCur = head;
                } else {
                    rightCur.next = head;
                    rightCur = rightCur.next;
                }
                rightCur.next = null;
            }
            head = head.next;
        }
        leftCur.next = right;
        return left;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
