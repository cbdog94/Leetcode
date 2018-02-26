/**
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that num[-1] = num[n] = -∞.
 * <p>
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * <p>
 * click to show spoilers.
 * <p>
 * Note:
 * Your solution should be in logarithmic complexity.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class Q162 {
    public int findPeakElement(int[] nums) {
//        if (nums.length == 1)
//            return 0;
        int left = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left)
                left = nums[i];
            else
                return i - 1;
        }
        return nums.length - 1;

        //二分
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right) {
//            int mid = left + (right - left)/2;
//            int mid2 = mid+1;
//            if (nums[mid] < nums[mid2]) {
//                left = mid2;
//            } else {
//                right = mid;
//            }
//        }
//        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Q162().findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(new Q162().findPeakElement(new int[]{1,}));
        System.out.println(new Q162().findPeakElement(new int[]{1, 2}));
        System.out.println(new Q162().findPeakElement(new int[]{-2147483648}));
    }

}
