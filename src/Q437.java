public class Q437 {

    public static void main(String[] args) {
        Q437 q437 = new Q437();
        TreeNode n1 = q437.new TreeNode(1);
        TreeNode n2 = q437.new TreeNode(2);
        TreeNode n3 = q437.new TreeNode(3);
        TreeNode n4 = q437.new TreeNode(4);
        TreeNode n5 = q437.new TreeNode(5);
        n1.right = n2;
        n2.right = n3;
        n3.right = n4;
        n4.right = n5;
        System.out.println(q437.new Solution().pathSum(n1, 3));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            return pathSum(root, sum, sum);
        }

        private int pathSum(TreeNode root, int curSum, int sum) {
            if (root == null) {
                return 0;
            }
            System.out.println(root.val + " " + curSum);
            return (curSum == root.val ? 1 : 0) + pathSum(root.left, curSum - root.val, sum) + pathSum(root.right, curSum - root.val, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }
    }
}
