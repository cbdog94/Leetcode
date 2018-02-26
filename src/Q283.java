import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Q283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (index != i) {
                    int t = nums[i];
                    nums[i] = nums[index];
                    nums[index] = t;
                }
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Q283().moveZeroes(new int[]{0, 1, 0, 3, 12});
        new Q283().moveZeroes(new int[]{0});
        new Q283().moveZeroes(new int[]{0, 1, 1});
    }
}
