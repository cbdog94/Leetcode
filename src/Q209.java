/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * click to show more practice.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class Q209 {

    //滑动窗口，向前滑动end，直到和大于s，向前滑动Start直到和小于s，比较长度
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length, start = 0, sum = 0, minlen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                minlen = Math.min(minlen, i - start + 1);
                sum -= nums[start++];
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }

    public static void main(String[] args) {
        System.out.println(new Q209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Q209().minSubArrayLen(4, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Q209().minSubArrayLen(6, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new Q209().minSubArrayLen(1, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
