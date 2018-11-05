import java.util.Arrays;

public class Q935 {

    public static void main(String[] args) {
        System.out.println(new Q935().knightDialer(1));
        System.out.println(new Q935().knightDialer(2));
        System.out.println(new Q935().knightDialer(3));
        System.out.println(new Q935().knightDialer(4));
    }

    public int knightDialer(int N) {
        long[] dp = new long[10];
        int mod = 1_000_000_007;
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            long[] tmp = new long[10];
            tmp[0] = (dp[4] + dp[6]) % mod;
            tmp[1] = (dp[6] + dp[8]) % mod;
            tmp[2] = (dp[7] + dp[9]) % mod;
            tmp[3] = (dp[4] + dp[8]) % mod;
            tmp[4] = (dp[3] + dp[9] + dp[0]) % mod;
            tmp[5] = 0;
            tmp[6] = (dp[1] + dp[7] + dp[0]) % mod;
            tmp[7] = (dp[2] + dp[6]) % mod;
            tmp[8] = (dp[1] + dp[3]) % mod;
            tmp[9] = (dp[2] + dp[4]) % mod;
            dp = tmp;
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[i]) % mod;
        }
        return (int) sum;
    }
}
