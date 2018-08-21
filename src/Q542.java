import java.util.LinkedList;
import java.util.Queue;

public class Q542 {

    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] tmp = queue.poll();
                int x = tmp[0], y = tmp[1];
                if (x > 0) {
                    if (matrix[x - 1][y] == -1) {
                        matrix[x - 1][y] = matrix[x][y] + 1;
                        queue.offer(new int[]{x - 1, y});
                    } else {
                        matrix[x - 1][y] = Math.min(matrix[x - 1][y], matrix[x][y] + 1);
                    }
                }
                if (x < matrix.length - 1) {
                    if (matrix[x + 1][y] == -1) {
                        matrix[x + 1][y] = matrix[x][y] + 1;
                        queue.offer(new int[]{x + 1, y});
                    } else {
                        matrix[x + 1][y] = Math.min(matrix[x + 1][y], matrix[x][y] + 1);
                    }
                }
                if (y > 0) {
                    if (matrix[x][y - 1] == -1) {
                        matrix[x][y - 1] = matrix[x][y] + 1;
                        queue.offer(new int[]{x, y - 1});
                    } else {
                        matrix[x][y - 1] = Math.min(matrix[x][y - 1], matrix[x][y] + 1);
                    }
                }
                if (y < matrix[0].length - 1) {
                    if (matrix[x][y + 1] == -1) {
                        matrix[x][y + 1] = matrix[x][y] + 1;
                        queue.offer(new int[]{x, y + 1});
                    } else {
                        matrix[x][y + 1] = Math.min(matrix[x][y + 1], matrix[x][y] + 1);
                    }
                }
            }
        }
        return matrix;
    }

}
