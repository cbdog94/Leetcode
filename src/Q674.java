public class Q674 {
    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = 1;
        int now = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                now++;
            } else {
                max = Math.max(now, max);
                now = 1;
            }
        }
        max = Math.max(now, max);
        return max;
    }
}
