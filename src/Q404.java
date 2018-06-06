public class Q404 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            if (root != null) {
                dfs(root, false);
            }
            return sum;
        }

        private void dfs(TreeNode root, boolean left) {
            if (root.left == null && root.right == null) {
                if (left) {
                    sum += root.val;
                }
            }
            if (root.left != null) {
                dfs(root.left, true);
            }
            if (root.right != null) {
                dfs(root.right, false);
            }
        }
    }
}
