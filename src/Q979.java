public class Q979 {
    public int distributeCoins(TreeNode root) {
        return distributeCoins1(root)[0];
    }

    private int[] distributeCoins1(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = distributeCoins1(root);
        int[] right = distributeCoins1(root);
        return new int[]{Math.abs(left[1]) + Math.abs(right[1]) + left[0] + left[1], left[1] + right[1] + 1 - root.val};
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
