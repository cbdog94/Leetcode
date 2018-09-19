import java.util.List;
import java.util.Stack;

public class Q636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String log : logs) {
            String[] split = log.split(":");
            if ("start".equals(split[1])) {
                if (!stack.empty()) {
                    int[] last = stack.peek();
                    result[last[0]] += Integer.parseInt(split[2]) - last[1];
                }
                stack.push(new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[2])});
            } else {
                int[] cur = stack.pop();
                result[cur[0]] += Integer.parseInt(split[2]) - cur[1] + 1;
                if (!stack.empty()) {
                    int[] last = stack.pop();
                    last[1] = Integer.parseInt(split[2]) + 1;
                    stack.push(last);
                }
            }
        }
        return result;
    }

}
