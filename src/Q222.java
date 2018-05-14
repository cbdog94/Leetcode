public class Q222 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int countNodes(TreeNode root) {
            int node = 0;
            int h = height(root);
            while (root != null) {
                if (height(root.right) == h - 1) {
                    node += 1 << h;
                    root = root.right;
                } else {
                    node += 1 << h - 1;
                    root = root.left;
                }
            }
            return node;
        }

        private int height(TreeNode root) {
            int count = -1;
            while (root != null) {
                root = root.left;
                count++;
            }
            return count;
        }

    }
}
