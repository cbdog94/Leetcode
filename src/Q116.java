import java.util.LinkedList;
import java.util.Queue;

public class Q116 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null)
                return;
            Queue<TreeLinkNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                for (int i = 0; i < cnt; i++) {
                    TreeLinkNode tmp = queue.poll();
                    if (i != cnt - 1)
                        tmp.next = queue.peek();
                    if (tmp.left != null)
                        queue.offer(tmp.left);
                    if (tmp.right != null)
                        queue.offer(tmp.right);
                }
            }
        }
    }

}
