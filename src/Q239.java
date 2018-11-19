import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q239 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        result[index++] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            queue.remove(nums[i - k]);
            queue.offer(nums[i]);
            result[index++] = queue.peek();
        }
        return result;
    }

}
