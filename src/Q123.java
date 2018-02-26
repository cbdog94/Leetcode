/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Q123 {

//    public static int maxProfit(int[] prices) {
//        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
//        int release1 = 0, release2 = 0;
//        for (int i : prices) {                              // Assume we only have 0 money at first
////            System.out.println(i);
//            release2 = Math.max(release2, hold2 + i);     // The maximum if we've just sold 2nd stock so far.
//            hold2 = Math.max(hold2, release1 - i);  // The maximum if we've just buy  2nd stock so far.
//            release1 = Math.max(release1, hold1 + i);     // The maximum if we've just sold 1nd stock so far.
//            hold1 = Math.max(hold1, -i);          // The maximum if we've just buy  1st stock so far.
////            System.out.println(release2 + "\n" + hold2 + "\n" + release1 + "\n" + hold1 + "\n---------------");
//        }
//        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
//    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] profit = new int[3][prices.length];
        for (int i = 1; i <= 2; i++) {
// f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
            //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
            int tmpMax = profit[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                profit[i][j] = Math.max(profit[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, profit[i - 1][j] - prices[j]);
            }
        }
        return profit[2][prices.length - 1];
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4, 9}));
        System.out.println(maxProfit(new int[]{1, 2, 4, 3, 5, 7, 2, 4, 9, 0, 12}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 4, 5, 6, 4}));
        System.out.println(maxProfit(new int[]{2, 1, 2, 0, 1}));
    }
}
