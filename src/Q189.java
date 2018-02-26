import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * [show hint]
 * <p>
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II
 */
public class Q189 {
//    public void rotate(int[] nums, int k) {
//        k = k % nums.length;
//        if (k < nums.length / 2)
//            for (int i = 0; i < k; i++) {
//                //swap nums[nums.length-k+i] nums[i]
//                for (int j = 0; j < nums.length - 1; j++) {
//                    int t = nums[nums.length - 1];
//                    nums[nums.length - 1] = nums[j];
//                    nums[j] = t;
//                }
//
//            }
//        else
//            for (int i = 0; i < nums.length - k; i++) {
//                //swap nums[nums.length-k+i] nums[i]
//                for (int j = nums.length - 1; j > 0; j--) {
//                    int t = nums[0];
//                    nums[0] = nums[j];
//                    nums[j] = t;
//                }
//
//            }
//
//        System.out.println(Arrays.toString(nums));
//    }

    //先全局翻转，再根据k点两边翻转
    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int i, int j) {
        int tmp = 0;
        while (i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        new Q189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 0);
        new Q189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 1);
        new Q189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        new Q189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        new Q189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
        new Q189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 5);
        new Q189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 6);
        new Q189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        new Q189().rotate(new int[]{1}, 0);
        new Q189().rotate(new int[]{1, 2}, 3);
    }

}
