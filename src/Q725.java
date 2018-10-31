public class Q725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        ListNode cur = root;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        int base = length / k, add = length % k;
        for (int i = 0; i < k; i++) {
            result[i] = root;
            int offset = add-- > 0 ? 1 : 0;
            for (int j = 0; j < base + offset - 1; j++) {
                root = root.next;
            }
            if (root != null) {
                cur = root.next;
                root.next = null;
                root = cur;
            }
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
