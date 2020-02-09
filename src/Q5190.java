import java.util.Stack;

public class Q5190 {
    public static void main(String[] args) {
        System.out.println(new Q5190().reverseParentheses("(abcd)"));
        System.out.println(new Q5190().reverseParentheses("(u(love)i)"));
        System.out.println(new Q5190().reverseParentheses("(ed(et(oc))el)"));
        System.out.println(new Q5190().reverseParentheses("a(bcdefghijkl(mno)p)q"));
        System.out.println(new Q5190().reverseParentheses(""));
    }

    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        StringBuilder tmp = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(tmp);
                tmp = new StringBuilder();
            } else if (c == ')') {
                tmp = stack.pop().append(tmp.reverse());
            } else {
                tmp.append(c);
            }
        }
        return tmp.toString();
    }
}
