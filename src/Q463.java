public class Q463 {

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int tmp = 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        tmp--;
                    }
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        tmp--;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        tmp--;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        tmp--;
                    }
                    count += tmp;
                }
            }
        }
        return count;
    }


}
