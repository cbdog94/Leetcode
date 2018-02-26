import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Q169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
//            System.out.println(i);
            int times = map.getOrDefault(i, 0);
            times++;
            map.put(i, times);
//            System.out.println(times);
            if (times > nums.length / 2)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Q169().majorityElement(new int[]{1}));
        System.out.println(new Q169().majorityElement(new int[]{1, 2, 3, 4, 4, 4, 4, 4}));
    }
}
