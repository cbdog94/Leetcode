import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30 {

    public static void main(String[] args) {
//        System.out.println(new Q30().findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
        System.out.println(new Q30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int size = words.length;
        if (size == 0) {
            return result;
        }
        int length = words[0].length();
        Map<String, Integer> histMap = new HashMap<>(size);
        for (String word : words) {
            histMap.put(word, histMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i + size * length <= s.length(); i++) {
            if (histMap.containsKey(s.substring(i, i + length))) {
                Map<String, Integer> curMap = new HashMap<>(size);
                for (int j = 0; j < size; j++) {
                    String word = s.substring(i + j * length, i + (j + 1) * length);
                    curMap.put(word, curMap.getOrDefault(word, 0) + 1);
                }
                if (curMap.equals(histMap)) {
                    result.add(i);
                }
            }
        }
        return result;
    }

}
