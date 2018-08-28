public class Q410 {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) {
            return (int) sum;
        }
        long left = max, right = sum, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (valid(mid, nums, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private boolean valid(long target, int[] nums, int m) {
        int count = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
