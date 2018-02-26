import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class Q41 {
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> missingSet = new HashSet<>();
        Set<Integer> containSet = new HashSet<>();
        missingSet.add(1);
        for (int num : nums) {
            if (num >= 0) {
                containSet.add(num);
                if (!containSet.contains(num + 1))
                    missingSet.add(num + 1);
                missingSet.remove(num);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int n : missingSet) {
            min = Math.min(n, min);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{}));
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{2}));
    }
}
