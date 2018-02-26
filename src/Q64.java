/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 */

public class Q64 {


    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] step = new int[row][column];
        step[0][0] = grid[0][0];
        for (int i = 1; i < row; i++)
            step[i][0] = step[i - 1][0] + grid[i][0];
        for (int i = 1; i < column; i++)
            step[0][i] = step[0][i - 1] + grid[0][i];
        for (int i = 1; i < row; i++)
            for (int j = 1; j < column; j++)
                step[i][j] = Math.min(step[i - 1][j], step[i][j - 1]) + grid[i][j];
        return step[row - 1][column - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{0, 1, 2}, {1, 3, 4}, {2, 1, 1}}));

    }
}
