import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Q90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        traceback(nums, result, 0, new ArrayList<>());
        return result;
    }

    private static void traceback(int[] nums, List<List<Integer>> result, int start, List<Integer> tmpList) {
//        if(start==nums.length)
//            return;
        result.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1])
                continue;
            tmpList.add(nums[i]);
            traceback(nums, result, i + 1, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 3}));
        System.out.println(subsetsWithDup(new int[]{1}));
        System.out.println(subsetsWithDup(new int[]{}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 3, 4}));
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(subsetsWithDup(new int[]{1, 3, 2, 2}));
        System.out.println(subsetsWithDup(new int[]{4, 1, 1, 3, 2, 2}));
    }
}
