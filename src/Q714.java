import java.util.Arrays;

public class Q714 {

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));

    }

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1)
            return 0;
        int[] dp = new int[prices.length];
        int tmp = dp[0] - prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] + tmp - fee);
            tmp = Math.max(tmp, dp[i - 1] - prices[i]);
        }
//        System.out.println(Arrays.toString(dp));
        return dp[prices.length - 1];
    }
}
