import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q854 {

    public static void main(String[] args) {
        System.out.println(new Q854().kSimilarity("ab", "ba"));
        System.out.println(new Q854().kSimilarity("abc", "bca"));
        System.out.println(new Q854().kSimilarity("abac", "baca"));
        System.out.println(new Q854().kSimilarity("aabc", "abca"));
    }

    public int kSimilarity(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(A);
        int result = 0;
        while (!queue.isEmpty()) {
            result++;
            for (int i = queue.size(); i > 0; i--) {
                String s = queue.poll();
                int j = 0;
                while (s.charAt(j) == B.charAt(j)) {
                    j++;
                }
                for (int k = j + 1; k < B.length(); k++) {
                    if (s.charAt(k) == B.charAt(k) || s.charAt(k) != B.charAt(j)) {
                        continue;
                    }
                    String t = swap(s, j, k);
                    if (t.equals(B)) {
                        return result;
                    }
                    if (set.add(t)) {
                        queue.offer(t);
                    }
                }

            }
        }
        return -1;
    }

    private String swap(String s, int j, int k) {
        char[] sc = s.toCharArray();
        char t = sc[j];
        sc[j] = sc[k];
        sc[k] = t;
        return new String(sc);
    }
}
