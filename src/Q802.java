import java.util.ArrayList;
import java.util.List;

public class Q802 {
    public static void main(String[] args) {
        System.out.println(new Q802().eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
    }

    /*
        public List<Integer> eventualSafeNodes(int[][] graph) {
            List<Integer>[] reverse = new List[graph.length];
            int[] count = new int[graph.length];
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < graph.length; i++) {
                count[i] = graph[i].length;
                if (graph[i].length == 0) {
                    result.add(i);
                }
                for (int node : graph[i]) {
                    if (reverse[node] == null) {
                        reverse[node] = new ArrayList<>();
                    }
                    reverse[node].add(i);
                }
            }
            int i = 0, n = result.size();
            while (i < n) {
                for (; i < n; i++) {
                    if (reverse[result.get(i)] == null) {
                        continue;
                    }
                    for (int node : reverse[result.get(i)]) {
                        count[node]--;
                        if (count[node] == 0) {
                            result.add(node);
                        }
                    }
                }
                n = result.size();
            }
            Collections.sort(result);
            return result;
        }*/
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int[] color = new int[graph.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, graph, color)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int s, int[][] graph, int[] color) {
        if (color[s] != 0) {
            return color[s] == 1;
        }
        color[s] = 2;
        for (int node : graph[s]) {
            if (!dfs(node, graph, color)) {
                return false;
            }
        }
        color[s] = 1;
        return true;
    }
}
