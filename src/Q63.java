import java.util.Arrays;

/**
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * 在最上面和最左边虚构一层，初始化第一个、
 */

public class Q63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] step = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1)
                    step[i][j] = 0;
                else {
                    if (i == 1 && j == 1)
                        step[i][j] = 1;
                    else
                        step[i][j] = step[i - 1][j] + step[i][j - 1];
                }
            }
        for (int[] r : step) {
            System.out.println(Arrays.toString(r));
        }
        return step[row][column];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 1, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0}}));

    }
}
