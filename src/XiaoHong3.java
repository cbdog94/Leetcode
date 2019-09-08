import java.util.Scanner;

public class XiaoHong3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[][] dp = new int[n + 1][2], count = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = dp[i][1] + nums[i];
            count[i + 1][0] = count[i][1] + 1;
            if (dp[i][0] > dp[i][1]) {
                dp[i + 1][1] = dp[i][0];
                count[i + 1][1] = count[i][0];
            } else if (dp[i][0] < dp[i][1]) {
                dp[i + 1][1] = dp[i][1];
                count[i + 1][1] = count[i][1];
            } else {
                dp[i + 1][1] = dp[i][1];
                count[i + 1][1] = Math.min(count[i][1], count[i][0]);
            }
        }

        if (dp[n][0] > dp[n][1]) {
            System.out.println(dp[n][0] + " " + count[n][0]);
        } else if (dp[n][0] < dp[n][1]) {
            System.out.println(dp[n][1] + " " + count[n][1]);
        } else {
            System.out.println(dp[n][1] + " " + Math.min(count[n][1], count[n][0]));
        }
    }
}
