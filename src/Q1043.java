public class Q1043 {
    public static void main(String[] args) {
        System.out.println(new Q1043().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }

    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            int max = A[i];
            for (int j = i; j > Math.max(i - K, -1); j--) {
                max = Math.max(A[j], max);
                dp[i + 1] = Math.max(dp[j] + max * (i - j + 1), dp[i + 1]);
            }
        }
        return dp[A.length];
    }
}
