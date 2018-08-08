import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q349 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums2) {
            if (set1.contains(num)) {
                result[index++] = num;
                set1.remove(num);
                if (index == result.length) {
                    return result;
                }
            }
        }
        return Arrays.copyOf(result, index);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 3, 4}, new int[]{4, 5, 6})));
        System.out.println(Arrays.toString(intersection(new int[]{}, new int[]{})));
    }
}
