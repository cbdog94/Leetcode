import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q230 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            List<Integer> result = new ArrayList<>();
            while (!stack.empty() || cur != null) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                if (result.size() == k - 1)
                    return cur.val;
                else
                    result.add(cur.val);
                cur = cur.right;
            }
            return 0;
        }
    }
}
