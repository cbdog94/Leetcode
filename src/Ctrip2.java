import java.util.Scanner;
import java.util.Stack;

public class Ctrip2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack<String> stack = new Stack<>();
//        stack.push("");
        String tmp = "";
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(tmp);
                tmp = "";
            } else if (c == ')') {
                tmp = stack.pop() + new StringBuilder(tmp).reverse();
            } else {
                tmp += c;
            }
        }
        System.out.println(tmp);
    }
}
