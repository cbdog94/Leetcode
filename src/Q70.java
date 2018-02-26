/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * <p>
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class Q70 {
    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= n; i++)
            a[i] = a[i - 1] + a[i - 2];
        return a[n];
    }
}
