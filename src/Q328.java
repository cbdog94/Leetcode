public class Q328 {

    public static void main(String[] args) {
        ListNode n1 = new Q328().new ListNode(1);
        ListNode n2 = new Q328().new ListNode(2);
        ListNode n3 = new Q328().new ListNode(3);
        ListNode n4 = new Q328().new ListNode(4);
        ListNode n5 = new Q328().new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        new Q328().oddEvenList(n1);
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode even = head.next, oddCur = head, evenCur = even;
        if (head.next == null || head.next.next == null) {
            return head;
        }

        while (oddCur.next != null) {
            oddCur.next = evenCur.next;
            evenCur.next = oddCur.next.next;
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }

        oddCur.next = even;
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
