public class Q279 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " " + numSquares(i));
        }
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, 1 + dp[i - j * j]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
