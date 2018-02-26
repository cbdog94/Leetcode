import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
//        System.out.println(Arrays.toString(result));
        int tmp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            result[i] *= tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q238().productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Q238().productExceptSelf(new int[]{0, 0})));
    }
}
