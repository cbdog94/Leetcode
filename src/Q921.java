public class Q921 {
    public static void main(String[] args) {
        System.out.println(new Q921().minAddToMakeValid("())"));
        System.out.println(new Q921().minAddToMakeValid("((("));
        System.out.println(new Q921().minAddToMakeValid("()"));
        System.out.println(new Q921().minAddToMakeValid("()))(("));
    }

    public int minAddToMakeValid(String S) {
        int left = 0, right = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        return left + right;
    }
}
