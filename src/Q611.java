import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * <p>
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 */
public class Q611 {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3)
            return 0;
        int total = 0;
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            if (nums[first] == 0)
                continue;
            for (int second = first + 1, third = first + 2, sum = 0; second < nums.length - 1 && second <= third; second++) {
                int upbound = nums[first] + nums[second];
                while (third < nums.length && nums[third] < upbound) {
                    sum++;
                    third++;
                }
                total += sum;
                sum--;
            }
        }
        return total;
    }

//    public int triangleNumber(int[] nums) {
//        int result = 0;
//        Arrays.sort(nums);
//        for (int i = nums.length - 1; i > 1; i--) {
//            int left = 0, right = i - 1;
//            while (left < right) {
//                if (nums[left] + nums[right] <= nums[i]) {
//                    left++;
//                } else {
//                    result += right - left;
//                    right--;
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(new Q611().triangleNumber(new int[]{2, 2, 3, 4}));
    }
}
