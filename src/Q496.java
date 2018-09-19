import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int num : nums2) {
            if (num < stack.peek()) {
                stack.push(num);
            } else {
                while (!stack.empty() && num > stack.peek()) {
                    int tmp = stack.pop();
                    map.put(tmp, num);
                }
                stack.push(num);
            }
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
