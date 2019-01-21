import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q973 {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (distance(o2) == distance(o1)) {
                    return 0;
                }
                return distance(o2) > distance(o1) ? 1 : -1;
            }
        });
        for (int[] point : points) {
            if (queue.size() < K) {
                queue.add(point);
            } else if (distance(point) < distance(queue.peek())) {
                queue.poll();
                queue.add(point);
            }
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    private double distance(int[] point) {
        double x = point[0] * 1.0, y = point[1] * 1.0;
        return x * x + y * y;
    }

}
