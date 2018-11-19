import java.util.*;

public class Q218 {

    public static void main(String[] args) {
        new Q218().getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}).forEach(x -> System.out.println(Arrays.toString(x)));
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>(buildings.length * 2);
        List<int[]> result = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new int[]{building[0], -building[2]});
            points.add(new int[]{building[1], building[2]});
        }
        points.sort((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);

        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        queue.offer(0);
        int preMax = 0;
        for (int[] point : points) {
            if (point[1] < 0) {
                queue.offer(-point[1]);
            } else {
                queue.remove(point[1]);
            }
            int curMax = queue.peek();
            if (curMax != preMax) {
                result.add(new int[]{point[0], curMax});
                preMax = curMax;
            }
        }
        return result;
    }
}
