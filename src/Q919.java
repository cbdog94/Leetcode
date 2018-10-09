import java.util.LinkedList;
import java.util.Queue;

public class Q919 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class CBTInserter {

        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
        }

        public int insert(int v) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode t = queue.poll();
                    if (t.left != null) {
                        queue.offer(t.left);
                    } else {
                        t.left = new TreeNode(v);
                        return t.val;
                    }
                    if (t.right != null) {
                        queue.offer(t.right);
                    } else {
                        t.right = new TreeNode(v);
                        return t.val;
                    }
                }
            }
            return -1;
        }

        public TreeNode get_root() {
            return root;
        }
    }


}
