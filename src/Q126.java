import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q126 {

    private int len = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(new Q126().findLadders("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> tmp = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        tmp.add(beginWord);
        findLadders(beginWord, endWord, wordList, tmp, result);
        return result;
    }

    public void findLadders(String beginWord, String endWord, List<String> wordList, List<String> tmp, List<List<String>> result) {
        if (beginWord.equals(endWord)) {
            if (tmp.size() < len) {
                len = tmp.size();
                result.clear();
                result.add(new ArrayList<>(tmp));
            } else {
                result.add(new ArrayList<>(tmp));
            }
            return;
        }
        if (tmp.size() >= len) {
            return;
        }
        for (int i = 0; i < beginWord.length(); i++) {
            List<String> nextWords = simWords(beginWord, i, wordList);
            for (String word : nextWords) {
                tmp.add(word);
                wordList.remove(word);
                findLadders(word, endWord, wordList, tmp, result);
                tmp.remove(tmp.size() - 1);
                wordList.add(word);
            }
        }
    }

    public List<String> simWords(String sample, int index, List<String> wordList) {
        List<String> result = new ArrayList<>();
        String sampleRex = sample.substring(0, index) + "." + sample.substring(index + 1);
        for (String word : wordList) {
            if (word.matches(sampleRex) && !word.equals(sample)) {
                result.add(word);
            }
        }
        return result;
    }

}
