import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 */
public class Q532 {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int result = 0;
        for (int key : map.keySet()) {
            if (k > 0) {
                if (map.getOrDefault(key + k, 0) > 0)
                    result++;
            } else if (k == 0) {
                if (map.getOrDefault(key, 0) > 1)
                    result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q532().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(new Q532().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(new Q532().findPairs(new int[]{1, 3, 1, 5, 4}, 0));
    }
}
