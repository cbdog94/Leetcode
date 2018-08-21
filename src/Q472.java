import java.util.*;

public class Q472 {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (concatenate(set, word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean concatenate(Set<String> set, String word) {
        for (int i = 1; i < word.length(); i++) {
            if (set.contains(word.substring(0, i))) {
                String right = word.substring(i);
                if (set.contains(right) || concatenate(set, right)) {
                    return true;
                }
            }
        }
        return false;
    }
}
