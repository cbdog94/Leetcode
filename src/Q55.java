/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class Q55 {

    public static boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        int max = nums[0];
        for (int i = 0; i < max + 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (max >= nums.length - 1)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{1, 2, 3}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{1}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

}
