import java.util.*;

public class Q126 {

    private int len = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(new Q126().findLadders("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }

        wordList.remove(endWord);

        Queue<List<String>> start = new LinkedList<>();
        start.offer(Collections.singletonList(beginWord));
        Queue<List<String>> end = new LinkedList<>();
        end.offer(Collections.singletonList(endWord));

        List<List<String>> result = new ArrayList<>();
        boolean reverse = false;
        while (!start.isEmpty() && !end.isEmpty()) {
            if (start.size() > end.size()) {
                Queue<List<String>> tmp = start;
                start = end;
                end = tmp;
                reverse = !reverse;
            }
            int n = start.size();
            List<String> del = new ArrayList<>();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                List<String> tmp = start.poll();

                for (String cur : wordList) {
                    if (helper(tmp.get(tmp.size() - 1), cur)) {
                        List<String> add = new ArrayList<>(tmp);
                        add.add(cur);
                        start.offer(add);
                        del.add(cur);
//                        if (cur.equals(endWord)) {
//                            result.add(add);
//                            flag = true;
//                        }
                    }
                }

                for (List<String> cur : end) {
                    if (helper(tmp.get(tmp.size() - 1), cur.get(cur.size() - 1))) {
                        flag = true;
                        if (reverse) {
                            List<String> e = new ArrayList<>(tmp);
                            List<String> s = new ArrayList<>(cur);
                            Collections.reverse(e);
                            s.addAll(e);
                            result.add(s);
                        } else {
                            List<String> s = new ArrayList<>(tmp);
                            List<String> e = new ArrayList<>(cur);
                            Collections.reverse(e);
                            s.addAll(e);
                            result.add(s);
                        }
                    }
                }
            }
            if (flag) {
                return result;
            }
            wordList.removeAll(del);
        }
        return result;
    }

    private boolean helper(String tmp, String cur) {
        int count = 0;
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) != cur.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
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
