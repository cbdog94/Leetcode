import java.util.Scanner;
import java.util.Stack;

public class HW3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(calculate(s));
    }

    private static int calculate(String s) {
        Stack<Character> signStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        char op = '|';
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (Character.isDigit(sc[i])) {
                num = sc[i] - '0';
            }
            if (sc[i] == '(') {
                signStack.push(op);
                numStack.push(num);
                numStack.push(-1);
                op = '|';
                num = 0;
            } else if (sc[i] == ')') {
                if (op == '!') {
                    numStack.push(1 - num);
                } else if (op == '&') {
                    numStack.push(num & numStack.pop());
                } else if (op == '|') {
                    numStack.push(num);
                }
                int t = 0;
                while (numStack.peek() != -1) {
                    t |= numStack.pop();
                }
                numStack.pop();
                num = t;
                op = signStack.pop();
            }
            if ((!Character.isDigit(sc[i]) && sc[i] != '(' && sc[i] != ')') || i == sc.length - 1) {
                if (op == '!') {
                    numStack.push(1 - num);
                } else if (op == '&') {
                    numStack.push(num & numStack.pop());
                } else if (op == '|') {
                    numStack.push(num);
                }
                op = sc[i];
            }

        }
        int total = 0;
        for (Integer item : numStack) {
//            System.out.println(item);
            total |= item;
        }
        return total;
    }
}
