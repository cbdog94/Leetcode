public class Q174 {

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(dungeon));
        dungeon = new int[][]{{0}};
        System.out.println(calculateMinimumHP(dungeon));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int column = dungeon[0].length;
        int[][] dp = new int[row][column];
        dp[row - 1][column - 1] = Math.max(1 - dungeon[row - 1][column - 1], 1);
        for (int i = column - 2; i >= 0; i--)
            dp[row - 1][i] = Math.max(dp[row - 1][i + 1] - dungeon[row - 1][i], 1);
        for (int i = row - 2; i >= 0; i--)
            dp[i][column - 1] = Math.max(dp[i + 1][column - 1] - dungeon[i][column - 1], 1);
        for (int i = row - 2; i >= 0; i--) {
            for (int j = column - 2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
