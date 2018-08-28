public class Q892 {

    public static int surfaceArea(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    sum += (2 + 4 * grid[i][j]);
                } else {
                    continue;
                }
                if (i > 0) {
                    sum -= Math.min(grid[i - 1][j], grid[i][j]);
                }
                if (i < grid.length - 1) {
                    sum -= Math.min(grid[i + 1][j], grid[i][j]);
                }
                if (j > 0) {
                    sum -= Math.min(grid[i][j - 1], grid[i][j]);
                }
                if (j < grid[0].length - 1) {
                    sum -= Math.min(grid[i][j + 1], grid[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
