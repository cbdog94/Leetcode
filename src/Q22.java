import java.util.ArrayList;
import java.util.List;

public class Q22 {

    public static void main(String[] args) {
        System.out.println(new Q22().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, n, "", result);
        return result;
    }

    public void generateParenthesis(int left, int right, String s, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0)
            generateParenthesis(left - 1, right, s + "(", result);
        if (right > left)
            generateParenthesis(left, right - 1, s + ")", result);
    }

}

