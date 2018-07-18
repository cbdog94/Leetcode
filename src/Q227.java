import java.util.Stack;

public class Q227 {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (Character.isDigit(sc[i])) {
                num = num * 10 + sc[i] - '0';
            }
            if (!Character.isDigit(sc[i]) && sc[i] != ' ' || i == sc.length - 1) {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                op = sc[i];
            }
        }
        int total = 0;
        for (Integer item : stack) {
            total += item;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3-5 / 2 "));
    }

}
