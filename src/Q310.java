import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q310 {

    public static void main(String[] args) {
        System.out.println(new Q310().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>(n);
//        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() <= 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int parent = graph.get(leaf).iterator().next();
                graph.get(leaf).clear();
                graph.get(parent).remove(leaf);
                if (graph.get(parent).size() == 1) {
                    newLeaves.add(parent);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
