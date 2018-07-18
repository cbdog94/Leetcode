import java.util.*;

public class Q336 {

    public static void main(String[] args) {
//        System.out.println(new Q336().palindromePairs(new String[]{"bat", "tab", "cat"}));
//        System.out.println(new Q336().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(new Q336().palindromePairs(new String[]{"a", ""}));
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                if (isPalindrome(left)) {
                    String rightReverse = new StringBuilder(right).reverse().toString();
                    if (!rightReverse.equals(words[i]) && map.containsKey(rightReverse)) {
                        result.add(Arrays.asList(map.get(rightReverse), i));
                    }
                }
                if (isPalindrome(right)) {
                    String leftReverse = new StringBuilder(left).reverse().toString();
                    if (!leftReverse.equals(words[i]) && map.containsKey(leftReverse) && right.length() != 0) {
                        result.add(Arrays.asList(i, map.get(leftReverse)));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
