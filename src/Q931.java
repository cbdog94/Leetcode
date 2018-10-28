import java.util.Arrays;

public class Q931 {


    public static void main(String[] args) {
        System.out.println(new Q931().minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Q931().minFallingPathSum(new int[][]{{69}}));
    }

    public int minFallingPathSum(int[][] A) {
        if (A.length == 1) {
            return A[0][0];
        }
        int[][] dp = new int[2][A.length];
        for (int[] row : A) {
            for (int j = 0; j < A.length; j++) {
                if (j == 0) {
                    dp[1][0] = Math.min(dp[0][0], dp[0][1]) + row[0];
                } else if (j == A.length - 1) {
                    dp[1][A.length - 1] = Math.min(dp[0][A.length - 1], dp[0][A.length - 2]) + row[A.length - 1];
                } else {
                    dp[1][j] = Math.min(Math.min(dp[0][j - 1], dp[0][j]), dp[0][j + 1]) + row[j];
                }
            }
            dp[0] = Arrays.copyOf(dp[1], A.length);
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[0]) {
            min = Math.min(min, num);
        }
        return min;
    }
}
