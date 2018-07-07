import java.util.Stack;

public class Q20 {

    public static boolean isValid(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : cs) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.empty() || (c - stack.peek()) > 2 || (c - stack.peek()) < 1) {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                default:
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
