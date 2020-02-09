import java.util.Arrays;

public class Q1335 {
    public static void main(String[] args) {
        System.out.println(new Q1335().minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        System.out.println(new Q1335().minDifficulty(new int[]{9, 9, 9}, 4));
        System.out.println(new Q1335().minDifficulty(new int[]{1, 1, 1}, 3));
        System.out.println(new Q1335().minDifficulty(new int[]{7, 1, 7, 1, 7, 1}, 3));
        System.out.println(new Q1335().minDifficulty(new int[]{11, 111, 22, 222, 33, 333, 44, 444}, 6));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length, maxDiff = 1_000_000;
        int[][] dp = new int[d + 1][n + 1];
        Arrays.fill(dp[0], 0, n, maxDiff);
        for (int i = 1; i <= d; i++) {
            Arrays.fill(dp[i], 0, n, maxDiff);
            for (int j = 0; j < n - i + 1; j++) {
                int max = 0;
                for (int k = j; k < n - i + 1; k++) {
                    max = Math.max(jobDifficulty[k], max);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k + 1] + max);
                }
            }
        }
        return dp[d][0] == maxDiff ? -1 : dp[d][0];
    }
}
