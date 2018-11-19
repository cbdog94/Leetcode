import java.util.*;

public class Q373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>(k);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> (x[0] + x[1])));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                queue.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        int n = queue.size();
        for (int i = 0; i < Math.min(n, k); i++) {
            result.add(queue.poll());
        }
        return result;
    }
}
