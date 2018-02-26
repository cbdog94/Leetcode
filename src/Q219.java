import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class Q219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = map.getOrDefault(nums[i], -1);
            if (index != -1 && i - index <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
//移除在最大范围外的数，如果添加失败表明在重复数的索引的绝对值在范围内
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Set<Integer> set = new HashSet<Integer>();
//        for(int i = 0; i < nums.length; i++){
//            if(i > k) set.remove(nums[i-k-1]);
//            if(!set.add(nums[i])) return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        System.out.println(new Q219().containsNearbyDuplicate(new int[]{}, 0));
        System.out.println(new Q219().containsNearbyDuplicate(new int[]{1, 2, 3, 4, 1}, 4));
        System.out.println(new Q219().containsNearbyDuplicate(new int[]{1, 2, 3, 4, 1}, 0));
        System.out.println(new Q219().containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 1}, 4));
    }
}
