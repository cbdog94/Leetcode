/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Note:
 * You must not modify the array (assume the array is read only).//所以不能排序
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */

public class Q287 {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                System.out.println(slow + " " + fast);
                slow = nums[slow];//一次移动一步
                fast = nums[nums[fast]];//一次移动两步
            }

            fast = 0;//从头开始，每个都移动一步
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q287().findDuplicate(new int[]{2, 5, 3, 7, 6, 1, 1, 4}));
//        System.out.println(new Q287().findDuplicate(new int[]{2,5,3,7,6,6,1,4}));
    }
}
