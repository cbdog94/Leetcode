import java.util.ArrayList;
import java.util.List;

public class Q257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null)
                return result;
            dfs(root, "", result);
            return result;
        }

        private void dfs(TreeNode root, String s, List<String> result) {
            if (root.left == null && root.right == null) {
                result.add(s + root.val);
                return;
            }
            if (root.left != null) {
                dfs(root.left, s + root.val + "->", result);

            }
            if (root.right != null) {
                dfs(root.right, s + root.val + "->", result);
            }
        }
    }

}
