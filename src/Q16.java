import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Q16 {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int tmpSum = 0;
            int tmpDelta = Integer.MAX_VALUE;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int tmp = nums[i] + nums[low] + nums[high];
                if (Math.abs(tmp - target) <= tmpDelta) {
                    tmpDelta = Math.abs(tmp - target);
                    tmpSum = tmp;
                    if (tmpDelta < delta) {
                        delta = tmpDelta;
                        sum = tmpSum;
                    }
                }
                if (tmp < target) low++;
                else if (tmp > target) high--;
                else return tmpSum;
            }
        }
        return sum;
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
        System.out.println(threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
        System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
        System.out.println(threeSumClosest(new int[]{-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33}, 0));
    }
}
