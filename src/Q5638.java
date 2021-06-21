import java.util.PriorityQueue;
import java.util.Queue;

public class Q5638 {
    public int eatenApples(int[] apples, int[] days) {
        int max = 0;
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int i;
        for (i = 0; i < apples.length; i++) {
            for (int j = 0; j < apples[i]; j++) {
                queue.offer(i + days[i]);
            }
            boolean flag = false;
            while (queue.size() > 0) {
                int t = queue.poll();
                if (t > i) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                max++;
            }
        }
        while (queue.size() > 0) {
            boolean flag = false;
            int t = queue.poll();
            if (t > i) {
                i++;
                flag = true;
            }
            if (flag) {
                max++;
            }
        }
        return max;
    }
}
