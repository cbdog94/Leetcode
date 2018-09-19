import java.util.ArrayList;
import java.util.List;

public class Q46 {

    public static void main(String[] args) {
        System.out.println(new Q46().permute(new int[]{1, 2, 3, 4}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            tmp.add(nums[i]);
            backtrack(result, tmp, nums, used);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

}
