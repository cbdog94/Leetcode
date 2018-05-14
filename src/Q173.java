import java.util.ArrayList;
import java.util.List;

public class Q173 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public class BSTIterator {

        private List<Integer> list = new ArrayList<>();
        private int cur, size;

        public BSTIterator(TreeNode root) {
            inOrder(root, list);
            cur = 0;
            size = list.size();
        }

        private void inOrder(TreeNode root, List<Integer> result) {
            if (root == null)
                return;
            inOrder(root.left, result);
            result.add(root.val);
            inOrder(root.right, result);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return cur < size;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return list.get(cur++);
        }
    }
}
