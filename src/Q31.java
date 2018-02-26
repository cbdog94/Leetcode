import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Q31 {

    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int left = -1;
        for (int i = length - 2; i >= 0; i--)
            if (nums[i] < nums[i + 1]) {
                left = i;
                break;
            }
        if (left != -1)
            for (int i = length - 1; i >= 0; i--)
                if (nums[i] > nums[left]) {
                    int t = nums[i];
                    nums[i] = nums[left];
                    nums[left] = t;
                    break;
                }
        Arrays.sort(nums, left + 1, length);
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        nextPermutation(new int[]{});
        nextPermutation(new int[]{1});
        nextPermutation(new int[]{1, 1});
        nextPermutation(new int[]{1, 2, 3});
        nextPermutation(new int[]{3, 2, 1});
        nextPermutation(new int[]{1, 1, 5});
        nextPermutation(new int[]{1, 4, 3, 2});
    }
}
