import java.util.ArrayList;
import java.util.List;

public class Q77 {

    public static void main(String[] args) {
        System.out.println(new Q77().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, 1, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmp, int n, int cur, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = cur; i <= n; i++) {
            tmp.add(i);
            backtrack(result, tmp, n, i + 1, k - 1);
            tmp.remove(tmp.size() - 1);
        }
    }

}
