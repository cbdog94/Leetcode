import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q350 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums2) {
            if (map.containsKey(num)) {
                result[index++] = num;
                int fre = map.get(num);
                if (fre == 1) {
                    map.remove(num);
                } else {
                    map.put(num, fre - 1);
                }
                if (index == result.length) {
                    return result;
                }
            }
        }
        return Arrays.copyOf(result, index);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 3, 4}, new int[]{4, 5, 6})));
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2, 1})));
        System.out.println(Arrays.toString(intersection(new int[]{}, new int[]{})));
    }
}
