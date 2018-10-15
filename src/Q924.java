public class Q924 {

    public static void main(String[] args) {
        System.out.println(new Q924().minMalwareSpread(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 2}));
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int[] group = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (group[i] == 0) {
                boolean[] flag = new boolean[graph.length];
                int count = dfs(graph, i, flag);
                for (int j = 0; j < flag.length; j++) {
                    if (flag[j]) {
                        group[j] = count;
                    }
                }
            }
        }
        int max = 0, maxi = 0;
        for (int in : initial) {
            if (group[in] > max) {
                max = group[in];
                maxi = in;
            } else if (group[in] == max && in < maxi) {
                maxi = in;
            }
        }
        return maxi;
    }

    private int dfs(int[][] graph, int cur, boolean[] flag) {
        int count = 1;
        flag[cur] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[cur][i] == 1 && !flag[i]) {
                count += dfs(graph, i, flag);
            }
        }
        return count;
    }

}
