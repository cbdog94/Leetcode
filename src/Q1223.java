import java.util.Arrays;

public class Q1223 {

    public int dieSimulator(int n, int[] rollMax) {
        long[][] dp = new long[n][7];
        long mod = 1_000_000_007;
        Arrays.fill(dp[0], 1);
        dp[0][6] = 6;
        for (int k = 1; k < n; k++) {
            long sum = 0;
            for (int i = 0; i < 6; i++) {
                dp[k][i] = dp[k - 1][6];
                if (k == rollMax[i]) {
                    dp[k][i] = (dp[k][i] - 1) % mod;
                } else if (k > rollMax[i]) {
                    dp[k][i] = (dp[k][i] - (dp[k - rollMax[i] - 1][6] - dp[k - rollMax[i] - 1][i])) % mod + mod;
                }
                sum = (sum + dp[k][i]) % mod;
            }
            dp[k][6] = sum;
        }
        return (int) dp[n - 1][6];
    }

    public int dieSimulator2(int n, int[] rollMax) {
        long divisor = (long) Math.pow(10, 9) + 7;
        long[][] dp = new long[n][7];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        dp[0][6] = 6;
        for (int i = 1; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < 6; j++) {
                dp[i][j] = dp[i - 1][6];
                System.out.println(i + " " + j + " " + dp[i][j]);
                if (i - rollMax[j] < 0) {
                    sum = (sum + dp[i][j]) % divisor;
                } else {
                    if (i - rollMax[j] - 1 >= 0)
                        dp[i][j] = (dp[i][j] - (dp[i - rollMax[j] - 1][6] - dp[i - rollMax[j] - 1][j])) % divisor
                                + divisor;
                    else
                        dp[i][j] = (dp[i][j] - 1) % divisor;
                    sum = (sum + dp[i][j]) % divisor;
                }
                System.out.println(i + " " + j + " " + dp[i][j]);
            }
            dp[i][6] = sum;
        }
        return (int) (dp[n - 1][6]);
    }

    public static void main(String[] args) {
        System.out.println(new Q1223().dieSimulator(10, new int[] { 2, 7, 1, 2, 6, 5 }));
        System.out.println(new Q1223().dieSimulator2(10, new int[] { 2, 7, 1, 2, 6, 5 }));
    }
}
