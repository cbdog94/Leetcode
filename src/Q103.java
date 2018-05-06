import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            boolean forward = true;
            while (!stack.empty()) {
                List<Integer> item = new ArrayList<>();
                List<TreeNode> tmpRow = new ArrayList<>();
                while (!stack.empty()) {
                    TreeNode tmpNode = stack.pop();
                    item.add(tmpNode.val);
                    tmpRow.add(tmpNode);
                }
                result.add(item);

                for (TreeNode tmpNode : tmpRow) {
                    if (forward) {
                        if (tmpNode.left != null)
                            stack.push(tmpNode.left);
                        if (tmpNode.right != null)
                            stack.push(tmpNode.right);
                    } else {
                        if (tmpNode.right != null)
                            stack.push(tmpNode.right);
                        if (tmpNode.left != null)
                            stack.push(tmpNode.left);
                    }
                }

                forward = !forward;
                tmpRow.clear();
            }
            return result;
        }
    }
}
