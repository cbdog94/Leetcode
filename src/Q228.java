import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Example 2:
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 */
public class Q228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        int start = 0, i;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                result.add(start == i - 1 ? nums[start] + "" : nums[start] + "->" + nums[i - 1]);
                start = i;
            }
        }
        result.add(start == i - 1 ? nums[start] + "" : nums[start] + "->" + nums[i - 1]);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q228().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(new Q228().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(new Q228().summaryRanges(new int[]{0, 2, 4, 6, 8}));
        System.out.println(new Q228().summaryRanges(new int[]{0}));
    }
}
