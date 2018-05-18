public class Q337 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int rob(TreeNode root) {
            int[] result = dfs(root);
            return Math.max(result[0], result[1]);
        }

        //[0] include root [1] exclude root
        private int[] dfs(TreeNode root) {
            if (root == null)
                return new int[2];
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int[] result = new int[2];
            result[0] = root.val + left[1] + right[1];
            result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return result;
        }
    }

}
