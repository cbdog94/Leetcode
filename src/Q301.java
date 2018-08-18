import java.util.ArrayList;
import java.util.List;

public class Q301 {

    public static void main(String[] args) {
        System.out.println(new Q301().removeInvalidParentheses("()())()"));
        System.out.println(new Q301().removeInvalidParentheses("(a)())()"));
        System.out.println(new Q301().removeInvalidParentheses(")("));
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        remove(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
        for (int i = last_i, count = 0; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                count++;
            } else if (s.charAt(i) == par[1]) {
                count--;
            }
            if (count >= 0) {
                continue;
            }
            for (int j = last_j; j <= i; j++) {
                if ((j == 0 || s.charAt(j - 1) != s.charAt(j)) && s.charAt(j) == par[1]) {
                    remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
                }
            }
            return;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(reverse, ans, 0, 0, new char[]{')', '('});
        } else {
            ans.add(reverse);
        }
    }
}
