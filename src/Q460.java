import java.util.*;

public class Q460 {

    static class LFUCache {

        Map<Integer, Integer> values;
        Map<Integer, Integer> fre;
        Map<Integer, LinkedHashSet<Integer>> list;
        int minFre = 0;
        int cap;

        public LFUCache(int capacity) {
            cap = capacity;
            values = new HashMap<>();
            fre = new HashMap<>();
            list = new HashMap<>();
            list.put(1, new LinkedHashSet<>());
        }

        public int get(int key) {
            if (!values.containsKey(key)) {
                return -1;
            }
            int count = fre.get(key);
            list.get(count).remove(key);
            fre.put(key, count + 1);
            if (count == minFre && list.get(count).size() == 0) //当前取得是最小频率并且取完后最小频率为空
                minFre++;
            if (list.get(count + 1) == null)
                list.put(count + 1, new LinkedHashSet<>());
            list.get(count + 1).add(key);
            return values.get(key);
        }

        public void put(int key, int value) {
            if (cap <= 0)
                return;
            if (values.containsKey(key)) {
                values.put(key, value);
                get(key);
                return;
            }
            if (values.size() >= cap) {
                int evict = list.get(minFre).iterator().next();
//                System.out.println(evict);
                list.get(minFre).remove(evict);
                fre.remove(evict);
                values.remove(evict);
            }
            minFre = 1;
            fre.put(key, 1);
            list.get(1).add(key);
            values.put(key, value);
        }

    }

    public static void main(String[] args) {

        LFUCache cache = new LFUCache(0 /* capacity */);
        System.out.println(cache.get(0));
        cache.put(0, 0);
        System.out.println(cache.get(0));
//        cache.get(1);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println( cache.get(1));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println( cache.get(2));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3.
//        cache.put(4, 4);    // evicts key 1.
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4

    }


}
