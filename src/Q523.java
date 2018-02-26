import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
 * <p>
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * Note:
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class Q523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(0, -1);
        }};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            if (map.containsKey(sum)) {
                int pre = map.get(sum);
                if (i - pre > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q523().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
//        System.out.println(new Q560().subarraySum(new int[]{1, 2, 3, 4, 5}, 1));
//        System.out.println(new Q560().subarraySum(new int[]{1, 3, 1, 5, 4}, 0));
    }
}
