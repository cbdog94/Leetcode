import java.util.Arrays;

public class TSP {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{0, 3, 6, 7}, {5, 0, 2, 3}, {6, 4, 0, 2}, {3, 7, 5, 0}};
        System.out.println(new TSP().tsp(graph));
    }

    private int tsp(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[1 << n - 1][n];//dp[i][j]从j出发经过i集合的点回到0
        int[][] path = new int[1 << n - 1][n];
        for (int j = 1; j < n; j++) {
            dp[0][j] = graph[j][0];
            path[0][j] = 0;
        }
        for (int i = 1; i < 1 << n - 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    int prev = i - (1 << k - 1);
                    if (j != k && prev >= 0 && dp[prev][k] != Integer.MAX_VALUE) {
                        if (graph[j][k] + dp[prev][k] < dp[i][j]) {
                            dp[i][j] = graph[j][k] + dp[prev][k];
                            path[i][j] = k;
                        }
                    }
                }
            }
        }
//        for (int i = 0; i < 1 << n - 1; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        int t = (1 << n - 1) - 1, next = 0;
        while (path[t][next] != 0) {
            System.out.println(path[t][next]);
            next = path[t][next];
            t = t - (1 << next - 1);
        }
        return dp[(1 << n - 1) - 1][0];
    }
}
