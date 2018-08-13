import java.util.*;

public class Q381 {
    class RandomizedCollection {

        Map<Integer, LinkedList<Integer>> map;
        List<Integer> list;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean flag = false;
            if (!map.containsKey(val)) {
                map.put(val, new LinkedList<>());
                flag = true;
            }
            map.get(val).add(list.size());
            list.add(val);
            return flag;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val).getLast();
            map.get(val).removeLast();
            if (map.get(val).isEmpty()) {
                map.remove(val);
            }
            if (index != list.size() - 1) {
                Integer last = list.get(list.size() - 1);
                map.get(last).remove(Integer.valueOf(list.size() - 1));
                map.get(last).add(index);
                list.set(index, last);
            }
            list.remove(list.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }


}
