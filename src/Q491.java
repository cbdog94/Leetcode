import java.util.ArrayList;
import java.util.List;

public class Q491 {

    public static void main(String[] args) {
        System.out.println(new Q491().findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println(new Q491().findSubsequences(new int[]{4, 7, 6, 7}));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> result, List<Integer> tmp) {
        int[] fre = new int[201];
        for (int i = start; i < nums.length; i++) {
            if (fre[nums[i] + 100] == 0) {
                fre[nums[i] + 100]++;
                if (tmp.size() == 0) {
                    tmp.add(nums[i]);
                    dfs(nums, i + 1, result, tmp);
                    tmp.remove(tmp.size() - 1);
                } else if (nums[i] >= tmp.get(tmp.size() - 1)) {
                    tmp.add(nums[i]);
                    result.add(new ArrayList<>(tmp));
                    dfs(nums, i + 1, result, tmp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

}
