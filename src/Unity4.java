import java.util.Scanner;

public class Unity4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long fee = scanner.nextLong();
        int N = scanner.nextInt();
        long[] nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextLong();
        }
        System.out.println(maxProfit(nums, fee));
    }

    private static long maxProfit(long[] prices, long fee) {
        if (prices.length <= 1) {
            return 0;
        }
        long[] dp = new long[prices.length];
        long tmp = dp[0] - prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] + tmp - fee);
            tmp = Math.max(tmp, dp[i - 1] - prices[i]);
        }
        return dp[prices.length - 1];
    }
}
