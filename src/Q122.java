/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Q122 {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min)
                profit += prices[i] - min;
            min = prices[i];
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 6, 3, 5, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 4, 5, 6, 4}));
    }
}
