import java.util.Arrays;
import java.util.Stack;

public class Q503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{Integer.MAX_VALUE});
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] > nums[i]) {
                int[] tmp = stack.pop();
                result[tmp[1]] = nums[i];
            }
            stack.push(new int[]{nums[i], i});
        }
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek()[0] > num) {
                int[] tmp = stack.pop();
                result[tmp[1]] = num;
            }
        }
        return result;
    }
}
