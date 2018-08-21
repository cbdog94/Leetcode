import java.util.Arrays;

public class Q494 {

    public static void main(String[] args) {
        System.out.println(new Q494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i + 1] = sum;
        }
        return dfs(nums, dp, 0, S);
    }

    private int dfs(int[] nums, int[] sum, int start, int target) {
        if (start == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int remain = sum[nums.length] - sum[start];
        if (target > remain || target < -remain) {
            return 0;
        }
        return dfs(nums, sum, start + 1, target - nums[start]) + dfs(nums, sum, start + 1, target + nums[start]);
    }
}
