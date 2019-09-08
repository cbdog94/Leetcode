import java.util.Arrays;
import java.util.Scanner;

public class XiaoHong1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        String s = scanner.next();
        String[] splits = s.substring(1, s.length() - 1).split(",");
        int[] nums = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }
        System.out.println(combinationSum(nums, target));
    }

    private static int combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        return backtrack(nums, target, 0);
    }

    private static int backtrack(int[] nums, int remain, int start) {
        if (remain < 0) return 0;
        else if (remain == 0) return 1;
        else {
            int result = 0;
            for (int i = start; i < nums.length; i++) {
                result += backtrack(nums, remain - nums[i], i);
            }
            return result;
        }
    }

}
