import java.util.Arrays;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class Q80 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int currentNum = nums[0];
        int index = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == currentNum)
                times++;
            else {
                currentNum = nums[i];
                times = 1;
            }
            if (times <= 2) {
                nums[index++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{}));
        System.out.println(removeDuplicates(new int[]{1, 1}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 1, 1, 1, 2, 3, 3, 3}));
    }
}
