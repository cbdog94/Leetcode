import java.util.LinkedList;
import java.util.Queue;

public class Q934 {
    public static void main(String[] args) {
        System.out.println(new Q934().shortestBridge(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(new Q934().shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
        System.out.println(new Q934().shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}}));
    }

    public int shortestBridge(int[][] A) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[A.length][A[0].length];
        int i, j;
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue, visited);
                    break;
                }
            }
            if (j != A[0].length) {
                break;
            }
        }
//        queue.forEach(x-> System.out.println(Arrays.toString(x)));
        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (i = 0; i < n; i++) {
                int[] t = queue.poll();
                if (t[0] - 1 >= 0 && !visited[t[0] - 1][t[1]]) {
                    if (A[t[0] - 1][t[1]] == 1) {
                        return count;
                    }
                    visited[t[0] - 1][t[1]] = true;
                    queue.offer(new int[]{t[0] - 1, t[1]});
                }
                if (t[0] + 1 < A.length && !visited[t[0] + 1][t[1]]) {
                    if (A[t[0] + 1][t[1]] == 1) {
                        return count;
                    }
                    visited[t[0] + 1][t[1]] = true;
                    queue.offer(new int[]{t[0] + 1, t[1]});
                }
                if (t[1] - 1 >= 0 && !visited[t[0]][t[1] - 1]) {
                    if (A[t[0]][t[1] - 1] == 1) {
                        return count;
                    }
                    visited[t[0]][t[1] - 1] = true;
                    queue.offer(new int[]{t[0], t[1] - 1});
                }
                if (t[1] + 1 < A[0].length && !visited[t[0]][t[1] + 1]) {
                    if (A[t[0]][t[1] + 1] == 1) {
                        return count;
                    }
                    visited[t[0]][t[1] + 1] = true;
                    queue.offer(new int[]{t[0], t[1] + 1});
                }
            }
            count++;
        }
        return count;
    }

    private void dfs(int[][] A, int r, int c, Queue<int[]> queue, boolean[][] visited) {
        if (r < 0 || r >= A.length || c < 0 || c >= A[0].length) {
            return;
        }
        if (A[r][c] == 0 || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        queue.offer(new int[]{r, c});
        dfs(A, r + 1, c, queue, visited);
        dfs(A, r - 1, c, queue, visited);
        dfs(A, r, c + 1, queue, visited);
        dfs(A, r, c - 1, queue, visited);
    }
}
