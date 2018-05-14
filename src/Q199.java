import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null)
                return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                for (int i = 0; i < cnt; i++) {
                    TreeNode tmp = queue.poll();
                    if (tmp.left != null)
                        queue.offer(tmp.left);
                    if (tmp.right != null)
                        queue.offer(tmp.right);
                    if (i == cnt - 1)
                        result.add(tmp.val);
                }
            }
            return result;
        }
    }
}
