public class Q817 {

    public int numComponents(ListNode head, int[] G) {
        boolean[] map = new boolean[10001];
        for (int g : G) {
            map[g] = true;
        }
        boolean flag = false;
        int count = 0;
        while (head != null) {
            if (map[head.val] && !flag) {
                flag = true;
                count++;
            } else if (!map[head.val]) {
                flag = false;
            }
            head = head.next;
        }
        return count;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
