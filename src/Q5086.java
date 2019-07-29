import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q5086 {
    public static void main(String[] args) {
        System.out.println(new Q5086().smallestSubsequence("leetcode"));
    }

    public String smallestSubsequence(String text) {
        List<Integer>[] map = new List[26];
        int n = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (map[c - 'a'] == null) {
                map[c - 'a'] = new ArrayList<>();
                n++;
            }
            map[c - 'a'].add(i);
        }
        StringBuilder sb = new StringBuilder();
        int last = -1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 26; i++) {
                int k;
                if (map[i] != null && (k = check(i, last, map)) != -1) {
                    sb.append((char) ('a' + i));
                    map[i] = null;
                    last = k;
                    break;
                }
            }
        }
        return sb.toString();
    }

    private int check(int i, int last, List<Integer>[] map) {
        int min = map[i].get(-Collections.binarySearch(map[i], last) - 1);
        System.out.println(i + " " + min);
        for (int j = 0; j < 26; j++) {
            if (map[j] != null) {
                if (map[j].get(map[j].size() - 1) < min) {
                    return -1;
                }
            }
        }
        System.out.println("----");
        return min;
    }
}
