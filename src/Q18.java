import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */

public class Q18 {


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue; //avoid duplicates between i and its right
            res.addAll(threeSum(Arrays.copyOfRange(nums, i + 1, len), nums[i], target - nums[i]));
        }
        return res;
    }


    //O(n^2) two pointers binary search solution
    public static List<List<Integer>> threeSum(int[] nums, int one, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) break; //min is > 0, no way to get other res
            if (nums[i] + nums[len - 1] + nums[len - 2] < target)
                continue; //max is < 0, we need to continue the loop to get bigger
            if (i != 0 && nums[i] == nums[i - 1]) continue; //avoid duplicates between i and its right
            int low = i + 1, high = len - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] < target) low++;
                else if (nums[i] + nums[low] + nums[high] > target) high--;
                else {
                    res.add(Arrays.asList(one, nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
