import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < cnt; i++) {
                    TreeNode tmp = queue.poll();
                    level.add(tmp.val);
                    if (tmp.left != null)
                        queue.offer(tmp.left);
                    if (tmp.right != null)
                        queue.offer(tmp.right);
                }
                result.add(level);
            }
            return result;
        }


    }

}
