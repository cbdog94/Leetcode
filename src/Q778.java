import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q778 {
    public static void main(String[] args) {
        System.out.println(new Q778().swimInWater(new int[][]{{0, 2}, {1, 3}}));
        System.out.println(new Q778().swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
    }

    public int swimInWater(int[][] grid) {
        int max = -1;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        queue.add(new int[]{0, 0, grid[0][0]});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            max = Math.max(max, tmp[2]);
            grid[tmp[0]][tmp[1]] = -1;
            if (tmp[0] == grid.length - 1 && tmp[1] == grid.length - 1) {
                return max;
            }
            if (tmp[0] > 0 && grid[tmp[0] - 1][tmp[1]] != -1) {
                queue.add(new int[]{tmp[0] - 1, tmp[1], grid[tmp[0] - 1][tmp[1]]});
            }
            if (tmp[0] < grid.length - 1 && grid[tmp[0] + 1][tmp[1]] != -1) {
                queue.add(new int[]{tmp[0] + 1, tmp[1], grid[tmp[0] + 1][tmp[1]]});
            }
            if (tmp[1] > 0 && grid[tmp[0]][tmp[1] - 1] != -1) {
                queue.add(new int[]{tmp[0], tmp[1] - 1, grid[tmp[0]][tmp[1] - 1]});
            }
            if (tmp[1] < grid.length - 1 && grid[tmp[0]][tmp[1] + 1] != -1) {
                queue.add(new int[]{tmp[0], tmp[1] + 1, grid[tmp[0]][tmp[1] + 1]});
            }
        }
        return max;
    }
}
