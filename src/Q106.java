/**
 * Given preorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class Q106 {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, 0, inorder.length);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int postStart, int n) {
        if (n <= 0)
            return null;
        TreeNode node = new TreeNode(postorder[postStart + n - 1]);
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[inStart + i] == postorder[postStart + n - 1]) {
                index = i;
                break;
            }
        }
        //left count=index
        //right count=n-index-1
        node.left = buildTree(inorder, postorder, inStart, postStart, index);
        node.right = buildTree(inorder, postorder, inStart + index + 1, postStart + index, n - index - 1);
        return node;
    }

    public static void test(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.val);
        test(node.left);
        test(node.right);

    }

    public static void main(String[] args) {
//        preorder = {7, 10, 4, 3, 1, 2, 8, 11}
//        inorder = {4, 10, 3, 1, 7, 11, 8, 2}
//        postorder = {4, 1, 3, 10, 11, 8, 2, 7}
        TreeNode Tree1 = buildTree(new int[]{4, 10, 3, 1, 7, 11, 8, 2}, new int[]{4, 1, 3, 10, 11, 8, 2, 7});
        test(Tree1);
        TreeNode Tree2 = buildTree(new int[]{}, new int[]{});
        test(Tree2);
    }
}
