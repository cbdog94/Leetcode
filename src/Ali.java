import java.util.*;

public class Ali {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{-1, 0, 1, 2, -1, 4}, 3, 0));
        System.out.println(combinationSum(new int[]{2, 7, 11, 15}, 2, 9));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int k, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<int[]> map = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            map.add(new int[]{candidates[i], i});
        }
        map.sort((o1, o2) -> o1[0] - o2[0]);
        traceback(result, new ArrayList<>(), map, 0, target, k);
        return result;
    }

    private static void traceback(List<List<Integer>> result, List<Integer> tempList, List<int[]> candidates, int current, int target, int k) {
        if (k != 0) {
            for (int i = current; i < candidates.size(); i++) {
                if (i > current && candidates.get(i)[0] == candidates.get(i - 1)[0])
                    continue;
                tempList.add(candidates.get(i)[1]);
                traceback(result, tempList, candidates, i + 1, target - candidates.get(i)[0], k - 1);
                tempList.remove(tempList.size() - 1);
            }

        }
        if (target == 0 && k == 0) {
            result.add(new ArrayList<>(tempList));
        }
    }
}
