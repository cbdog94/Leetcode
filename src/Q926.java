public class Q926 {
    public int minFlipsMonoIncr(String S) {
        char[] sc = S.toCharArray();
        int[][] dp = new int[sc.length + 1][2];
        for (int i = sc.length - 1; i >= 0; i--) {
            if (sc[i] == '0') {
                dp[i][0] = Math.min(dp[i + 1][0], dp[i + 1][1]);
                dp[i][1] = dp[i + 1][1] + 1;
            } else {
                dp[i][0] = dp[i + 1][0] + 1;
                dp[i][1] = dp[i + 1][1];
            }
        }
        return Math.min(dp[0][0], dp[0][1]);
    }
}
