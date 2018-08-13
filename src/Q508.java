import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q508 {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        int[] result = new int[list.size()];
        int index = 0;
        for (int sum : list) {
            result[index++] = sum;
        }
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + helper(root.left) + helper(root.right);
        int count = map.getOrDefault(sum, 0);
        count++;
        map.put(sum, count);
        if (count > max) {
            list.clear();
            list.add(sum);
            max = count;
        } else if (count == max) {
            list.add(sum);
        }
        return sum;
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
