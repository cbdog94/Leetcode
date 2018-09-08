import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q407 {

    public static void main(String[] args) {
        System.out.println(new Q407().trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}));
    }

    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length, column = heightMap[0].length;
        Queue<Triple> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.height));
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            visited[i][0] = true;
            queue.offer(new Triple(i, 0, heightMap[i][0]));
            visited[i][column - 1] = true;
            queue.offer(new Triple(i, column - 1, heightMap[i][column - 1]));
        }

        for (int i = 1; i < column - 1; i++) {
            visited[0][i] = true;
            queue.offer(new Triple(0, i, heightMap[0][i]));
            visited[row - 1][i] = true;
            queue.offer(new Triple(row - 1, i, heightMap[row - 1][i]));
        }

//        System.out.println(queue.size());

        int water = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            Triple tmp = queue.poll();
            for (int[] dir : dirs) {
                int r = tmp.row + dir[0], c = tmp.column + dir[1];
                if (r >= 0 && r < row && c >= 0 && c < column && !visited[r][c]) {
                    visited[r][c] = true;
                    water += Math.max(0, tmp.height - heightMap[r][c]);
                    queue.offer(new Triple(r, c, Math.max(heightMap[r][c], tmp.height)));
                }
            }
        }

        return water;
    }

    class Triple {
        int row;
        int column;
        int height;

        Triple(int row, int column, int height) {
            this.row = row;
            this.column = column;
            this.height = height;
        }
    }

}
