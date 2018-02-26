/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class Q153 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left == right - 1)
            return Math.min(nums[left], nums[right]);
        if (left == right)
            return nums[left];
        int mid = (left + right) / 2;
        int min;
        if (nums[mid] > nums[right]) {
            min = Math.min(nums[left], findMin(nums, mid + 1, right));
        } else if (nums[left] > nums[mid]) {
            min = Math.min(nums[mid], findMin(nums, left, mid - 1));
        } else {
            min = Math.min(findMin(nums, left, mid - 1), findMin(nums, mid + 1, right));
        }
        return min;

        //二分如果相等则right--
    }

    public static void main(String[] args) {
        System.out.println(new Q153().findMin(new int[]{6, 7, 0, 1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5}));
        System.out.println(new Q153().findMin(new int[]{3, 4, 5, 6, 7, 0, 1, 2}));
//        System.out.println(new Q153().findMin(new int[]{}));
        System.out.println(new Q153().findMin(new int[]{1}));
        System.out.println(new Q153().findMin(new int[]{3, 3, 1, 3}));
    }
}
