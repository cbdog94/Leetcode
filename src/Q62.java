/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 */
//1 1 1 1 1
//1 2 3 4 5
//1 3 6 10 15
//1 4 10 20 35
public class Q62 {
//    public int uniquePaths(int m, int n) {
//        if (m == 1 || n == 1) return 1;
//        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
//    }

    public static int uniquePaths(int m, int n) {
        int[][] step = new int[m][n];
        for (int i = 0; i < n; i++) {
            step[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            step[i][0] = 1;
        }
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                step[i][j] = step[i - 1][j] + step[i][j - 1];
            }
        return step[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(5, 4));
        System.out.println(uniquePaths(5, 3));
        System.out.println(uniquePaths(1, 1));
        System.out.println(uniquePaths(2, 1));
        System.out.println(uniquePaths(4, 4));
    }
}
