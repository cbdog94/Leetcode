import java.util.Stack;

public class Q150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (String token : tokens) {
            if ("+".equals(token)) {
                result = stack.pop() + stack.pop();
                stack.push(result);
            } else if ("-".equals(token)) {
                result = -(stack.pop() - stack.pop());
                stack.push(result);
            } else if ("*".equals(token)) {
                result = stack.pop() * stack.pop();
                stack.push(result);
            } else if ("/".equals(token)) {
                int divider = stack.pop();
                result = stack.pop() / divider;
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return result;
    }
}
