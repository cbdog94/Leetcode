import java.util.LinkedList;

public class Q695 {

    public static void main(String[] args) {
        int[][] t1 = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(t1));
        int[][] t2 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(t2));

        int[][] t3 = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(maxAreaOfIsland(t3));

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = 0;
                    LinkedList<Integer[]> bfs = new LinkedList<>();
                    bfs.add(new Integer[]{i, j});
                    grid[i][j] = -1;
                    while (!bfs.isEmpty()) {
                        count++;
                        int x = bfs.peek()[0];
                        int y = bfs.peek()[1];
//                        System.out.println("--" + x + " " + y);
                        bfs.pop();
                        if (x > 0 && grid[x - 1][y] == 1) {
                            bfs.push(new Integer[]{x - 1, y});
                            grid[x - 1][y] = -1;
                        }
                        if (x < grid.length - 1 && grid[x + 1][y] == 1) {
                            bfs.push(new Integer[]{x + 1, y});
                            grid[x + 1][y] = -1;
                        }
                        if (y > 0 && grid[x][y - 1] == 1) {
                            bfs.push(new Integer[]{x, y - 1});
                            grid[x][y - 1] = -1;
                        }
                        if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
                            bfs.push(new Integer[]{x, y + 1});
                            grid[x][y + 1] = -1;
                        }
                    }
//                    System.out.println(count);
                    max = Math.max(max, count);
                }
            }
        return max;
    }
}
