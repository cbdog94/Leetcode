import java.util.PriorityQueue;
import java.util.Queue;

public class Q1046 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int a = queue.poll(), b = queue.poll();
            if (a > b) {
                queue.offer(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
