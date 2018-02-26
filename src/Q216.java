import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * <p>
 * Output:
 * <p>
 * [[1,2,4]]
 * <p>
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * <p>
 * Output:
 * <p>
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void combinationSum3(List<List<Integer>> result, List<Integer> tmpList, int k, int n, int start) {
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }
        if (start > n)
            return;
        for (int i = start; i <= 9; i++) {
            tmpList.add(i);
            combinationSum3(result, tmpList, k - 1, n - i, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q216().combinationSum3(3, 7));
        System.out.println(new Q216().combinationSum3(3, 9));

    }
}
