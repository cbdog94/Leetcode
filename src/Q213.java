public class Q213 {

    public static void main(String[] args) {
//        System.out.println(rob(new int[]{10, 7, 3, 5, 4, 2}));
//        System.out.println(rob(new int[]{1, 2, 3}));
        System.out.println(rob(new int[]{8, 4, 8, 5, 9, 6, 5, 4, 4, 10}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + nums[i + 1], dp2[i - 1]);
        }
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);
    }

}
