/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class Q26 {
    public static int removeDuplicates(int[] nums) {
        int newLength = 1;
        if (nums.length < 2) return nums.length;
        int sample = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != sample) {
                nums[newLength++] = nums[i];
                sample = nums[i];
            }
        }
//        System.out.println(Arrays.toString(nums));
        return newLength;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 2, 3, 3, 4}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 2}));
        System.out.println(removeDuplicates(new int[]{1, 2, 3, 4}));
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 1}));
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{}));
    }
}
