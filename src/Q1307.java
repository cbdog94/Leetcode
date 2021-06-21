import java.util.*;

public class Q1307 {
    public static void main(String[] args) {
        System.out.println(new Q1307().isSolvable(new String[] { "SEND", "MORE" }, "MONEY"));
        System.out.println(new Q1307().isSolvable(new String[] { "SIX", "SEVEN", "SEVEN" }, "TWENTY"));
        System.out.println(new Q1307().isSolvable(new String[] { "THIS", "IS", "TOO" }, "FUNNY"));
        System.out.println(new Q1307().isSolvable(new String[] { "LEET", "CODE" }, "POINT"));
        System.out.println(new Q1307().isSolvable(new String[] { "AB", "CD", "EF" }, "GHIJ"));
    }

    public boolean isSolvable(String[] words, String result) {
        int[] map = new int[128];
        Arrays.fill(map, -1);
        Set<Character> set = new HashSet<>();
        boolean[] visited = new boolean[10];
        int max = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            max = Math.max(max, word.length());
        }
        if (result.length() - max > 1 || max > result.length()) {
            return false;
        }
        for (char c : result.toCharArray()) {
            set.add(c);
        }
        List<Character> list = new ArrayList<>(set);
        return backtrace(list, map, visited, 0, words, result);
    }

    private boolean backtrace(List<Character> list, int[] map, boolean[] visited, int s, String[] words,
            String result) {
        boolean res = check(map, words, result);
        if (!res) {
            return false;
        } else if (s == list.size()) {
            // System.out.println(map);
            return true;
        }
        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                map[list.get(s)] = i;
                if (backtrace(list, map, visited, s + 1, words, result)) {
                    return true;
                }
                map[list.get(s)] = -1;
                visited[i] = false;
            }
        }
        return false;
    }

    private boolean check(int[] map, String[] words, String result) {
        if (map[result.charAt(0)] == 0) {
            return false;
        }
        for (int i = 0, carry = 0; i < 7; i++) {
            int known = 0, unknown = 0;
            for (String word : words) {
                if (map[word.charAt(0)] == 0) {
                    return false;
                }
                if (word.length() - i > 0) {
                    char c = word.charAt(word.length() - 1 - i);
                    if (map[c] != -1) {
                        known += map[c];
                    } else {
                        unknown++;
                    }
                }
            }
            if (unknown > 0) {
                return true;
            }
            if (result.length() - i > 0) {
                char c = result.charAt(result.length() - 1 - i);
                if (map[c] != -1) {
                    if ((known + carry) % 10 != map[c]) {
                        return false;
                    } else {
                        carry = (known + carry) / 10;
                    }
                } else {
                    return true;
                }
            } else if (carry != 0) {
                return false;
            }
        }
        return true;
    }
}
