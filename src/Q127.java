import java.util.*;

public class Q127 {

    public static void main(String[] args) {
        System.out.println(new Q127().ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
        System.out.println(new Q127().ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            count++;
            for (int i = 0; i < n; i++) {
                String tmp = queue.poll();
                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()) {
                    String cur = iterator.next();
                    if (helper(tmp, cur)) {
                        if (cur.equals(endWord)) {
                            return count;
                        }
                        iterator.remove();
                        queue.offer(cur);
                    }
                }
            }

        }
        return 0;
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

}
