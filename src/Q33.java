/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class Q33 {
//    public static int search(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++)
//            if (nums[i] == target)
//                return i;
//        return -1;
//    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return nums[low] == target ? low : -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7}, 2));
        System.out.println(search(new int[]{4, 5, 6, 7, 1, 2, 3}, 1));
        System.out.println(search(new int[]{4, 5, 6, 7, 1, 2, 3}, 2));
        System.out.println(search(new int[]{4, 5, 6, 7, 1, 2, 3}, 3));
        System.out.println(search(new int[]{4, 5, 6, 7, 1, 2, 3}, 4));
        System.out.println(search(new int[]{4, 5, 6, 7, 1, 2, 3}, 5));
        System.out.println(search(new int[]{4, 5, 6, 7, 1, 2, 3}, 6));
        System.out.println(search(new int[]{4, 5, 6, 7, 1, 2, 3}, 7));
        System.out.println(search(new int[]{4, 5, 6, 7, 1, 2, 3}, 8));
        System.out.println(search(new int[]{3, 1}, 1));
        System.out.println(search(new int[]{}, 8));
        System.out.println(search(new int[]{1}, 8));
        System.out.println(search(new int[]{8}, 8));
    }
}
