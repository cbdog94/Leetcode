public class Q104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
//        public int maxDepth(TreeNode root) {
//            int depth = 0;
//            if (root == null)
//                return depth;
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.offer(root);
//            while (!queue.isEmpty()) {
//                int cnt = queue.size();
//                for (int i = 0; i < cnt; i++) {
//                    TreeNode tmp = queue.poll();
//                    if (tmp.left != null)
//                        queue.offer(tmp.left);
//                    if (tmp.right != null)
//                        queue.offer(tmp.right);
//                }
//                depth++;
//            }
//            return depth;
//        }

        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }


    }

}
