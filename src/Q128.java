import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p>
 * Your algorithm should run in O(n) complexity.
 */
public class Q128 {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, int[]> map = new HashMap<>();
        int max = 1;
        for (int i : nums) {
            if (map.containsKey(i))
                continue;
            map.put(i, new int[]{1, i});
            if (map.containsKey(i - 1)) {
                int[] right = map.get(i - 1);
                int[] left = map.get(right[1]);
                int length = 1 + left[0];
                map.put(right[1], new int[]{length, i});
                map.put(i, new int[]{length, right[1]});
                max = Math.max(max, length);
            }
            if (map.containsKey(i + 1)) {
                int[] rl = map.get(i + 1);
                int[] rr = map.get(rl[1]);
                int[] lr = map.get(i);
                int length = map.get(i)[0] + rr[0];
                map.put(rl[1], new int[]{length, lr[1]});
                map.put(lr[1], new int[]{length, rl[1]});
                max = Math.max(max, length);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{6, 2, 3, 7, 8, 10, 9}));
        System.out.println(longestConsecutive(new int[]{1, 3, 2, 2, 1, 3}));
        System.out.println(longestConsecutive(new int[]{1, 4, 5, 2, 3}));
        System.out.println(longestConsecutive(new int[]{}));
        System.out.println(longestConsecutive(new int[]{1, 1, 1}));
        System.out.println(longestConsecutive(new int[]{5, 4, 3, 2, 1}));
        System.out.println(longestConsecutive(new int[]{1, 2, 3, 4, 5}));
    }

}
