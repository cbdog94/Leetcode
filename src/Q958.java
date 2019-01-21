import java.util.LinkedList;
import java.util.Queue;

public class Q958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean NULL = false;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tmp = queue.poll();
                if (tmp == null) {
                    NULL = true;
                } else {
                    if (NULL) {
                        return false;
                    }
                    queue.offer(tmp.left);
                    queue.offer(tmp.right);
                }
            }
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
