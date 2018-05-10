import java.util.ArrayList;
import java.util.List;

public class Q113 {

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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            hasPathSum(root, sum, result, new ArrayList<>());
            return result;

        }

        public void hasPathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> last) {

            if (root.left == null && root.right == null) {
                if (sum == root.val) {
                    last.add(root.val);
                    result.add(new ArrayList<>(last));
                }
            } else if (root.left == null) {
                last.add(root.val);
                hasPathSum(root.right, sum - root.val, result, last);
            } else if (root.right == null) {
                last.add(root.val);
                hasPathSum(root.left, sum - root.val, result, last);
            } else {
                last.add(root.val);
                hasPathSum(root.left, sum - root.val, result, new ArrayList<>(last));
                hasPathSum(root.right, sum - root.val, result, new ArrayList<>(last));
            }
        }
    }
}
