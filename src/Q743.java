import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q743 {

    public static int networkDelayTime(int[][] times, int N, int K) {
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).add(i);
        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE, minIndex = 0;
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    if (dist[j] < min) {
                        min = dist[j];
                        minIndex = j;
                    }
                }
            }
            visited[minIndex] = true;
            for (int index : graph.get(minIndex)) {
                if (dist[minIndex] + times[index][2] < dist[times[index][1]]) {
                    dist[times[index][1]] = dist[minIndex] + times[index][2];
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }
}
