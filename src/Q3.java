import java.util.HashMap;
import java.util.Map;

public class Q3 {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                while (s.charAt(left) != s.charAt(right)) {
                    map.remove(s.charAt(left++));
                }
                left++;
//                System.out.println(left);
            } else {
                map.put(s.charAt(right), 1);
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }
//        System.out.println(left+" "+right);
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
