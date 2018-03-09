public class Q264 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int flag2 = 0, flag3 = 0, flag5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (dp[flag2] * 2 < dp[flag3] * 3) {
                if (dp[flag2] * 2 < dp[flag5] * 5) {
                    dp[i] = dp[flag2] * 2;
                    flag2++;
                } else if (dp[flag2] * 2 > dp[flag5] * 5) {
                    dp[i] = dp[flag5] * 5;
                    flag5++;
                } else {
                    dp[i] = dp[flag5] * 5;
                    flag5++;
                    flag2++;
                }
            } else if (dp[flag2] * 2 > dp[flag3] * 3) {
                if (dp[flag3] * 3 < dp[flag5] * 5) {
                    dp[i] = dp[flag3] * 3;
                    flag3++;
                } else if (dp[flag3] * 3 > dp[flag5] * 5) {
                    dp[i] = dp[flag5] * 5;
                    flag5++;
                } else {
                    dp[i] = dp[flag5] * 5;
                    flag5++;
                    flag3++;
                }
            } else {
                if (dp[flag5] * 5 > dp[flag2] * 2) {
                    dp[i] = dp[flag2] * 2;
                    flag3++;
                    flag2++;
                } else if (dp[flag5] * 5 < dp[flag2] * 2) {
                    dp[i] = dp[flag5] * 5;
                    flag5++;
                } else {
                    dp[i] = dp[flag5] * 5;
                    flag5++;
                    flag3++;
                    flag2++;
                }
            }
        }
        return dp[n - 1];
    }

}
