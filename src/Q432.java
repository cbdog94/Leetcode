import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Q432 {
    public static void main(String[] args) {
        Q432 q = new Q432();
        AllOne allOne = q.new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMinKey());
        allOne.dec("a");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }

    class AllOne {
        Map<String, Integer> map;
        Map<Integer, HashSet<String>> num;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        /**
         * Initialize your data structure here.
         */
        public AllOne() {
            map = new HashMap<>();
            num = new HashMap<>();
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            int val = map.getOrDefault(key, 0);
            if (val != 0) {
                num.get(val).remove(key);
                if (num.get(val).size() == 0 && min == val) {
                    min = val + 1;
                }
            }
            if (num.get(val + 1) == null) {
                num.put(val + 1, new HashSet<>());
            }
            num.get(val + 1).add(key);
            min = Math.min(val + 1, min);
            max = Math.max(val + 1, max);
            map.put(key, val + 1);
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            int val = map.getOrDefault(key, 0);
            if (val == 0) {
                return;
            }

            num.get(val).remove(key);
            if (num.get(val).size() == 0 && val == max) {
                max = val - 1;
            }
            // if(num.get(val+1)==null){
            //     num.get(val+1)=new HashSet<>();
            // }
            if (val != 1) {
                num.get(val - 1).add(key);
                min = Math.min(val - 1, min);
                max = Math.max(val - 1, max);
            }
            map.put(key, val - 1);
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            if (max == Integer.MIN_VALUE || max == 0) {
                return "";
            }
            return num.get(max).iterator().next();
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            if (max == Integer.MIN_VALUE || max == 0) {
                return "";
            }
            return num.get(min).iterator().next();
        }
    }
}
