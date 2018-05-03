public class Q101 {

    //      Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null)
                return true;
            if (left != null && right != null) {
                if (left.val == right.val)
                    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
                else
                    return false;
            } else
                return false;
        }
    }

    public static void main(String[] args) {

    }
}
