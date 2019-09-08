import java.util.Scanner;

public class Tencent4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] company = new int[n], gym = new int[n];
        for (int i = 0; i < n; i++) {
            company[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            gym[i] = scanner.nextInt();
        }
        System.out.println(count(company, gym));
    }

    private static int count(int[] company, int[] gym) {
        int n = company.length;
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            if (company[i] == 1) {
                dp[i + 1][0] = Math.min(dp[i][1], dp[i][2]);
            } else {
                dp[i + 1][0] = Integer.MAX_VALUE;
            }
            if (gym[i] == 1) {
                dp[i + 1][1] = Math.min(dp[i][0], dp[i][2]);
            } else {
                dp[i + 1][1] = Integer.MAX_VALUE;
            }
            dp[i + 1][2] = Math.min(Math.min(dp[i][0], dp[i][1]), dp[i][2]) + 1;
        }
        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
    }

}
