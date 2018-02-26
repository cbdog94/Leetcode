/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Q27 {

    public static int removeElement(int[] nums, int val) {
        int dupNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                dupNum++;
            } else {
                nums[i - dupNum] = nums[i];
            }
        }
//        System.out.println(Arrays.toString(nums));
        return nums.length - dupNum;
    }


    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1, 1, 2, 2, 3, 3, 4}, 2));
        System.out.println(removeElement(new int[]{1, 1, 2, 2}, 1));
        System.out.println(removeElement(new int[]{1, 2, 3, 4}, 4));
        System.out.println(removeElement(new int[]{1, 1, 1, 1}, 2));
        System.out.println(removeElement(new int[]{1, 1, 1, 1}, 1));
        System.out.println(removeElement(new int[]{1, 2, 3, 2, 3, 2, 1}, 2));
        System.out.println(removeElement(new int[]{1}, 1));
        System.out.println(removeElement(new int[]{}, 1));
    }
}
