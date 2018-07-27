import java.util.Stack;

public class Q224 {

    public static int calculate(String s) {
        long result = 0, num = 0;
        char sign = '+';
        char[] sc = s.toCharArray();
        Stack<Character> signStack = new Stack<>();
        Stack<Long> numStack = new Stack<>();
        for (int i = 0; i < sc.length; i++) {
            if (Character.isDigit(sc[i])) {
                num = num * 10 + sc[i] - '0';
            } else if (sc[i] == '+' || sc[i] == '-') {
                if (sign == '+') {
                    result += num;
                } else {
                    result -= num;
                }
                num = 0;
                sign = sc[i];
            } else if (sc[i] == '(') {
                signStack.push(sign);
                numStack.push(result);
                sign = '+';
                result = 0;
            } else if (sc[i] == ')') {
                if (sign == '+') {
                    result += num;
                } else {
                    result -= num;
                }
                num = result;
                result = numStack.pop();
                sign = signStack.pop();
            }
            if (i == sc.length - 1) {
                if (sign == '+') {
                    result += num;
                } else {
                    result -= num;
                }
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("3-(2-1)"));
    }
}
