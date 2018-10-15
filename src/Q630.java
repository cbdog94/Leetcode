import java.util.Arrays;
import java.util.PriorityQueue;

public class Q630 {

    public static void main(String[] args) {
        System.out.println(new Q630().scheduleCourse(new int[][]{{1, 2}, {2, 3}}));
        System.out.println(new Q630().scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
        System.out.println(new Q630().scheduleCourse(new int[][]{{5, 15}, {3, 19}, {6, 7}, {2, 10}, {5, 16}, {8, 14}, {10, 11}, {2, 19}}));
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (x, y) -> x[1] - y[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int date = 0;
        for (int[] course : courses) {
            date += course[0];
            queue.offer(course[0]);
            if (date > course[1]) {
                date -= queue.poll();
            }
        }
        return queue.size();
    }
}
