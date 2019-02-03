import java.util.Arrays;

public class Q983 {
    public static void main(String[] args) {
        System.out.println(new Q983().mincostTickets(new int[]{1, 2, 3, 4, 6, 8, 9, 10, 13, 14, 16, 17, 19, 21, 24, 26, 27, 28, 29}, new int[]{3, 14, 50}));
        System.out.println(new Q983().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(new Q983().mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[][] dp = new int[n + 1][3];
        for (int day : days) {
            int index1 = Arrays.binarySearch(days, day - 1);
            if (index1 < 0) {
                index1 = -index1 - 2;
            }
            index1 = index1 < 0 ? 0 : days[index1];
            dp[day][0] = Math.min(dp[index1][0], Math.min(dp[index1][1], dp[index1][2])) + costs[0];

            int index7 = Arrays.binarySearch(days, day - 7);
            if (index7 < 0) {
                index7 = -index7 - 2;
            }
            index7 = index7 < 0 ? 0 : days[index7];
            dp[day][1] = Math.min(dp[index7][0], Math.min(dp[index7][1], dp[index7][2])) + costs[1];

            int index30 = Arrays.binarySearch(days, day - 30);
            if (index30 < 0) {
                index30 = -index30 - 2;
            }
            index30 = index30 < 0 ? 0 : days[index30];
            dp[day][2] = Math.min(dp[index30][0], Math.min(dp[index30][1], dp[index30][2])) + costs[2];
        }
//        for (int i = 0; i <= n; i++) {
//            System.out.println(i + " " + Arrays.toString(dp[i]));
//        }
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
