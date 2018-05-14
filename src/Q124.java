public class Q124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int maxPathSum(TreeNode root) {
            return maxSubSum(root)[1];
        }

        public int[] maxSubSum(TreeNode root) {
            if (root == null)
                return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            int[] left = maxSubSum(root.left);
            int[] right = maxSubSum(root.right);
            int bothSide = root.val + Math.max(0, left[0]) + Math.max(0, right[0]);
            int oneSide = root.val + Math.max(0, Math.max(left[0], right[0]));
            int max = Math.max(Math.max(left[1], right[1]), bothSide);
            return new int[]{oneSide, max};
        }
    }
}