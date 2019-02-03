public class Q988 {

    public static void main(String[] args) {

        System.out.println("ad".compareTo("abc"));
    }

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return null;
        }
        String left = smallestFromLeaf(root.left);
        String right = smallestFromLeaf(root.right);
        if (left == null && right == null) {
            return "";
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        if (left.compareTo(right) < 0) {
            return left + (char) ('a' + root.val);
        } else {
            return right + (char) ('a' + root.val);
        }
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
