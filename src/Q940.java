import java.util.Arrays;

public class Q940 {
    public int distinctSubseqII(String S) {
        int n = S.length(), mod = 1_000_000_007;
        int[] dp = new int[n + 1], last = new int[26];
        dp[0] = 1;
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int c = S.charAt(i) - 'a';
            dp[i + 1] = (dp[i] * 2) % mod;
            if (last[c] >= 0) {
                dp[i + 1] = ((dp[i + 1] + mod) - dp[last[c]]) % mod;
            }
            last[c] = i;
        }
        return (dp[n] + mod - 1) % mod;
    }
}
