/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Q268 {
    public int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2;
        for (int i : nums)
            sum -= i;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Q268().missingNumber(new int[]{0, 1, 2, 3, 4, 5, 7}));
        System.out.println(new Q268().missingNumber(new int[]{}));
    }
}
