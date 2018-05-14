public class Q129 {

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int sumNumbers(TreeNode root) {
            if (root == null)
                return 0;
            return sumNumbers(root, 0);
        }

        private int sumNumbers(TreeNode root, int previous) {
            if (root.left == null && root.right == null)
                return previous * 10 + root.val;
            if (root.left == null)
                return sumNumbers(root.right, previous * 10 + root.val);
            if (root.right == null)
                return sumNumbers(root.left, previous * 10 + root.val);
            return sumNumbers(root.left, previous * 10 + root.val) + sumNumbers(root.right, previous * 10 + root.val);
        }
    }

}
