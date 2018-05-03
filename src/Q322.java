import java.util.Arrays;

public class Q322 {

    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));

    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != -1)
                    min = Math.min(min, dp[i - coin] + 1);
            }
            if (min != Integer.MAX_VALUE)
                dp[i] = min;
        }
        return dp[amount];
    }

}
