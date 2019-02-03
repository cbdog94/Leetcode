import java.util.LinkedHashMap;

public class Q146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);    // evicts key 2
        cache.put(4, 1);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(2));       // returns 3
    }

    static class LRUCache {

        LinkedHashMap<Integer, Integer> map;
        int capacity;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<>(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int result = map.remove(key);
            map.put(key, result);
            return result;
        }

        public void put(int key, int value) {
            map.put(key, value);
            if (map.size() > capacity) {
                map.remove(map.keySet().iterator().next());
            }
        }
    }

}
