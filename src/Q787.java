import java.util.Arrays;

public class Q787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        int[][] dp = new int[n][K + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 10000000);
            if (graph[src][i] != 0)
                dp[i][0] = graph[src][i];
        }
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < n; j++) {
                dp[j][i] = dp[j][i - 1];
                for (int m = 0; m < n; m++) {
                    if (graph[m][j] != 0) {
                        dp[j][i] = Math.min(dp[j][i], dp[m][i - 1] + graph[m][j]);
                    }
                }
            }
        }
        return dp[dst][K] == 10000000 ? -1 : dp[dst][K];
    }
}
