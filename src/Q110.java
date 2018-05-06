public class Q110 {

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
        public boolean isBalanced(TreeNode root) {
            return isBalanced2(root) >= 0;
        }

        public int isBalanced2(TreeNode root) {
            if (root == null)
                return 0;
            int depthLeft = isBalanced2(root.left);
            int depthRight = isBalanced2(root.right);
            if (depthLeft < 0 || depthRight < 0)
                return -1;
            if (Math.abs(depthLeft - depthRight) > 1)
                return -1;
            return Math.max(depthLeft, depthRight) + 1;
        }


    }
}
