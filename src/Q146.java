import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Q146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    static class LRUCache {

        int capacity;
        Map<Integer, Integer> values;
        LinkedHashSet<Integer> list = new LinkedHashSet<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            values = new HashMap<>();
        }

        public int get(int key) {
            if (!values.containsKey(key))
                return -1;
            int value = values.get(key);
            list.remove(key);
            list.add(key);
            return value;
        }

        public void put(int key, int value) {
            if (values.containsKey(key)) {
                list.remove(key);
                list.add(key);
                values.put(key, value);
                return;
            }

            if (values.size() == capacity) {
                int evict = list.iterator().next();
                list.remove(evict);
                values.remove(evict);
            }

            list.add(key);
            values.put(key, value);
        }
    }

}
