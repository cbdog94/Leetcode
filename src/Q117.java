import java.util.LinkedList;
import java.util.Queue;

public class Q117 {


    // Definition for binary tree with next pointer.
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null)
                return;
            Queue<TreeLinkNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                for (int i = 0; i < count; i++) {
                    TreeLinkNode cur = queue.poll();
                    if (i != count - 1)
                        cur.next = queue.peek();
                    if (cur.left != null)
                        queue.offer(cur.left);
                    if (cur.right != null)
                        queue.offer(cur.right);
                }
            }
        }
    }

}
