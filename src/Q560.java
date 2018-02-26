import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */
public class Q560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
            sum += i;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q560().subarraySum(new int[]{3, 1, 4, 1, 5}, 5));
//        System.out.println(new Q560().subarraySum(new int[]{1, 2, 3, 4, 5}, 1));
//        System.out.println(new Q560().subarraySum(new int[]{1, 3, 1, 5, 4}, 0));
    }
}
