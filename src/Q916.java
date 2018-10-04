import java.util.ArrayList;
import java.util.List;

public class Q916 {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>(A.length);
        int[] mapb = new int[26];
        for (String b : B) {
            int[] tmp = new int[26];
            for (char c : b.toCharArray()) {
                tmp[c - 'a']++;
                mapb[c - 'a'] = Math.max(tmp[c - 'a'], mapb[c - 'a']);
            }
        }
        for (String a : A) {
            if (helper(a, mapb)) {
                result.add(a);
            }
        }
        return result;
    }

    private boolean helper(String a, int[] mapb) {
        int[] mapa = new int[26];
        for (char c : a.toCharArray()) {
            mapa[c - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
            if (mapa[j] < mapb[j]) {
                return false;
            }
        }
        return true;
    }

}
