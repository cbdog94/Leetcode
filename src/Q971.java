import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q971 {

    public static void main(String[] args) {
        Q971 q = new Q971();
        TreeNode node1 = q.new TreeNode(1);
        node1.left = q.new TreeNode(5);
        TreeNode node4 = q.new TreeNode(4);
        node4.left = q.new TreeNode(3);
        TreeNode root = q.new TreeNode(2);
        root.left = node1;
        root.right = node4;
        System.out.println(q.flipMatchVoyage(root, new int[]{2, 4, 3, 1, 5}));
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root.val != voyage[0]) {
            return Collections.singletonList(-1);
        }
        List<Integer> result = new ArrayList<>();
        if (flipMatchVoyage(root, voyage, 1, result) != -1) {
            return result;
        }
        return Collections.singletonList(-1);
    }

    private int flipMatchVoyage(TreeNode root, int[] voyage, int i, List<Integer> result) {
        if (i == voyage.length) {
            return i;
        }
        if (root.left == null && root.right == null) {
            return i;
        }
        if (root.left == null && root.right != null) {
            if (root.right.val != voyage[i]) {
                return -1;
            }
            return flipMatchVoyage(root.right, voyage, i + 1, result);
        }
        if (root.left != null && root.right == null) {
            if (root.left.val != voyage[i]) {
                return -1;
            }
            return flipMatchVoyage(root.left, voyage, i + 1, result);
        }
        if (root.left.val == voyage[i]) {
            int pos = flipMatchVoyage(root.left, voyage, i + 1, result);
            if (pos != -1) {
                if (root.right.val == voyage[pos]) {
                    return flipMatchVoyage(root.right, voyage, pos + 1, result);
                } else {
                    return -1;
                }
            } else {
                return -1;
            }

        } else if (root.right.val == voyage[i]) {
            result.add(root.val);
            int pos = flipMatchVoyage(root.right, voyage, i + 1, result);
            if (pos != -1) {
                if (root.left.val == voyage[pos]) {
                    return flipMatchVoyage(root.left, voyage, pos + 1, result);
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
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
