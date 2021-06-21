public class Q1631 {

    int min = Integer.MAX_VALUE;
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int minimumEffortPath(int[][] heights) {

        backtrack(heights, 0, 0, heights[0][0], 0);
        return min;
    }

    private void backtrack(int[][] grid, int r, int c, int last, int effort) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] == -1) {
            return;
        }

        effort = Math.max(Math.abs(grid[r][c] - last), effort);

        if (effort > min) {
            return;
        }

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            min = Math.min(min, effort);
        }

        for (int[] dir : dirs) {
            int t = grid[r][c];
            grid[r][c] = -1;
            backtrack(grid, r + dir[0], c + dir[1], t, effort);
            grid[r][c] = t;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q1631().minimumEffortPath(new int[][] { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } }));
    }
}
