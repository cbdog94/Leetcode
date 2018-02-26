import java.util.Arrays;

public class Q300 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{3, 4, -1, 0, 6, 2, 3}));
    }

    //    public static int lengthOfLIS(int[] nums) {
//        ArrayList<Integer> dp = new ArrayList<>();
//        for (int num : nums) {
//            if (dp.size() == 0 || num > dp.get(dp.size() - 1)) {
//                dp.add(num);
//            } else {
//                int i = Collections.binarySearch(dp, num);
//                dp.set(i < 0 ? -i - 1 : i, num);
//            }
//        }
//        return dp.size();
//    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        int max = 0;
        for (int i : dp)
            max = Math.max(max, i);
        return max;
    }
}
