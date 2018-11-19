import java.util.*;

public class Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        Queue<Pair> queue = new PriorityQueue<>((x, y) -> x.count == y.count ? x.word.compareTo(y.word) : y.count - x.count);
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int count = map.getOrDefault(word, 0);
            queue.offer(new Pair(word, count + 1));
            map.put(word, count + 1);
        }
        List<String> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            Pair p = queue.poll();
            while (!map.containsKey(p.word)) {
                p = queue.poll();
            }
            result.add(p.word);
            map.remove(p.word);
        }
        return result;
    }

    class Pair {
        String word;
        int count;

        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
