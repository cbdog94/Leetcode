import java.util.Scanner;
import java.util.Stack;


public class SAP2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            System.out.println(helper(s) ? "TRUE" : "FALSE");
        }
    }

    private static boolean helper(String s) {
        Stack<Character> stack = new Stack<>();
//        System.out.println(s);
        char[] sc = s.toCharArray();
        for (char c : sc) {
            switch (c) {
                case '{':
                case '(':
                case '<':
                case '[':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                    break;
                case '>':
                    if (stack.isEmpty() || stack.peek() != '<') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
