import java.util.*;

public class Q987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> result = new ArrayList<>();
        for (Map<Integer, List<Integer>> values : map.values()) {
            List<Integer> item = new ArrayList<>();
            for (List<Integer> rows : values.values()) {
                Collections.sort(rows);
                item.addAll(rows);
            }
            result.add(item);
        }
        return result;
    }

    private void dfs(TreeNode root, int col, int depth, Map<Integer, Map<Integer, List<Integer>>> map) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(col)) {
            map.put(col, new TreeMap<>());
        }
        Map<Integer, List<Integer>> column = map.get(col);
        if (!column.containsKey(depth)) {
            column.put(depth, new ArrayList<>());
        }
        column.get(depth).add(root.val);

        dfs(root.left, col - 1, depth + 1, map);
        dfs(root.right, col + 1, depth + 1, map);
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
