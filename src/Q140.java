import java.util.*;

public class Q140 {

    public static void main(String[] args) {
        System.out.println(new Q140().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(new Q140().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashMap<>());
    }

    public List<String> wordBreak(String s, List<String> wordDict, Map<String, LinkedList<String>> cached) {
        if (cached.containsKey(s))
            return cached.get(s);
        if (s.length() == 0) {
            return Collections.singletonList("");
        }
        LinkedList<String> res = new LinkedList<>();

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = wordBreak(s.substring(word.length()), wordDict, cached);
                for (String str : list) {
                    res.add(word + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        cached.put(s, res);
        return res;
    }
}
