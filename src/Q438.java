import java.util.ArrayList;
import java.util.List;

public class Q438 {

    public static void main(String[] args) {
        System.out.println(new Q438().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Q438().findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] sample = new int[26], cur = new int[26];
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        for (int i = 0; i < pc.length; i++) {
            sample[pc[i] - 'a']++;
            cur[sc[i] - 'a']++;
        }
        for (int i = 0; i <= sc.length - pc.length; i++) {
            if (i != 0) {
                cur[sc[i - 1] - 'a']--;
                cur[sc[i + pc.length - 1] - 'a']++;
            }
            if (equal(sample, cur)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean equal(int[] sample, int[] cur) {
        for (int i = 0; i < 26; i++) {
            if (sample[i] != cur[i]) {
                return false;
            }
        }
        return true;
    }
}
