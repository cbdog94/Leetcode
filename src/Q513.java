import java.util.LinkedList;
import java.util.Queue;

public class Q513 {

    public static void main(String[] args) {
        Q513 q = new Q513();
        TreeNode root = q.new TreeNode(2);
        TreeNode left = q.new TreeNode(1);
        TreeNode right = q.new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(q.findBottomLeftValue(root));
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftmost = 0;
        while (!queue.isEmpty()) {
            leftmost = queue.peek().val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
        return leftmost;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

}
