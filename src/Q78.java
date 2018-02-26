import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Q78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        traceback(nums, result, 0, new ArrayList<>());
        return result;
    }

    private static void traceback(int[] nums, List<List<Integer>> result, int start, List<Integer> tmpList) {
//        if(start==nums.length)
//            return;
        result.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            traceback(nums, result, i + 1, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{1}));
        System.out.println(subsets(new int[]{}));
        System.out.println(subsets(new int[]{1, 2, 3, 4}));
    }
}
