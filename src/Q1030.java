import java.util.Arrays;
import java.util.Stack;

public class Q1030 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Q1030().nextLargerNodes()));
    }

    public int[] nextLargerNodes(ListNode head) {
        int[] result = new int[10000];
        int n = 0;
        Stack<int[]> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            while (!stack.empty() && cur.val > stack.peek()[0]) {
                int[] item = stack.pop();
                result[item[1]] = cur.val;
            }
            stack.add(new int[]{cur.val, n});
            cur = cur.next;
            n++;
        }
        return Arrays.copyOf(result, n);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
