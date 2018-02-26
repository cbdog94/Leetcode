import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 */
public class Q39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        traceback(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private static void traceback(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int current, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
        } else if (target < 0)
            return;
        else {
            for (int i = current; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                traceback(result, tempList, candidates, i, target - candidates[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{6, 7, 3, 2}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
