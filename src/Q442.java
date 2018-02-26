import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [2,3]
 */
public class Q442 {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                continue;
            if (i + 1 != nums[i]) {
                while (i + 1 != nums[i]) {
                    if (nums[i] == nums[nums[i] - 1]) {
                        result.add(nums[i]);
                        break;
                    }
                    int t = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = t;
                }
            }
        }
        return new ArrayList<>(result);
    }

    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.

//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; ++i) {
//            int index = Math.abs(nums[i])-1;
//            if (nums[index] < 0)
//                res.add(Math.abs(index+1));
//            nums[index] = -nums[index];
//        }
//        return res;
//    }

    public static void main(String[] args) {
        System.out.println(new Q442().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(new Q442().findDuplicates(new int[]{}));
    }
}
