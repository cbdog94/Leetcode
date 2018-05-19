public class Q108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length);
        }

        private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
            if (left == right)
                return null;
            if (left + 1 == right)
                return new TreeNode(nums[left]);
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, left, mid);
            root.right = sortedArrayToBST(nums, mid + 1, right);
            return root;
        }
    }

}
