public class Q980 {

    int result = 0;

    public static void main(String[] args) {
        System.out.println(new Q980().uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
        System.out.println(new Q980().uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
        System.out.println(new Q980().uniquePathsIII(new int[][]{{0, 1}, {2, 0}}));
    }

    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int x = -1, y = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        dfs(grid, x, y, count);
        return result;
    }

    private void dfs(int[][] grid, int x, int y, int count) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == -1 || grid[x][y] == 3) {
            return;
        } else if (grid[x][y] == 2) {
            if (count == 0) {
                result++;
            }
            return;
        }
        if (grid[x][y] == 0) {
            count--;
        }
        int t = grid[x][y];
        grid[x][y] = 3;
        dfs(grid, x - 1, y, count);
        dfs(grid, x + 1, y, count);
        dfs(grid, x, y - 1, count);
        dfs(grid, x, y + 1, count);
        grid[x][y] = t;
    }

}
