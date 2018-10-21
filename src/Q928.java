import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q928 {

    public static void main(String[] args) {
        System.out.println(new Q928().minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}, new int[]{0, 1}));
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {

        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        Set<Integer> initSet = new HashSet<>();
        for (int init : initial) {
            initSet.add(init);
        }
        int minInit = 1000;
        for (int init : initial) {
            minInit = Math.min(minInit, init);
            dfs(graph, init, init, visited, initSet);

        }
        System.out.println(Arrays.toString(visited));
        int[] fre = new int[graph.length];
        int max = 0, maxi = initial[0];
        for (int v : visited) {
            if (v >= 0) {
                fre[v]++;
                if (fre[v] > max) {
                    max = fre[v];
                    maxi = v;
                } else if (fre[v] == max && v < maxi) {
                    maxi = v;
                }
            }
        }
        return maxi;
    }

    private void dfs(int[][] graph, int cur, int flag, int[] visited, Set<Integer> initSet) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[cur][i] == 1 && !initSet.contains(i)) {
                if (visited[i] == -1) {
                    visited[i] = flag;
                    dfs(graph, i, flag, visited, initSet);
                } else if (visited[i] != flag && visited[i] != -2) {
                    visited[i] = -2;
                    dfs(graph, i, flag, visited, initSet);
                }
            }
        }
    }

}
