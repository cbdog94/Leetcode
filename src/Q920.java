public class Q920 {
    public static void main(String[] args) {
        System.out.println(new Q920().numMusicPlaylists(3, 3, 0));
        System.out.println(new Q920().numMusicPlaylists(2, 3, 0));
        System.out.println(new Q920().numMusicPlaylists(2, 3, 1));
    }

    public int numMusicPlaylists(int N, int L, int K) {
        int mod = 1000_000_007;
        long[][] dp = new long[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (N - j + 1) + dp[i - 1][j] * Math.max(0, j - K)) % mod;
            }
        }
        return (int) dp[L][N];
    }
}
