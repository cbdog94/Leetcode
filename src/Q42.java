import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q42 {

    public int trap(int[] height) {
        int n = height.length;
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.height));
        boolean[] visited = new boolean[n];

        visited[0] = true;
        queue.offer(new Pair(0, height[0]));
        visited[n - 1] = true;
        queue.offer(new Pair(n - 1, height[n - 1]));

        int water = 0;
        int[] dirs = new int[]{-1, 1};
        while (!queue.isEmpty()) {
            Pair tmp = queue.poll();
            for (int dir : dirs) {
                int i = tmp.index + dir;
                if (i >= 0 && i < n && !visited[i]) {
                    visited[i] = true;
                    water += Math.max(0, tmp.height - height[i]);
                    queue.offer(new Pair(i, Math.max(height[i], tmp.height)));
                }
            }
        }

        return water;
    }

    class Pair {
        int index;
        int height;

        Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }

    }
}
