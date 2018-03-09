import java.util.LinkedList;
import java.util.List;

public class Q131 {

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("aadaa"));
        System.out.println(partition("amanaplanacanalpanama"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        List<String> current = new LinkedList<>();
        traceback(s, 0, current, result);
        return result;
    }

    public static void traceback(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length())
            result.add(new LinkedList<>(current));
        for (int i = start + 1; i <= s.length(); i++)
            if (isPalindrome(s.substring(start, i))) {
//                System.out.println(s.substring(start, i));
                current.add(s.substring(start, i));
                traceback(s, i, current, result);
                current.remove(current.size() - 1);
            }
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        return true;
    }

}
