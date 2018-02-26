import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class Q40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        traceback(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private static void traceback(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int current, int target) {
        if (target > 0) {
            for (int i = current; i < candidates.length; i++) {
                if (i > current && candidates[i] == candidates[i - 1]) continue;
                tempList.add(candidates[i]);
                traceback(result, tempList, candidates, i + 1, target - candidates[i]);
                tempList.remove(tempList.size() - 1);
            }

        } else if (target == 0)
            result.add(new ArrayList<>(tempList));

    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 7));
    }
}
