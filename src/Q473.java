import java.util.Arrays;

public class Q473 {

    public static void main(String[] args) {
        System.out.println(new Q473().makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(new Q473().makesquare(new int[]{3, 3, 3, 3, 4}));
    }

    public boolean makesquare(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != -1 && !dfs(nums, i, sum / 4)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] nums, int i, int total) {
        if (nums[i] == total) {
            nums[i] = -1;
            return true;
        } else if (nums[i] > total) {
            return false;
        }
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] != -1 && dfs(nums, j, total - nums[i])) {
                nums[j] = -1;
                return true;
            }
        }
        return false;
    }

}
