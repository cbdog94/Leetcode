import java.util.Arrays;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class Q35 {
//    public static int searchInsert(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++)
//            if (target <= nums[i]) {
//                return i;
//            }
//        return nums.length;
//    }

    public static int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        return result > 0 ? result : -result - 1;
    }


    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 6));

        System.out.println(Arrays.binarySearch(new int[]{1, 3, 5, 6}, 5));
        System.out.println(Arrays.binarySearch(new int[]{1, 3, 5, 6}, 2));
        System.out.println(Arrays.binarySearch(new int[]{1, 3, 5, 6}, 7));
        System.out.println(Arrays.binarySearch(new int[]{1, 3, 5, 6}, 0));
        System.out.println(Arrays.binarySearch(new int[]{1, 3, 5, 6}, 6));
    }
}
