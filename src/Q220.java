import java.util.TreeSet;

public class Q220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i] + t), ceil = set.ceiling(nums[i] - t);
            if (floor != null && floor >= nums[i] || ceil != null && ceil <= nums[i]) {
                return true;
            }
            if (i >= k) {
                set.add(nums[i - k]);
            }
            set.add(nums[i]);
        }
        return false;
    }
}
