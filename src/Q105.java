/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class Q105 {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, preorder.length);
    }

    //offset 中序遍历的起点
    public static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int n) {
//        System.out.println(preStart);
//        System.out.println(inStart);
//        System.out.println(n);
        if (n <= 0)
            return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[inStart + i] == preorder[preStart]) {
                index = i;
                break;
            }
        }
        //left count=index
        //right count=n-index-1
        node.left = buildTree(preorder, inorder, preStart + 1, inStart, index);
        node.right = buildTree(preorder, inorder, preStart + index + 1, inStart + index + 1, n - index - 1);
        return node;
    }

    public static void test(TreeNode node) {
        if (node == null)
            return;

        test(node.left);
        test(node.right);
        System.out.println(node.val);
    }

    public static void main(String[] args) {
//        preorder = {7, 10, 4, 3, 1, 2, 8, 11}
//        inorder = {4, 10, 3, 1, 7, 11, 8, 2}
//        postorder = {4, 1, 3, 10, 11, 8, 2, 7}
        TreeNode Tree1 = buildTree(new int[]{7, 10, 4, 3, 1, 2, 8, 11}, new int[]{4, 10, 3, 1, 7, 11, 8, 2});
        test(Tree1);
        TreeNode Tree2 = buildTree(new int[]{}, new int[]{});
        test(Tree2);
    }
}
