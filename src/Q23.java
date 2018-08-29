public class Q23 {

    public ListNode mergeKLists(ListNode[] lists) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (lists[i].val < min) {
                    min = lists[i].val;
                    minIndex = i;
                }
            }
        }
        if (minIndex == -1) {
            return null;
        }
        ListNode tmp = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        tmp.next = mergeKLists(lists);
        return tmp;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
