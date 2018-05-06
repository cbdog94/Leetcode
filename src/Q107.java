import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null)
                return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                List<Integer> item = new ArrayList<>();
                for (int i = 0; i < cnt; i++) {
                    TreeNode tmpNode = queue.poll();
                    item.add(tmpNode.val);
                    if (tmpNode.left != null)
                        queue.offer(tmpNode.left);
                    if (tmpNode.right != null)
                        queue.offer(tmpNode.right);
                }
                result.add(0, item);
            }
            return result;
        }
    }
}
