public class Q111 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            if (root.left == null && root.right == null)
                return 1;
            int depthLeft = Integer.MAX_VALUE, depthRight = Integer.MAX_VALUE;
            if (root.left != null)
                depthLeft = minDepth(root.left);
            if (root.right != null)
                depthRight = minDepth(root.right);
            return Math.min(depthLeft, depthRight) + 1;
        }
    }
}
