public class Q343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(1));
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(4));
        System.out.println(integerBreak(5));
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++)
                max = Math.max(Math.max(dp[j], j) * Math.max(dp[i - j], i - j), max);
            dp[i] = max;
        }
        return dp[n];
    }
}
