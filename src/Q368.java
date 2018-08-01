import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q368 {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
//        List<Integer>[] dp = new List[nums.length ]; 开销大
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        int allMax = 0, allMaxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] > max) {
                        max = dp[j];
                        pre[i] = j;
                    }
                }
            }
            if (max == 0) {
                pre[i] = -1;
            }
            dp[i] = max + 1;
            if (dp[i] > allMax) {
                allMax = dp[i];
                allMaxIndex = i;
            }
        }
        while (allMaxIndex != -1) {
            result.addFirst(nums[allMaxIndex]);
            allMaxIndex = pre[allMaxIndex];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 6, 8, 12}));
        System.out.println(largestDivisibleSubset(new int[]{1}));
        System.out.println(largestDivisibleSubset(new int[]{2, 3, 4, 6, 8}));
    }
}
