public class Q309 {

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));

    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int[] dp = new int[prices.length];
        int tmp = dp[0] - prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] + tmp);
            tmp = Math.max(tmp, dp[i - 2 < 0 ? 0 : i - 2] - prices[i]);
        }
        return dp[prices.length - 1];
    }
}
