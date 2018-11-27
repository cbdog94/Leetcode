import java.util.HashSet;
import java.util.Set;

public class Q785 {

    public static void main(String[] args) {
        System.out.println(new Q785().isBipartite(new int[][]{{3}, {2, 4}, {1}, {0, 4}, {1, 3}}));
    }

    public boolean isBipartite(int[][] graph) {
        Set<Integer> a = new HashSet<>(), b = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (!a.contains(i) && !b.contains(i)) {
                if (!dfs(i, true, a, b, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int s, boolean aFlag, Set<Integer> a, Set<Integer> b, int[][] graph) {
        if (aFlag) {
            if (b.contains(s)) {
                return false;
            } else if (a.contains(s)) {
                return true;
            }
            a.add(s);
        } else {
            if (a.contains(s)) {
                return false;
            } else if (b.contains(s)) {
                return true;
            }
            b.add(s);
        }
        for (int node : graph[s]) {
            if (!dfs(node, !aFlag, a, b, graph)) {
                return false;
            }
        }
        return true;
    }
}


