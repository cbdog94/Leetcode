public class Q114 {

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
        public void flatten(TreeNode root) {
            if (root != null)
                find(root);
        }

        public TreeNode find(TreeNode root) {
            if (root.left == null && root.right == null)
                return root;
            if (root.left != null) {
                TreeNode found = find(root.left);
                found.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            return find(root.right);
        }
    }


}
