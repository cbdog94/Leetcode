import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q947 {
    public static void main(String[] args) {
        System.out.println(new Q947().removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(new Q947().removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
        System.out.println(new Q947().removeStones(new int[][]{{0, 0}}));
    }

    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer, List<Integer>> col = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            if (!row.containsKey(stones[i][0])) {
                row.put(stones[i][0], new ArrayList<>());
            }
            if (!col.containsKey(stones[i][1])) {
                col.put(stones[i][1], new ArrayList<>());
            }
            row.get(stones[i][0]).add(i);
            col.get(stones[i][1]).add(i);
        }
        boolean[] visited = new boolean[stones.length];
        int result = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                int cnt = dfs(i, stones, row, col, visited);
                result += cnt - 1;
            }
        }
        return result;
    }

    private int dfs(int s, int[][] stones, Map<Integer, List<Integer>> row, Map<Integer, List<Integer>> col, boolean[] visited) {
        visited[s] = true;
        int[] stone = stones[s];
        int result = 0;
        for (int i : row.get(stone[0])) {
            if (!visited[i]) {
                result += dfs(i, stones, row, col, visited);
            }
        }
        for (int i : col.get(stone[1])) {
            if (!visited[i]) {
                result += dfs(i, stones, row, col, visited);
            }
        }
        return result + 1;
    }
}
