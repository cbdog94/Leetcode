import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Q15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;
        Arrays.sort(nums);
        int last1 = nums[0] - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            int current1 = nums[i];
            if (current1 == last1) continue;
            int last2 = nums[i + 1] - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int current2 = nums[j];
                if (current2 == last2) continue;
                if (Arrays.binarySearch(nums, j + 1, nums.length, -(nums[i] + nums[j])) > 0) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(-(nums[i] + nums[j]));
                    result.add(item);
                }
                last2 = current2;
            }
            last1 = current1;
        }
        return result;
    }
/*
    //O(n^2) two pointers binary search solution
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break; //min is > 0, no way to get other res
            if (nums[i] + nums[len -1 ] + nums[len - 2] < 0) continue; //max is < 0, we need to continue the loop to get bigger
            if (i != 0 && nums[i] == nums[i-1]) continue; //avoid duplicates between i and its right
            int low = i + 1, high = len - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] < 0) low++;
                else if (nums[i] + nums[low] + nums[high] > 0) high--;
                else {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                }
            }
        }
        return res;
    }*/

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1}));
    }
}
