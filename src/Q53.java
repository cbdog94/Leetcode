/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * 最大子段和
 */
public class Q53 {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (tmp < 0)
                tmp = nums[i];
            else
                tmp += nums[i];
//            if (nums[i] < 0) {
            maxSum = Math.max(maxSum, tmp);
//            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1, 2, 3, 4}));
        System.out.println(maxSubArray(new int[]{-1, -2, -3, -4}));
    }
}
