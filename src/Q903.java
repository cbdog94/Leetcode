import java.util.Arrays;

public class Q903 {
    public static void main(String[] args) {
        System.out.println(new Q903().numPermsDISequence("DID"));
    }

    public int numPermsDISequence(String S) {
        int n = S.length(), mod = 1_000_000_007;
        int[][] dp = new int[n + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            if (S.charAt(i - 1) == 'D') {
                for (int j = n - i, cur = 0; j >= 0; j--) {
                    dp[i][j] = cur = (cur + dp[i - 1][j + 1]) % mod;
                }
            } else {
                for (int j = 0, cur = 0; j <= n - i; j++) {
                    dp[i][j] = cur = (cur + dp[i - 1][j]) % mod;
                }
            }
        }
        return dp[n][0];
    }
}
