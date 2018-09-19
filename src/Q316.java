import java.util.Stack;

public class Q316 {
    public static String removeDuplicateLetters(String s) {
        char[] sc = s.toCharArray();
        int[] fre = new int[26];
        for (char c : sc) {
            fre[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        stack.push((char) 0);
        boolean[] visit = new boolean[26];
        for (char c : sc) {
            if (c < stack.peek()) {
                if (!visit[c - 'a']) {
                    while (c < stack.peek() && (stack.peek() == 0 || fre[stack.peek() - 'a'] > 0)) {
                        int t = stack.pop();
//                    System.out.println((char)t);
                        visit[t - 'a'] = false;
                    }
                    stack.push(c);
                    visit[c - 'a'] = true;
                }
            } else if (c > stack.peek()) {
                if (!visit[c - 'a']) {
                    stack.push(c);
                    visit[c - 'a'] = true;
                }
            }
            fre[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().deleteCharAt(0).toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
        System.out.println(removeDuplicateLetters("cbcdcbca"));
        System.out.println(removeDuplicateLetters("abacb"));
    }
}
